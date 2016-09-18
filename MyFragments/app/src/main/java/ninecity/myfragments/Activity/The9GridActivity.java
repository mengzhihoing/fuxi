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


        button5 = (Button) findViewById(R.id.button5);
        button5.setText(getBenGua(guaNumber));
//        button5.setBackground(R.color.red);

    }


    private String getBenGua(int guaNumber) {

        String content = "";

        GuaName guaName = new GuaName();
        content = guaName.getFullBenMing(guaNumber);


        return content;


    }


    private void setGua(int guaNumber) {


    }





    public void back(View v) {
        finish();
    }

}
