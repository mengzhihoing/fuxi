package ninecity.myfragments.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.avos.avoscloud.AVAnalytics;

import java.util.Calendar;

import ninecity.myfragments.Class.GuaName;
import ninecity.myfragments.R;

public class YearActivity extends AppCompatActivity {

    private Button addButton, subButton, fetchButton, yearButton;

    int year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_year);

        addButton = (Button) findViewById(R.id.year_add);
        yearButton = (Button) findViewById(R.id.yearButton);
        subButton = (Button) findViewById(R.id.year_sub);
        fetchButton = (Button) findViewById(R.id.fetchButton);

        Calendar calendar = Calendar.getInstance();

        year = calendar.get(Calendar.YEAR);    //获取当前日期


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yearAdd();
            }
        });


        subButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yearSub();
            }
        });


        fetchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fetchHandle();
            }
        });


    }

    public void back(View v){

        finish();
    }


    private void fetchHandle() {

        AVAnalytics.onEvent(this, "年卦");


        int guaNumber = 0;
        String yearString = String.valueOf(year);

        String one = yearString.substring(0, 1);
        String two = yearString.substring(1, 2);
        String three = yearString.substring(2, 3);
        String four = yearString.substring(3, 4);

        GuaName guaName=new GuaName();


        one = String.valueOf(guaName.handleNameNumber(Integer.parseInt(one)));
        two = String.valueOf(guaName.handleNameNumber(Integer.parseInt(two)));
        three = String.valueOf(guaName.handleNameNumber(Integer.parseInt(three)));
        four = String.valueOf(guaName.handleNameNumber(Integer.parseInt(four)));


        String content = String.format(one + two + three + four + "year");

        Log.v("year", content);


        //    前两位和后两位相同
        if (one.equals(three) && two.equals(four)) {
            Log.v("condition","前两位和后两位相同");

            showError();
            return;

            //三位数相同
        } else if ((one.equals(two) && two.equals(three)) || (four.equals(two) && two.equals(three))) {

            Log.v("condition","三位数相同");

            if (one.equals(two) && two.equals(three)) {

                if (one.equals("0")) {
                    guaNumber = Integer.parseInt(four) * 10 + Integer.parseInt(four);
                } else {

                    if (four.equals("0")) {

                        showError();
                        return;

                    }
                    guaNumber = Integer.parseInt(one) * 10 + Integer.parseInt(four);

                }

            } else {

                if (four.equals("0")) {

                    guaNumber = Integer.parseInt(one) * 10 + Integer.parseInt(one);


                }else {

                    if (four.equals("0")){

                        showError();
                        return;
                    }

                    guaNumber = Integer.parseInt(one) * 10 + Integer.parseInt(four);

                }
            }

            //      12相同34相同

        } else if (one.equals(two) && three.equals(four)) {
            Log.v("condition","12相同34相同");

            showError();
            return;

            //      中间两位相同
        }else if (two.equals(three)){
            Log.v("condition","中间两位相同");

            if (one.equals(four)){
                showError();
                return;
            }else if (four.equals("0")){
                showError();
                return;
            }


            guaNumber = Integer.parseInt(one) * 10 + guaName.handleNameNumber(Integer.parseInt(four));


        }else {

            Log.v("condition","普通");




            int pre=guaName.handleNameNumber(Integer.parseInt(one)+Integer.parseInt(two));
            int next=guaName.handleNameNumber(Integer.parseInt(three)+Integer.parseInt(four));

            guaNumber=pre*10+next;

        }


        Log.v("year!!",String.valueOf(guaNumber));

        Intent intent = new Intent(this, ShowGuaActivity.class);
        intent.putExtra("guaNumber", guaNumber);
        intent.putExtra("type", "本命卦");
        startActivity(intent);



    }


    private void showError() {

        String content = String.format("%d年为无卦", year);

        Toast.makeText(this, content, Toast.LENGTH_LONG).show();


    }

    private void yearAdd() {

        year++;

        updateYear();

    }


    private void yearSub() {
        year--;
        updateYear();
    }


    private void updateYear() {

        String content = String.format("%d年", year);

        yearButton.setText(content);


    }

}
