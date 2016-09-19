package ninecity.myfragments.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import ninecity.myfragments.Class.GuaName;
import ninecity.myfragments.R;

public class The9GridActivity extends AppCompatActivity {

    int kGuaNumber;
    private Button button1, button2, button3, button4, button5, button6, button7, button8, button9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the9_grid);


        Intent intent = getIntent();
        int guaNumber = intent.getIntExtra("guaNumber", 0);

        kGuaNumber=guaNumber;

        Log.v("number", String.valueOf(guaNumber));

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);

        GuaName guaName=new GuaName();

        button1.setText(guaName.getLeftUpGua(guaNumber));
        button2.setText(guaName.getUpGua(guaNumber));
        button3.setText(guaName.getRightUpGua(guaNumber));
        button4.setText(guaName.getLeftGua(guaNumber));
        button5.setText(guaName.getMiddleGua(guaNumber));
        button6.setText(guaName.getRightGua(guaNumber));
        button7.setText(guaName.getLeftBottomGua(guaNumber));
        button8.setText(guaName.getMiddleBottomGua(guaNumber));
        button9.setText(guaName.getRightBottomGua(guaNumber));



        addClick();




    }


    private void addClick(){

        final GuaName guaName=new GuaName();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int number=guaName.getLeftUpNumber(kGuaNumber);
                pushToBenMingGua(number);

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number=guaName.getUpNumber(kGuaNumber);
                pushToBenMingGua(number);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number=guaName.getRightUpNumber(kGuaNumber);
                pushToBenMingGua(number);

            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number=guaName.getLeftNumber(kGuaNumber);
                pushToBenMingGua(number);

            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number=guaName.getMiddleNumber(kGuaNumber);
                pushToBenMingGua(number);

            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number=guaName.getRightNumber(kGuaNumber);
                pushToBenMingGua(number);

            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number=guaName.getLeftBottomNumber(kGuaNumber);
                pushToBenMingGua(number);
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number=guaName.getMiddleBottomNumber(kGuaNumber);
                pushToBenMingGua(number);

            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number=guaName.getRightBottomNumber(kGuaNumber);
                pushToBenMingGua(number);

            }
        });

    }


    private void pushToBenMingGua(int guaNumber){

        Intent intent=new Intent();
        intent.setClass(this,ShowGuaActivity.class);
        intent.putExtra("guaNumber",guaNumber);
        intent.putExtra("type","本命卦");
        startActivity(intent);


    }





    public void back(View v) {
        finish();
    }

}
