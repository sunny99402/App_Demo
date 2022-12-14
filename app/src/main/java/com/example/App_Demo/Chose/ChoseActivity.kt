package com.example.App_Demo.Chose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.app.ActivityCompat
import android.Manifest
import android.app.AlertDialog
import android.content.pm.PackageManager
import androidx.activity.viewModels
import com.example.App_Demo.BPM.BPMViewModel
import com.example.App_Demo.BT.BtViewModel
import com.example.App_Demo.ChoseScreen
import com.example.App_Demo.Global

class ChoseActivity : ComponentActivity() {
    private val bpmViewModel by viewModels<BPMViewModel>()
    private val btViewModel by viewModels<BtViewModel>()

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //permission
        checkPermission()

        setContent {
            ChoseScreen(
                bpmViewModel = bpmViewModel,
                btViewModel = btViewModel
            )
        }
    }

    override fun onStart() {
        super.onStart()
        Global.bpmProtocol?.stopScan()
        Global.thermoProtocol?.stopScan()
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
                builder.setMessage("?????????????????????????????????????????????")
                builder.setPositiveButton(
                    "???"
                ) { dialog, which ->
                    ActivityCompat.requestPermissions(
                        this@ChoseActivity,
                        Permission,
                        Location_Request,
                    )
                }
                builder.setNeutralButton("???", null)
            } else {
                ActivityCompat.requestPermissions(
                    this@ChoseActivity,
                    Permission,
                    Location_Request
                )
            }
        }
    }
}

