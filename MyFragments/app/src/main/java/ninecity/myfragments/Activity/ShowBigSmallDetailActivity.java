package ninecity.myfragments.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ninecity.myfragments.Class.BigSmallDate;
import ninecity.myfragments.Class.BigSmallYun;
import ninecity.myfragments.Class.ChineseBiHua;
import ninecity.myfragments.Class.ListViewForScrollView;
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
        int guaNumber = intent.getIntExtra("guaNumber", 0);
        String yearString = String.format("%d年", year);
        String monthString = String.format("%d月", month);
        String dayStrig = String.format("%d日", day);

        NongLi nongLi = new NongLi(year, month, day);
        nongLi.printLunar();

        String yinli = nongLi.getFullNongli();

        String guaString = String.valueOf(guaNumber);


        String content = "姓: " + xing + "\n" + "名: " + name + "\n" + "出生日期: " + yearString + monthString + dayStrig + "\n农历: " + yinli + "\n\n";


        titleTextView = (TextView) findViewById(R.id.titleTextView);
        showDetailTextView = (TextView) findViewById(R.id.showDetailTextView);


        YaoCi yaoCi = new YaoCi();
//
        BigSmallYun bigSmallYun = new BigSmallYun();

        List yaociList = yaoCi.getYaoCi(guaNumber);


        ListViewForScrollView listView = (ListViewForScrollView) findViewById(R.id.scrollListView);


        if (type.equals("small")) {
            titleTextView.setText("小运");


            content += bigSmallYun.getFullXiaoYunYaoCiAndZhouQi(yaociList, month);


            List yaoZiList = bigSmallYun.getXiaoYunYaoZi(yaociList, month);

            BigSmallDate bigSmallDate=new BigSmallDate();

//             小运周期
            List zhouQiList= bigSmallYun.getSortedAllXiaoYunZhouQi(yaociList,month);
//爻辞
            List sortedYaoCiList=  bigSmallYun.getSortedYaoCi(yaociList,month);

            int[] dateArray={year,month,day};



            List dateList=bigSmallDate.getSmallYunDate(dateArray,zhouQiList,sortedYaoCiList);



            List finalList=new ArrayList();

            ChineseBiHua chineseBiHua=new ChineseBiHua();

            for (int i=0;i<yaoZiList.size();i++){

                String biHua=String.format("%02d画",chineseBiHua.getContentCount(String.valueOf(yaoZiList.get(i))));

                String result=String.format("%s %s %s",yaoZiList.get(i),dateList.get(i),biHua);
                finalList.add(result);

            }


//            Log.v("date",String.valueOf(dateList));
//


            ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, finalList);
            listView.setAdapter(adapter);


        } else {
            titleTextView.setText("大运");
        }


        showDetailTextView.setBackgroundColor(this.getResources().getColor(R.color.bigSmallBack));
        showDetailTextView.setText(content);


    }


    public void back(View v) {
        finish();
    }

}
