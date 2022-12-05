package com.example.testroom.BT

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.testroom.Global
import com.example.testroom.LogListAdapter
import com.ideabus.model.bluetooth.MyBluetoothLE
import com.ideabus.model.data.ThermoMeasureData
import com.ideabus.model.protocol.ThermoProtocol

@SuppressLint("RestrictedApi")
class BtTestActivity : ComponentActivity(), ThermoProtocol.OnConnectStateListener,
    ThermoProtocol.OnNotifyStateListener, ThermoProtocol.OnDataResponseListener,
    MyBluetoothLE.OnWriteStateListener {
    var logListAdapter: LogListAdapter? = null
    private var isConnecting = false

    override fun onCreate(savedInstanceState: Bundle?) {
        //Initialize the body ester machine Bluetooth module
        super.onCreate(savedInstanceState)

        initParam()
        setContent {
            BTScreen()
        }
    }

    /**
     * 初始化
     */
    private fun initParam() {
        //Initialize the connection SDK
        Global.thermoProtocol = ThermoProtocol.getInstance(this, false, true, Global.sdkid_BT)
        logListAdapter = LogListAdapter()
    }

    override fun onStart() {
        super.onStart()
        Global.thermoProtocol!!.setOnDataResponseListener(this)
        Global.thermoProtocol!!.setOnConnectStateListener(this)
        Global.thermoProtocol!!.setOnNotifyStateListener(this)
        Global.thermoProtocol!!.setOnWriteStateListener(this)

        //Start scan
        startScan()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (Global.thermoProtocol!!.isConnected()) Global.thermoProtocol!!.disconnect()
        Global.thermoProtocol!!.stopScan()
    }

    private fun startScan() {
        if (!Global.thermoProtocol!!.isSupportBluetooth(this)) {
            return
        }
        logListAdapter?.addLog("start scan")
        Global.thermoProtocol!!.startScan(10)
    }

    override fun onStop() {
        super.onStop()
        Global.thermoProtocol!!.disconnect()
        Global.thermoProtocol!!.stopScan()
    }

    override fun onResponseDeviceInfo(macAddress: String, workMode: Int, batteryVoltage: Float) {
        logListAdapter?.addLog(
            "THERMO : DeviceInfo -> macAddress = " + macAddress +
                    " , workMode = " + workMode + " , batteryVoltage = " + batteryVoltage,
        )
    }

    override fun onResponseUploadMeasureData(data: ThermoMeasureData) {
        logListAdapter?.addLog("THERMO : UploadMeasureData -> ThermoMeasureData = $data")
    }

    override fun onBtStateChanged(isEnable: Boolean) {
        //BLE will be returned when it is turned enable or disable
        if (isEnable) {
            Toast.makeText(this, "BLE is enable!!", Toast.LENGTH_SHORT).show()
            startScan()
        } else Toast.makeText(this, "BLE is disable!!", Toast.LENGTH_SHORT).show()
    }

    override fun onScanResult(mac: String, name: String, rssi: Int) {
        //Temperature
        if (!name.startsWith("n/a")) {
            logListAdapter?.addLog("onScanResult：$name mac:$mac rssi:$rssi")
        }
        if (isConnecting) return
        isConnecting = true

        //Stop scanning before connecting
        Global.thermoProtocol!!.stopScan()
        //Connection
        Global.thermoProtocol!!.connect(mac)
    }

    override fun onConnectionState(state: ThermoProtocol.ConnectState) {
        //BLE connection status return, used to judge connection or disconnection
        when (state) {
            ThermoProtocol.ConnectState.Connected -> {
                isConnecting = false
                logListAdapter?.addLog("Connected")
            }
            ThermoProtocol.ConnectState.ConnectTimeout -> {
                isConnecting = false
                logListAdapter?.addLog("ConnectTimeout")
            }
            ThermoProtocol.ConnectState.Disconnect -> {
                isConnecting = false
                logListAdapter?.addLog("Disconnected")
                startScan()
            }
            ThermoProtocol.ConnectState.ScanFinish -> {
                logListAdapter?.addLog("ScanFinish")
                startScan()
            }
        }
    }

    override fun onWriteMessage(isSuccess: Boolean, message: String) {
        logListAdapter?.addLog("WRITE : $message")
    }

    override fun onNotifyMessage(message: String) {
        logListAdapter?.addLog("NOTIFY : $message")
    }
}