package com.example.mengzhihong.myapplication;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.InputStream;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setupMessageButton();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
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


                String benMingGua=String.format("本命卦：%d%s", guaNumber,gua.getBenMingGua(guaNumber));
                String successGua=String.format("成功卦：%s",gua.getSuccess(guaNumber));
                String failureGua=String.format("失败卦：%s",gua.getFailure(guaNumber));
                String shuaiBianGua=String.format("衰变卦：%s",gua.getShuaiBian(guaNumber));



                String describe=String.format("\"%s%s\"的笔画数是：%d+%d=%d\n %s\n %s\n %s\n %s",xingContent,nameContent,xingCount,nameCount,xingCount+nameCount,benMingGua,successGua,failureGua,shuaiBianGua);


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






