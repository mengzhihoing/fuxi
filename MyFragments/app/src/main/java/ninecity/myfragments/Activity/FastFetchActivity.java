package ninecity.myfragments.Activity;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ninecity.myfragments.R;

public class FastFetchActivity extends AppCompatActivity {

    private int guaNumber;
    private Button showGuaButton,addButton,subButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fast_fetch);
        guaNumber=11;
        showGuaButton=(Button)findViewById(R.id.guaButton);
        addButton=(Button)findViewById(R.id.gua_add);
        subButton=(Button)findViewById(R.id.gua_sub);

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
    }

    public void back(View v){
        finish();
    }

    private void guaAdd(){

        guaNumber++;

       handleGuaNumber();

    }

    private void guaSub(){
        guaNumber--;

        handleGuaNumber();

    }

    private void handleGuaNumber(){

        if (guaNumber>18&&guaNumber<21){
            guaNumber=21;
        }else  if (guaNumber>28&&guaNumber<31){
            guaNumber=31;
        }else  if (guaNumber>38&&guaNumber<41){
            guaNumber=41;
        }else  if (guaNumber>48&&guaNumber<51){
            guaNumber=51;
        }else  if (guaNumber>58&&guaNumber<61){
            guaNumber=61;
        }else  if (guaNumber>68&&guaNumber<71){
            guaNumber=71;
        }else if (guaNumber>78&guaNumber<81){
            guaNumber=81;
        }else if(guaNumber>88){
            guaNumber=11;
        }else if (guaNumber<11){
            guaNumber=88;
        }

        showGuaButton.setText(String.valueOf(guaNumber));

    }

}
