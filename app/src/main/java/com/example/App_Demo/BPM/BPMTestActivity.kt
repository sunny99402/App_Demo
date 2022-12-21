package com.example.App_Demo.BPM

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import com.example.App_Demo.Global
import com.example.App_Demo.LogListAdapter
import com.ideabus.ideabuslibrary.util.BaseUtils
import com.ideabus.model.bluetooth.MyBluetoothLE
import com.ideabus.model.data.*
import com.ideabus.model.protocol.BPMProtocol

class BPMTestActivity : ComponentActivity(), BPMProtocol.OnConnectStateListener,
    View.OnClickListener, BPMProtocol.OnDataResponseListener, BPMProtocol.OnNotifyStateListener,
    MyBluetoothLE.OnWriteStateListener {
    val TAG = "BPMTestActivity"
    var logListAdapter: LogListAdapter? = null
    var isConnecting = false
    //view model
    private val vm by viewModels<BPMViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Initialize the body ester machine Bluetooth module
        initParam()
        //build database
        vm.liveData.observe(this) {}
        //if connected, read history
        val connectState by mutableStateOf(vm.isConnected)
        if(connectState) {
            Global.bpmProtocol!!.readHistorysOrCurrDataAndSyncTiming()
        }
        setContent {
            BPMScreen(model = vm)
        }
    }

    private fun initParam() {
        //Initialize the connection SDK
        Global.bpmProtocol = BPMProtocol.getInstance(this, false, true, Global.sdkid_BPM)
        logListAdapter = LogListAdapter()
    }

    override fun onStart() {
        Log.d(TAG, "1026 onStart")
        super.onStart()

        Global.bpmProtocol!!.setOnConnectStateListener(this)
        Global.bpmProtocol!!.setOnDataResponseListener(this)
        Global.bpmProtocol!!.setOnNotifyStateListener(this)
        Global.bpmProtocol!!.setOnWriteStateListener(this)
        startScan()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (Global.bpmProtocol!!.isConnected) Global.bpmProtocol!!.disconnect()
        Global.bpmProtocol!!.stopScan()
    }

    override fun onStop() {
        super.onStop()
        Global.bpmProtocol!!.disconnect()
        Global.bpmProtocol!!.stopScan()
    }

    private fun startScan() {
        if (!Global.bpmProtocol!!.isSupportBluetooth(this)) {
            Log.d(TAG, "1026 not support Bluetooth")
            return
        }
        vm.setConnectState("start scan")
        logListAdapter?.addLog("start scan")
        Global.bpmProtocol!!.startScan(10)
    }

    override fun onClick(v: View) {
    }

    override fun onWriteMessage(isSuccess: Boolean, message: String) {
        logListAdapter?.addLog("WRITE : $message")
    }

    override fun onNotifyMessage(message: String) {
        logListAdapter?.addLog("NOTIFY : $message")
    }

    override fun onResponseReadHistory(dRecord: DRecord) {
        logListAdapter?.addLog("BPM : ReadHistory -> DRecord = $dRecord")
        //build database
        vm.setDRecord(dRecord)
        vm.insertDatabase()
    }

    override fun onResponseClearHistory(isSuccess: Boolean) {
        logListAdapter?.addLog("BPM : ClearHistory -> isSuccess = $isSuccess")
    }

    override fun onResponseReadUserAndVersionData(user: User, versionData: VersionData) {
        logListAdapter?.addLog(
            "BPM : ReadUserAndVersionData -> user = " + user +
                    " , versionData = " + versionData
        )
    }

    override fun onResponseWriteUser(isSuccess: Boolean) {
        logListAdapter?.addLog("BPM : WriteUser -> isSuccess = $isSuccess")
    }

    override fun onResponseReadLastData(
        dRecord: CurrentAndMData,
        historyMeasuremeNumber: Int,
        userNumber: Int,
        MAMState: Int,
        isNoData: Boolean
    ) {
        logListAdapter?.addLog(
            "BPM : ReadLastData -> DRecord = " + dRecord +
                    " historyMeasuremeNumber = " + historyMeasuremeNumber +
                    " userNumber = " + userNumber + " MAMState = " + MAMState +
                    " isNoData = " + isNoData
            )
    }

    override fun onResponseClearLastData(isSuccess: Boolean) {
        logListAdapter?.addLog("BPM : ClearLastData -> isSuccess = $isSuccess")
    }

    override fun onResponseReadDeviceInfo(deviceInfo: DeviceInfo) {
        logListAdapter?.addLog("BPM : ReadDeviceInfo -> DeviceInfo = $deviceInfo")
    }

    override fun onResponseWriteDeviceTime(isSuccess: Boolean) {
        logListAdapter?.addLog("BPM : Write -> DeviceTime = $isSuccess")
    }

    override fun onResponseReadDeviceTime(deviceInfo: DeviceInfo) {
        logListAdapter?.addLog("BPM : Read -> DeviceTime = $deviceInfo")
    }

    override fun onBtStateChanged(isEnable: Boolean) {
        //BLE will be returned when it is turned enable or disable
        if (isEnable) {
            Toast.makeText(this, "BLE is enable!!", Toast.LENGTH_SHORT).show()
            startScan()
        } else {
            Toast.makeText(this, "BLE is disable!!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onScanResult(mac: String, name: String, rssi: Int) {
        BaseUtils.printLog("d", TAG, "1026 onScanResult:$name")
        //Blood pressure machine
        if (!name.startsWith("n/a")) {
            logListAdapter?.addLog("onScanResult：$name mac:$mac rssi:$rssi")
        }
        if (isConnecting) return
        isConnecting = true
        //Stop scanning before connecting
        Global.bpmProtocol!!.stopScan()
        //Connection
        if (name.startsWith("A")) {
            logListAdapter?.addLog("3G Model！")
            Global.bpmProtocol!!.connect(mac)

        } else {
            logListAdapter?.addLog("4G Model！")
            Global.bpmProtocol!!.bond(mac)
        }

    }

    override fun onConnectionState(state: BPMProtocol.ConnectState) {
        //BLE connection status return, used to judge connection or disconnection
        when (state) {
            BPMProtocol.ConnectState.Connected -> {
                isConnecting = false
                //view model
                vm.setConnectState("Connected")
                vm.setIsConnect(true)

                logListAdapter?.addLog("Connected")
            }
            BPMProtocol.ConnectState.ConnectTimeout -> {
                isConnecting = false
                //view model
                vm.setConnectState("ConnectTimeOut")
                vm.setIsConnect(false)
                logListAdapter?.addLog("ConnectTimeout")
                startScan()
            }
            BPMProtocol.ConnectState.Disconnect -> {
                isConnecting = false
                //view model
                vm.setConnectState("Disconnected")
                vm.setIsConnect(false)
                logListAdapter?.addLog("Disconnected")
                startScan()
            }
            BPMProtocol.ConnectState.ScanFinish -> {
                //view model
                vm.setConnectState("ScanFinish")
                logListAdapter?.addLog("ScanFinish")
                startScan()
            }
        }
    }
}
