package ninecity.myfragments.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


import ninecity.myfragments.Class.BenMingDetail;
import ninecity.myfragments.Class.GuaName;
import ninecity.myfragments.R;

public class ShowGuaActivity extends AppCompatActivity {

    private TextView textView1, textView2;
    private View view1, view2, view3, view4;


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


        BenMingDetail benMingDetail = new BenMingDetail();
        GuaName guaName = new GuaName();


        if (type.equals("本命卦")) {

            content = String.format("%s \n\n\n\n", benMingDetail.getBenMingDetail(guaNumber));
            textView1.setText(content);

            hideView();


        } else if (type.equals("成功卦")) {

            int gua[] = guaName.getSuccess(guaNumber);

            if (isDouble == true) {
                String text1 = benMingDetail.getBenMingDetail(gua[0]);
                String text2 = benMingDetail.getBenMingDetail(gua[1]);


                content = String.format(text1 + "\n\n\n");
                String  content2 = String.format(text2 + "\n\n\n");

                textView1.setText(content);
                textView2.setText(content2);



            } else {
                String text1 = benMingDetail.getBenMingDetail(gua[0]);
                content = String.format("%s \n\n\n\n", text1);
                textView1.setText(content);

            }


        } else if (type.equals("失败卦")) {

            int gua[] = guaName.getFailure(guaNumber);

            if (isDouble == true) {
                String text1 = benMingDetail.getBenMingDetail(gua[0]);
                String text2 = benMingDetail.getBenMingDetail(gua[1]);

                content = String.format(text1 + "\n\n\n");
                String  content2 = String.format(text2 + "\n\n\n");

                textView1.setText(content);
                textView2.setText(content2);

            } else {
                String text1 = benMingDetail.getBenMingDetail(gua[0]);
                content = String.format("%s \n\n\n\n", text1);

                textView1.setText(content);
                hideView();

            }

        } else {
//            衰变卦

            int gua[] = guaName.getShuaiBian(guaNumber);

            if (isDouble == true) {
                String text1 = benMingDetail.getBenMingDetail(gua[0]);
                String text2 = benMingDetail.getBenMingDetail(gua[1]);

                content = String.format(text1 + "\n\n\n");
                String  content2 = String.format(text2 + "\n\n\n");

                textView1.setText(content);
                textView2.setText(content2);

            } else {
                String text1 = benMingDetail.getBenMingDetail(gua[0]);
                content = String.format("%s \n\n\n\n", text1);

                textView1.setText(content);
                hideView();
            }

        }


    }


    private void hideView() {

        textView2.setVisibility(View.INVISIBLE);
        view3.setVisibility(View.INVISIBLE);
        view4.setVisibility(View.INVISIBLE);
    }


    public int getGuaColor(int number){


        return (this.getResources().getColor(R.color.gray));

    }

}
