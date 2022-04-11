package com.ajayvamsee.ip;

import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.format.Formatter;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.function.LongFunction;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.getIPAddress);

        WifiManager wifiManager=(WifiManager) getApplication().getSystemService(WIFI_SERVICE);
        String ipAddress= Formatter.formatIpAddress(wifiManager.getConnectionInfo().getIpAddress());
        textView.setText("Your Device IP Address: " + ipAddress);

        int ip = wifiManager.getConnectionInfo().getIpAddress();
        byte[] buffer = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(ip).array();

        try {
            String dotNotation = InetAddress.getByAddress(buffer).getHostAddress();
           Log.d("aaa",""+ "Your Device IP Address: " + dotNotation);
        } catch (UnknownHostException ignore) {
        }
    }
}