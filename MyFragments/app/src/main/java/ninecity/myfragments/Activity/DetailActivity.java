package ninecity.myfragments.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ninecity.myfragments.R;


public class DetailActivity extends AppCompatActivity {

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


        String content="";

        content=String.valueOf(button.getText());

        if (!content.equals("九宫卦")) {

            Intent intent = new Intent(DetailActivity.this, ShowGuaActivity.class);
            intent.putExtra("guaNumber", kGuaNumber);
            intent.putExtra("type", content);
            startActivity(intent);

        }else {

            Intent intent=new Intent();
            intent.setClass(this,The9GridActivity.class);
            intent.putExtra("guaNumber", kGuaNumber);
            startActivity(intent);

        }

    }
}
