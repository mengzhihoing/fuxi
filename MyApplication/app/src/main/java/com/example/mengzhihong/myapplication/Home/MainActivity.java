package com.example.mengzhihong.myapplication.Home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mengzhihong.myapplication.R;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
//    是否可以进入详情
    private boolean canGo=false;
    private int kGuaNumber=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setupMessageButton();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    //    进入详情
    public void detail(View view){

        if(canGo==false) {

        Toast.makeText(MainActivity.this,"姓氏和名字必须都有汉字",Toast.LENGTH_LONG);

        }else {

            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("guaNumber",kGuaNumber);
            startActivity(intent);

        }

    }


    private void setupMessageButton() {

        Button messageButton = (Button) findViewById(R.id.button);

        messageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                TextView textView=(TextView)findViewById(R.id.textView);
                EditText edit=(EditText)findViewById(R.id.editText);
                EditText edit1=(EditText)findViewById(R.id.editText2);

                String xingContent=edit.getText().toString();
                String nameContent=edit1.getText().toString();

                ChineseBiHua bihua=new ChineseBiHua();
                int xingCount= bihua.getContentCount(xingContent);
                int nameCount= bihua.getContentCount(nameContent);



                GuaName gua=new GuaName();

                int guaNumber=gua.getGua(xingCount,nameCount);



                String describe="";
                if (xingCount>0&&nameCount>0) {

                    canGo=true;
                    kGuaNumber=guaNumber;

                    String benMingGua=String.format("本命卦：%d%s", guaNumber,gua.getBenMingGua(guaNumber));
                    String successGua=String.format("成功卦：%s",gua.getSuccess(guaNumber));
                    String failureGua=String.format("失败卦：%s",gua.getFailure(guaNumber));
                    String shuaiBianGua=String.format("衰变卦：%s",gua.getShuaiBian(guaNumber));

                    describe = String.format("\"%s%s\"的笔画数是：%d+%d=%d\n %s\n %s\n %s\n %s", xingContent, nameContent, xingCount, nameCount, xingCount + nameCount, benMingGua, successGua, failureGua, shuaiBianGua);
                }else {
                    canGo=false;
                     describe = String.format("\"%s%s\"的笔画数是：%d+%d=%d\n ", xingContent, nameContent, xingCount, nameCount, xingCount + nameCount);
                }

                textView.setText(describe);

            }
        });




    }




    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onStop() {
        super.onStop();

    }
}






