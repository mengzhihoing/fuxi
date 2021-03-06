package ninecity.myfragments.Activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.avos.avoscloud.AVAnalytics;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import ninecity.myfragments.Class.GuaName;
import ninecity.myfragments.R;

public class ChooseGuaActivity extends AppCompatActivity {
    private int guaNumber;
    private Button showGuaButton, addButton, subButton, fetchButton, detailButton;
    private TextView textView,titleTextView;
    boolean isFast;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_gua);
        guaNumber = 11;
        showGuaButton = (Button) findViewById(R.id.guaButton);
        addButton = (Button) findViewById(R.id.gua_add);
        subButton = (Button) findViewById(R.id.gua_sub);
        fetchButton = (Button) findViewById(R.id.fetchButton);
        detailButton = (Button) findViewById(R.id.detailButton);

        textView = (TextView) findViewById(R.id.text);
        titleTextView = (TextView) findViewById(R.id.navi_title);


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guaAdd();
            }
        });

        subButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guaSub();
            }
        });
        fetchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBasicGua();
            }
        });
        detailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushToDetail();
            }
        });


        Intent intent=getIntent();
        String type=intent.getStringExtra("type");

        if (type.equals("fast")){
            isFast=true;
            titleTextView.setText("快捷查询");

        }else {
            titleTextView.setText("九宫卦");
            textView.setVisibility(View.INVISIBLE);
            detailButton.setVisibility(View.INVISIBLE);
            isFast=false;

        }

    }

    public void back(View v) {
        finish();
    }

    private void guaAdd() {

        guaNumber++;

        addGuaNumber();

    }

    private void guaSub() {

        guaNumber--;

        subGuaNumber();

    }

    private void subGuaNumber() {

        if (guaNumber > 18 && guaNumber < 21) {
            guaNumber = 18;
        } else if (guaNumber > 28 && guaNumber < 31) {
            guaNumber = 28;
        } else if (guaNumber > 38 && guaNumber < 41) {
            guaNumber = 38;
        } else if (guaNumber > 48 && guaNumber < 51) {
            guaNumber = 48;
        } else if (guaNumber > 58 && guaNumber < 61) {
            guaNumber = 58;
        } else if (guaNumber > 68 && guaNumber < 71) {
            guaNumber = 68;
        } else if (guaNumber > 78 & guaNumber < 81) {
            guaNumber = 78;
        } else if (guaNumber < 11) {
            guaNumber = 88;
        }

        updateGua();


    }

    private void addGuaNumber() {

        if (guaNumber > 18 && guaNumber < 21) {
            guaNumber = 21;
        } else if (guaNumber > 28 && guaNumber < 31) {
            guaNumber = 31;
        } else if (guaNumber > 38 && guaNumber < 41) {
            guaNumber = 41;
        } else if (guaNumber > 48 && guaNumber < 51) {
            guaNumber = 51;
        } else if (guaNumber > 58 && guaNumber < 61) {
            guaNumber = 61;
        } else if (guaNumber > 68 && guaNumber < 71) {
            guaNumber = 71;
        } else if (guaNumber > 78 & guaNumber < 81) {
            guaNumber = 81;
        } else if (guaNumber > 88) {
            guaNumber = 11;
        }


        updateGua();

    }

    private void updateGua() {

        GuaName guaname = new GuaName();


        String content = String.format("%s", guaname.getFullBenMing(guaNumber));

        showGuaButton.setText(String.valueOf(content));


    }


    private void showBasicGua() {



        if (isFast) {

            AVAnalytics.onEvent(this, "快捷查询");

            GuaName guaName = new GuaName();

            String benMingGua = String.format("本命卦：%s", guaName.getFullBenMing(guaNumber));
            String successGua = String.format("成功卦：%s", guaName.getFullSuccess(guaNumber));
            String failureGua = String.format("失败卦：%s", guaName.getFullFailure(guaNumber));
            String shuaiBianGua = String.format("衰变卦：%s", guaName.getFullShuaiBian(guaNumber));


            String content = String.format(benMingGua + "\n" + successGua + "\n" + failureGua + "\n" + shuaiBianGua);

            textView.setText(content);

        }else {

            AVAnalytics.onEvent(this, "九宫格");


            Intent intent=new Intent();
            intent.setClass(this,The9GridActivity.class);
            intent.putExtra("guaNumber", guaNumber);
            startActivity(intent);


        }


    }

    private void pushToDetail() {

        Intent intent = new Intent();
        intent.setClass(this, DetailActivity.class);
        intent.putExtra("guaNumber", guaNumber);

        startActivity(intent);
    }

}
