package com.ajayvamsee.ip

import android.net.wifi.WifiManager
import android.os.Bundle
import android.text.format.Formatter
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.net.InetAddress
import java.nio.ByteBuffer
import java.nio.ByteOrder

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wifiManager: WifiManager = application.getSystemService(WIFI_SERVICE) as WifiManager
        val ipAddress = Formatter.formatIpAddress(wifiManager.connectionInfo.ipAddress)


        val ip = wifiManager.connectionInfo.ipAddress

        val buffer = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(ip).array()

        val dotNotation = InetAddress.getByAddress(buffer).hostAddress
        Log.d("aaa", "Your Device IP Address: $dotNotation")

        findViewById<TextView>(R.id.getIPAddress).text = "Your device Ip Address -$dotNotation"
    }
}