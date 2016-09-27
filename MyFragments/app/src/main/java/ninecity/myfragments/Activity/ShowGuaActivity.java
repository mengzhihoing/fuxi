package ninecity.myfragments.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


import com.avos.avoscloud.AVAnalytics;

import ninecity.myfragments.Class.BenMingDetail;
import ninecity.myfragments.Class.GuaColor;
import ninecity.myfragments.Class.GuaName;
import ninecity.myfragments.Class.YaoCi;
import ninecity.myfragments.R;

public class ShowGuaActivity extends AppCompatActivity {

    private TextView textView1, textView2;
    private View view1, view2, view3, view4;

    BenMingDetail benMingDetail = new BenMingDetail();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_gua);
        showContent();
    }

    public void back(View v) {
        finish();
    }


    private void showContent() {

        textView1 = (TextView) findViewById(R.id.show_gua1);
        textView2 = (TextView) findViewById(R.id.show_gua2);

        view1 = (View) findViewById(R.id.view1);
        view2 = (View) findViewById(R.id.view2);
        view3 = (View) findViewById(R.id.view3);
        view4 = (View) findViewById(R.id.view4);


        Intent intent = getIntent();
        int guaNumber = intent.getIntExtra("guaNumber", 0);
        String type = intent.getStringExtra("type");

//        Log.i("type",type);


        handleString(guaNumber, type);


    }

    private void handleString(int guaNumber, String type) {

        String content = "";

        int pre = guaNumber / 10;
        int next = guaNumber % 10;
//        是否有两个卦
        boolean isDouble = false;

        Log.i("log", String.valueOf(pre));
        Log.i("log", String.valueOf(next));


        if ((pre == next) || (pre + next == 9)) {
            isDouble = true;
        }

        Log.i("log", String.valueOf(isDouble));


        GuaName guaName = new GuaName();


        if (type.equals("本命卦")) {

            AVAnalytics.onEvent(this, "本命卦");

            setContent(guaNumber, 0);


        } else if (type.equals("成功卦")) {
            AVAnalytics.onEvent(this, "成功卦");

            int gua[] = guaName.getSuccess(guaNumber);

            if (isDouble == true) {
                setContent(gua[0], gua[1]);
            } else {
                setContent(gua[0], 0);
            }


        } else if (type.equals("失败卦")) {

            AVAnalytics.onEvent(this, "失败卦");

            int gua[] = guaName.getFailure(guaNumber);

            if (isDouble == true) {
                setContent(gua[0], gua[1]);
            } else {
                setContent(gua[0], 0);
            }

        } else {
//            衰变卦

            AVAnalytics.onEvent(this, "衰变卦");


            int gua[] = guaName.getShuaiBian(guaNumber);

            if (isDouble == true) {
                setContent(gua[0], gua[1]);
            } else {
                setContent(gua[0], 0);
            }

        }


    }


    private void setViewColor(int number1, int number2) {

        GuaColor color = new GuaColor();

        int pre1 = number1 / 10;
        int next1 = number1 % 10;

        view1.setBackgroundColor(color.getGuaColor(next1, this));
        view2.setBackgroundColor(color.getGuaColor(pre1, this));


        if (number2 > 0) {

            int pre2 = number2 / 10;
            int next2 = number2 % 10;

            view3.setBackgroundColor(color.getGuaColor(next2, this));
            view4.setBackgroundColor(color.getGuaColor(pre2, this));
        }

    }


    private void hideView() {

        textView2.setVisibility(View.INVISIBLE);
        view3.setVisibility(View.INVISIBLE);
        view4.setVisibility(View.INVISIBLE);
    }


    private void setContent(int number1, int number2) {

        setViewColor(number1, number2);

        String content1 = "";
        String text1 = benMingDetail.getBenMingDetail(number1);

        String yaoci1 = "";

        YaoCi yaoCi = new YaoCi();
        yaoci1 = yaoCi.getFullYaoCi(number1);

        content1 = String.format(text1 + "\n\n\n"+ yaoci1+"\n\n\n");
        textView1.setText(content1);

        if (number2 > 0) {
            String content2 = "";
            String text2 = benMingDetail.getBenMingDetail(number2);

            String yaoci2 = "";
            yaoci2 = yaoCi.getFullYaoCi(number2);

            content2 = String.format(text2 + "\n\n\n"+yaoci2+"\n\n\n");
            textView2.setText(content2);
        } else {
            hideView();
        }


    }


}
