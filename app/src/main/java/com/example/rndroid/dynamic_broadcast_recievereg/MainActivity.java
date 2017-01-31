package com.example.rndroid.dynamic_broadcast_recievereg;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Step 1. Create a dynamic broadcast reciever
    class MyReciever extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, " Dynamic Power Unplugged", Toast.LENGTH_SHORT).show();
    }
}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //step.2- link intent-filter with above reciever
        IntentFilter intentFilter = new IntentFilter(); // create intent filter
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED); // add action
        MyReciever myReciever = new MyReciever(); // create object of your reciever
        registerReceiver(myReciever, intentFilter); // link above
    }
}
