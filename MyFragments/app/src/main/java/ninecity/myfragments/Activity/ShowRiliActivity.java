package ninecity.myfragments.Activity;

import android.app.DatePickerDialog;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import ninecity.myfragments.Class.Lunar;
import ninecity.myfragments.R;

public class ShowRiliActivity extends AppCompatActivity {

    private DatePicker datepicker;
    private Calendar calendar;
    private TextView textview;

    private int year;
    private int month;
    private int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_show_rili);

        datepicker = (DatePicker)findViewById(R.id.myDatePicker);
        textview = (TextView)findViewById(R.id.text);
        calendar = Calendar.getInstance();		//生成 Calendar 对象
        year = calendar.get(Calendar.YEAR);	//获取当前日期
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        //显示当前的日期，月要加 1
        textview.setText("当前时间：" +
                year + "年" + (month + 1) + "月" + day + "日");
        //注册日期改变监听器
        datepicker.init(year, month, day, new MyDateChangedListener());
    }

    public void back(View v) {
        finish();
    }


    private class MyDateChangedListener implements DatePicker.OnDateChangedListener {
        /* onDateChanged 方法中各个参数的含义：
         * @param view 当前发生变化的时间选择器
         * @param year 当前时间选择器的年
         * @param monthOfYear 当前时间选择器的月 返回值为(0 ~ 11)故使用时要加 1
         * @param dayOfMonth 当前时间选择器的日
         * */
        @Override
        public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            year = year;
            month = monthOfYear + 1;
            day = dayOfMonth;
            textview.setText("当前时间：" +
                    year + "年" + month + "月" + day + "日");





                Calendar cal=Calendar.getInstance();
                cal.set(year,monthOfYear,dayOfMonth);



                Lunar lunar=new Lunar(cal);
                System.out.print("农历日期:");
                System.out.print(lunar.year+"年 ");
                System.out.print(lunar.month+"月 ");
                System.out.print(lunar.getChinaDayString(lunar.day));
                System.out.println("*************");
                System.out.println(lunar);




            



        }
    }


}
