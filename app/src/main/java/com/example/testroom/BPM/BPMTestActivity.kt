package com.example.testroom.BPM

import android.Manifest
import android.app.AlertDialog
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.core.app.ActivityCompat
import com.example.testroom.BPMViewModel
import com.example.testroom.Global
import com.example.testroom.LogListAdapter
import com.example.testroom.Room.MyDatabase
import com.ideabus.ideabuslibrary.util.BaseUtils
import com.ideabus.model.bluetooth.MyBluetoothLE
import com.ideabus.model.data.*
import com.ideabus.model.protocol.BPMProtocol
import kotlinx.coroutines.launch

class BPMTestActivity : ComponentActivity(), BPMProtocol.OnConnectStateListener,
    View.OnClickListener, BPMProtocol.OnDataResponseListener, BPMProtocol.OnNotifyStateListener,
    MyBluetoothLE.OnWriteStateListener {
    //permission
    private val Permission = arrayOf(
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.BLUETOOTH,
        Manifest.permission.BLUETOOTH_ADMIN,
        Manifest.permission.BLUETOOTH_SCAN,
        Manifest.permission.BLUETOOTH_CONNECT
    )
    private val Location_Request = 1
    //
    val TAG = "BPMTestActivity"
    var logListAdapter: LogListAdapter? = null
    var isConnecting = false
    //view model
    private val vm by viewModels<BPMViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //check permission
        checkPermission()
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
            BPMScreen(vm)
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
        logListAdapter?.addLog("start scan", model = vm)
        Global.bpmProtocol!!.startScan(10)
    }

    private fun checkPermission() {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED ||
            ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED ||
            ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.BLUETOOTH
            ) != PackageManager.PERMISSION_GRANTED ||
            ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.BLUETOOTH_ADMIN
            ) != PackageManager.PERMISSION_GRANTED  ||
            ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.BLUETOOTH_SCAN
            ) != PackageManager.PERMISSION_GRANTED ||
            ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.BLUETOOTH_CONNECT
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) ||
                ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) ||
                ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    Manifest.permission.BLUETOOTH_SCAN
                ) ||
                ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    Manifest.permission.BLUETOOTH
                )
            ) {
                val builder = AlertDialog.Builder(this)
                builder.setMessage("需要給予權限，否則不能連接設備")
                builder.setPositiveButton(
                    "是"
                ) { dialog, which ->
                    ActivityCompat.requestPermissions(
                        this@BPMTestActivity,
                        Permission,
                        Location_Request,
                    )
                }
                builder.setNeutralButton("否", null)
            } else {
                ActivityCompat.requestPermissions(
                    this@BPMTestActivity,
                    Permission,
                    Location_Request
                )
            }
        }
    }

    override fun onClick(v: View) {
    }

    override fun onWriteMessage(isSuccess: Boolean, message: String) {
        logListAdapter?.addLog("WRITE : $message", model = vm)
    }

    override fun onNotifyMessage(message: String) {
        logListAdapter?.addLog("NOTIFY : $message", model = vm)
    }

    override fun onResponseReadHistory(dRecord: DRecord) {
        logListAdapter?.addLog("BPM : ReadHistory -> DRecord = $dRecord", model = vm)
        //build database
        vm.setDRecord(dRecord)
        vm.insertDatabase()
    }

    override fun onResponseClearHistory(isSuccess: Boolean) {
        logListAdapter?.addLog("BPM : ClearHistory -> isSuccess = $isSuccess", model = vm)
    }

    override fun onResponseReadUserAndVersionData(user: User, versionData: VersionData) {
        logListAdapter?.addLog(
            "BPM : ReadUserAndVersionData -> user = " + user +
                    " , versionData = " + versionData
            , model = vm)
    }

    override fun onResponseWriteUser(isSuccess: Boolean) {
        logListAdapter?.addLog("BPM : WriteUser -> isSuccess = $isSuccess", model = vm)
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
            , model = vm)
    }

    override fun onResponseClearLastData(isSuccess: Boolean) {
        logListAdapter?.addLog("BPM : ClearLastData -> isSuccess = $isSuccess", model = vm)
    }

    override fun onResponseReadDeviceInfo(deviceInfo: DeviceInfo) {
        logListAdapter?.addLog("BPM : ReadDeviceInfo -> DeviceInfo = $deviceInfo", model = vm)
    }

    override fun onResponseWriteDeviceTime(isSuccess: Boolean) {
        logListAdapter?.addLog("BPM : Write -> DeviceTime = $isSuccess", model = vm)
    }

    override fun onResponseReadDeviceTime(deviceInfo: DeviceInfo) {
        logListAdapter?.addLog("BPM : Read -> DeviceTime = $deviceInfo", model = vm)
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
            logListAdapter?.addLog("onScanResult：$name mac:$mac rssi:$rssi", model = vm)
        }
        if (isConnecting) return
        isConnecting = true
        //Stop scanning before connecting
        Global.bpmProtocol!!.stopScan()
        //Connection
        if (name.startsWith("A")) {
            logListAdapter?.addLog("3G Model！", model = vm)
            Global.bpmProtocol!!.connect(mac)

        } else {
            logListAdapter?.addLog("4G Model！", model = vm)
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
                logListAdapter?.addLog("Connected", model = vm)
            }
            BPMProtocol.ConnectState.ConnectTimeout -> {
                isConnecting = false
                //view model
                vm.setConnectState("ConnectTimeOut")
                vm.setIsConnect(false)
                logListAdapter?.addLog("ConnectTimeout", model = vm)
                startScan()
            }
            BPMProtocol.ConnectState.Disconnect -> {
                isConnecting = false
                //view model
                vm.setConnectState("Disconnected")
                vm.setIsConnect(false)
                logListAdapter?.addLog("Disconnected", model = vm)
                startScan()
            }
            BPMProtocol.ConnectState.ScanFinish -> {
                //view model
                vm.setConnectState("ScanFinish")
                logListAdapter?.addLog("ScanFinish", model = vm)
                startScan()
            }
        }
    }
}
