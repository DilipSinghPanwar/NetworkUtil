package com.androiddevs.networkutil;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Internet status flag
    private boolean statusFlag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.btnIsConnected).setOnClickListener(this);
        findViewById(R.id.btnIsConnectedWifi).setOnClickListener(this);
        findViewById(R.id.btnIsConnectedMobile).setOnClickListener(this);
        findViewById(R.id.btnIsConnectedFast).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnIsConnected:
                statusFlag = NetworkUtil.isConnected(MainActivity.this);
                if (statusFlag)
                    showSnackMessage("INTERNET CONNECTED");
                else
                    showSnackMessage("NO INTERNET CONNECTION");
                break;
            case R.id.btnIsConnectedWifi:
                statusFlag = NetworkUtil.isConnectedWifi(MainActivity.this);
                if (statusFlag)
                    showSnackMessage("WIFI CONNECTED");
                else
                    showSnackMessage("WIFI NOT CONNECTED");
                break;
            case R.id.btnIsConnectedMobile:
                statusFlag = NetworkUtil.isConnectedMobile(MainActivity.this);
                if (statusFlag)
                    showSnackMessage("MOBILE DATA CONNECTED");
                else
                    showSnackMessage("MOBILE DATA NOT CONNECTED");
                break;
            case R.id.btnIsConnectedFast:
                statusFlag = NetworkUtil.isConnectedFast(MainActivity.this);
                if (statusFlag)
                    showSnackMessage("FAST INTERNET CONNECTION");
                else
                    showSnackMessage("SLOW INTERNET CONNECTION OR NO INTERNET CONNECTION");
                break;
        }
    }

    /*Print message*/
    public void showSnackMessage(String msg) {
        Snackbar.make(findViewById(R.id.tvSnackBar), msg, Snackbar.LENGTH_LONG).show();
    }
}
