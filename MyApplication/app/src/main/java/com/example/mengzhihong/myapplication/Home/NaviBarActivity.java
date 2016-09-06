package com.example.mengzhihong.myapplication.Home;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mengzhihong.myapplication.R;

public class NaviBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navi_bar);
        setNaviBarName("zhudi");
    }



    public void setNaviBarName(String name){

        TextView textView=(TextView) findViewById(R.id.naviTitle);
        textView.setText(name);

    }
}
