package ninecity.myfragments.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ninecity.myfragments.R;

public class CenturyActivity extends AppCompatActivity {

    private Button centutyButton,addButton,subButton,fetchButton;

    int century;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_century);

        centutyButton=(Button)findViewById(R.id.centuryButton);
        addButton=(Button)findViewById(R.id.century_add);
        subButton=(Button)findViewById(R.id.century_sub);
        fetchButton=(Button)findViewById(R.id.fetchButton);

        century=21;

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                centuryAdd();
            }
        });


        subButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                centurySub();
            }
        });

        fetchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleCentury();
            }
        });



    }


    private void handleCentury(){

        int number=handleNumber(century);
        int guaNumber=number*10+number;

        Intent intent = new Intent(this, ShowGuaActivity.class);
        intent.putExtra("guaNumber", guaNumber);
        intent.putExtra("type", "本命卦");
        startActivity(intent);

    }


   private int handleNumber(int number) {

        if (number % 8 == 0) {
            return 8;
        }

        return number % 8;
    }



    private void centuryAdd(){

        century++;

        updateCentury();

    }

    private void centurySub(){
        century--;

        if (century<1){
            century=1;
        }

        updateCentury();
    }

    private void updateCentury(){

        String content=String.format("%d世纪",century);

        centutyButton.setText(content);


    }

    public void back(View v){

        finish();
    }
}
