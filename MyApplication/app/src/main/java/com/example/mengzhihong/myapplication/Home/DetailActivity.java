package com.example.mengzhihong.myapplication.Home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.mengzhihong.myapplication.R;

public class DetailActivity extends NaviBarActivity {

    private int kGuaNumber=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getValue();
    }



    private void getValue(){

        Intent intent=getIntent();

        int guaNumber=intent.getIntExtra("guaNumber",0);
        kGuaNumber=guaNumber;

    }


    public void back(View v){
        finish();
    }


    public void showGua(View v){

        Button button=(Button) v;

        Intent intent = new Intent(DetailActivity.this, ShowGuaActivity.class);
        intent.putExtra("guaNumber",kGuaNumber);
        intent.putExtra("type",button.getText());
        startActivity(intent);

    }
}
