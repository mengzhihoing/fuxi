package ninecity.myfragments.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import ninecity.myfragments.R;


public class DetailActivity extends AppCompatActivity {

    private int kGuaNumber=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getValue();

        String[] item={"本命卦","成功卦","衰变卦","失败卦","九宫卦"};

        ListAdapter adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,item);
        ListView listView=(ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String content=String.valueOf(adapterView.getItemAtPosition(i));

                showGua(content);

            }
        });



    }



    private void getValue(){

        Intent intent=getIntent();
        int guaNumber=intent.getIntExtra("guaNumber",0);
        kGuaNumber=guaNumber;

    }


    public void back(View v){
        finish();
    }


    public void showGua(String content){


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
