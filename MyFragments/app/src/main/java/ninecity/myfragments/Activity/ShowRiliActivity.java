package ninecity.myfragments.Activity;

import android.app.DatePickerDialog;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.avos.avoscloud.AVAnalytics;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import ninecity.myfragments.Class.GuaName;
import ninecity.myfragments.Class.Lunar;
import ninecity.myfragments.Class.NongLi;
import ninecity.myfragments.Class.YiJi;
import ninecity.myfragments.R;

public class ShowRiliActivity extends AppCompatActivity {

    //    private DatePicker datepicker;
    private Calendar calendar;
    private TextView textview;

    private Button yearButton, monthButton, dayButton, yearAddButton, monthAddButton, dayAddButton, yearSubButon, monthSubButton, daySubButton, fetchButton;

    private int year;
    private int month;
    private int day;

    private int currentYear, currentMonth, currentDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_show_rili);

        init();
    }


    private void init() {

        textview = (TextView) findViewById(R.id.text);
        calendar = Calendar.getInstance();        //生成 Calendar 对象
        year = calendar.get(Calendar.YEAR);    //获取当前日期
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        //显示当前的日期，月要加 1
//        textview.setText("当前时间：" +
//                year + "年" + (month + 1) + "月" + day + "日");
        //注册日期改变监听器
//        datepicker.init(year, month, day, new MyDateChangedListener());

        currentDay = day;
        currentMonth = month + 1;
        currentYear = year;

//        System.out.println("first");
//        System.out.println(String.valueOf(currentYear));
//        System.out.println(String.valueOf(currentMonth));
//        System.out.println(String.valueOf(currentDay));


        yearAddButton = (Button) findViewById(R.id.year_add);
        monthAddButton = (Button) findViewById(R.id.month_add);
        dayAddButton = (Button) findViewById(R.id.day_add);

        yearButton = (Button) findViewById(R.id.year_button);
        monthButton = (Button) findViewById(R.id.month_button);
        dayButton = (Button) findViewById(R.id.day_button);

        yearSubButon = (Button) findViewById(R.id.year_sub);
        monthSubButton = (Button) findViewById(R.id.month_sub);
        daySubButton = (Button) findViewById(R.id.day_sub);

        fetchButton = (Button) findViewById(R.id.fetchButton);


//        获取系统时间

        String yearText = String.format("%d年", currentYear);
        String monthText = String.format("%d月", currentMonth);
        String dayText = String.format("%d日", currentDay);

        yearButton.setText(yearText);
        monthButton.setText(monthText);
        dayButton.setText(dayText);


//        年+

        yearAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentYear++;


                updateYear(currentYear);

                handleYear();


            }
        });


//        月+

        monthAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                currentMonth++;

                if (currentMonth > 12) {
                    currentMonth = 1;
                }

                updateMonth(currentMonth);
                handleMonth();


            }
        });


        //        日+

        dayAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                currentDay++;


                handleDay();


            }
        });


//-
        //        年-

        yearSubButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentYear--;

                updateYear(currentYear);

                handleYear();

            }
        });


//        月-

        monthSubButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                currentMonth--;

                if (currentMonth < 1) {
                    currentMonth = 12;
                }

                updateMonth(currentMonth);
                handleMonth();

            }
        });


        //        日-

        daySubButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                currentDay--;


                handleDay();


            }
        });


//        查询
        fetchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fetchRiGua();

            }
        });


    }

    public void back(View v) {
        finish();
    }


    private void fetchRiGua() {

        AVAnalytics.onEvent(this, "日历");


        System.out.println("final");
        System.out.println(String.valueOf(currentYear));
        System.out.println(String.valueOf(currentMonth));
        System.out.println(String.valueOf(currentDay));


        NongLi nongLi = new NongLi(currentYear, currentMonth, currentDay);
        nongLi.printLunar();

        int noliri = nongLi.getNongliRi();


        String notice = "";

        if (noliri == 1 || noliri == 15) {
            notice = String.format("提示:%s是吉日", nongLi.getYinLiRi());
        } else if (noliri == 2 || noliri == 16) {
            notice = String.format("提示:%s是财日", nongLi.getYinLiRi());

        } else if (noliri == 5 || noliri == 23 || noliri == 14) {
            notice = String.format("提示:%s是黑道日(诸事不宜,黑道日出生的除外)", nongLi.getYinLiRi());

        }


        GuaName guaName = new GuaName();

        int guaNumber = guaName.handleNameNumber(noliri) * 10 + guaName.handleNameNumber(currentDay);
//            System.out.println(guaNumber);

        String benMing = guaName.getFullBenMing(guaNumber);

        YiJi yiji = new YiJi();
        String detail = yiji.getYiJi(guaNumber);


        textview.setText("当前时间：" +
                currentYear + "年" + currentMonth + "月" + currentDay + "日" + "\n" + "农历：" + nongLi.getFullNongli() + "\n日卦：" + benMing + "\n" + notice + "\n\n" + detail + "\n\n\n");


    }


//    日改变处理

    private void handleDay() {

        boolean isRunNian = isRunNian(currentYear);

        switch (currentMonth) {

            case 2: {

                if (isRunNian == false) {

                    if (currentDay > 28) {
                        currentDay = 28;
                    } else if (currentDay < 1) {
                        currentDay = 1;
                    }


                } else {

                    if (currentDay > 29) {
                        currentDay = 29;
                    } else if (currentDay < 1) {
                        currentDay = 1;
                    }

                }
            }


            break;

            case 4:
            case 6:
            case 9:
            case 11: {
                if (currentDay > 30) {
                    currentDay = 30;
                } else if (currentDay < 1) {
                    currentDay = 1;
                }

            }

            break;


            default: {
                if (currentDay > 31) {
                    currentDay = 31;
                } else if (currentDay < 1) {
                    currentDay = 1;
                }

            }

            break;


        }

        updateDay(currentDay);


    }


//    月份改变处理

    private void handleMonth() {


        boolean isRunNian = isRunNian(currentYear);

        switch (currentMonth) {

            case 2: {
                if (isRunNian == false) {

                    if (currentDay > 28) {
                        currentDay = 28;

                        updateDay(currentDay);
                    }

                } else {

                    if (currentDay > 29) {
                        currentDay = 29;

                        updateDay(currentDay);
                    }

                }
            }

            break;


            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12: {

            }

            break;


            default: {
                if (currentDay > 30) {
                    currentDay = 30;
                    updateDay(currentDay);
                }
            }

            break;

        }


    }


    //年份改变处理
    private void handleYear() {

        boolean isRunNian = isRunNian(currentYear);

        if (isRunNian == false) {

            if (currentMonth == 2) {

                if (currentDay > 28) {
                    currentDay = 28;
                    updateDay(currentDay);

                }

            }


        } else {

            if (currentMonth == 2) {

                if (currentDay > 29) {
                    currentDay = 29;
                    updateDay(currentDay);

                }

            }

        }


    }

    private boolean isRunNian(int year) {

        if ((year % 100 != 0) && (year % 4 == 0) || (year % 400 == 0)) {
            return true;
        }


        return false;


    }


    private void updateYear(int year) {

        String yearText = String.format("%d年", year);
        yearButton.setText(yearText);

    }

    private void updateMonth(int month) {

        String monthText = String.format("%d月", month);
        monthButton.setText(monthText);

    }

    private void updateDay(int day) {

        String dayText = String.format("%d日", day);
        dayButton.setText(dayText);

    }


}
