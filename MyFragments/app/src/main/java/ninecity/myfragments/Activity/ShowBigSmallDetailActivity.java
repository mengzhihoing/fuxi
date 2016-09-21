package ninecity.myfragments.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import ninecity.myfragments.Class.NongLi;
import ninecity.myfragments.Class.YaoCi;
import ninecity.myfragments.R;

public class ShowBigSmallDetailActivity extends AppCompatActivity {

    private TextView titleTextView, showDetailTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_big_small_detail);




        Intent intent = getIntent();

        String type = intent.getStringExtra("type");
        String xing = intent.getStringExtra("xing");
        String name = intent.getStringExtra("name");
        int year = intent.getIntExtra("year", 0);
        int month = intent.getIntExtra("month", 0);
        int day = intent.getIntExtra("day", 0);
        int guaNumber=intent.getIntExtra("guaNumber",0);
        String yearString = String.format("%d年", year);
        String monthString = String.format("%d月", month);
        String dayStrig = String.format("%d日", day);

        NongLi nongLi = new NongLi(year, month, day);
        nongLi.printLunar();

        String yinli =nongLi.getFullNongli();

        String guaString=String.valueOf(guaNumber);

        YaoCi yaoci=new YaoCi();

        String yaociString=yaoci.getFullYaoCi(guaNumber);


        String content="姓: "+xing+"\n"+"名: "+name+"\n"+"出生日期: "+yearString+monthString+dayStrig+"\n农历: "+yinli+"\n\n"+yaociString;


        titleTextView=(TextView)findViewById(R.id.titleTextView);
        showDetailTextView=(TextView)findViewById(R.id.showDetailTextView);

        if (type.equals("small")){
            titleTextView.setText("小运");
        }else {
            titleTextView.setText("大运");
        }


        showDetailTextView.setText(content);


        ListView listView=(ListView)findViewById(R.id.listView);

        String[] dataArray={"1","2","3","4","5","6","7","8","9"};

        ListAdapter adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,dataArray);
        listView.setAdapter(adapter);

    }


    public void back(View v) {
        finish();
    }

}
