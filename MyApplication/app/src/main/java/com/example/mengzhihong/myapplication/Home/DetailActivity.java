package com.example.mengzhihong.myapplication.Home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.mengzhihong.myapplication.R;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getValue();
    }

    private void getValue(){

        Intent intent=getIntent();

        int guaNumber=intent.getIntExtra("guaNumber",0);

        BenMingDetail benming=new BenMingDetail();

        String content=benming.getBenMingDetail(guaNumber);

        Log.i("zhdi",content);

    }
}
