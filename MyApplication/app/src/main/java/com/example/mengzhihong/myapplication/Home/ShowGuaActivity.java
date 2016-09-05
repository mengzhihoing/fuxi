package com.example.mengzhihong.myapplication.Home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.mengzhihong.myapplication.R;

public class ShowGuaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_gua);
        showContent();
    }


    private void showContent(){

        TextView textView=(TextView)findViewById(R.id.textView);

        Intent intent=getIntent();
        int guaNumber=intent.getIntExtra("guaNumber",0);

        BenMingDetail benMing=new BenMingDetail();


        String gua=  benMing.getBenMingDetail(guaNumber);
        textView.setText(gua);

    }
}
