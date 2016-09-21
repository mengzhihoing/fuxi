package ninecity.myfragments.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import ninecity.myfragments.Class.ChineseBiHua;
import ninecity.myfragments.Class.GuaName;
import ninecity.myfragments.R;

public class BigSmallYunActivity extends AppCompatActivity {

    int currentYear, currentMonth, currentDay;

    private Button yearAddButton, yearButton, yearSubButton, monthAddButton, monthButton, monthSubButton, dayAddButton, dayButton, daySubButton, smallButton, bigButton;
    private EditText xingView, nameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_small_yun);

        initData();
    }


    private void initData() {

        Calendar calendar = Calendar.getInstance();
        currentYear = calendar.get(Calendar.YEAR);
        currentMonth = calendar.get(Calendar.MONTH) + 1;
        currentDay = calendar.get(Calendar.DAY_OF_MONTH);

        yearAddButton = (Button) findViewById(R.id.year_add);
        yearButton = (Button) findViewById(R.id.year_button);
        yearSubButton = (Button) findViewById(R.id.year_sub);
        monthAddButton = (Button) findViewById(R.id.month_add);
        monthButton = (Button) findViewById(R.id.month_button);
        monthSubButton = (Button) findViewById(R.id.month_sub);
        dayAddButton = (Button) findViewById(R.id.day_add);
        dayButton = (Button) findViewById(R.id.day_button);
        daySubButton = (Button) findViewById(R.id.day_sub);

        xingView = (EditText) findViewById(R.id.xing);
        nameView = (EditText) findViewById(R.id.name);

        smallButton = (Button) findViewById(R.id.smallButton);
        bigButton = (Button) findViewById(R.id.bigButton);


        updateYear(currentYear);
        updateMonth(currentMonth);
        updateDay(currentDay);

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

        yearSubButton.setOnClickListener(new View.OnClickListener() {
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


//        小运

        smallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String xing=xingView.getText().toString();
                String name=nameView.getText().toString();

                ChineseBiHua bihua=new ChineseBiHua();
                int xingCount= bihua.getContentCount(xing);
                int nameCount= bihua.getContentCount(name);


                if (xingCount>0&&nameCount>0) {

                    GuaName guaName = new GuaName();
                    int guaNumber = guaName.getGua(xingCount, nameCount);

                    Intent intent=new Intent();
                    intent.setClass(BigSmallYunActivity.this,ShowBigSmallDetailActivity.class);
                    intent.putExtra("xing",xing);
                    intent.putExtra("name",name);
                    intent.putExtra("type","small");
                    intent.putExtra("year",currentYear);
                    intent.putExtra("month",currentMonth);
                    intent.putExtra("day",currentDay);
                    intent.putExtra("guaNumber",guaNumber);
                    startActivity(intent);


                }else {
                    Toast.makeText(BigSmallYunActivity.this,"姓氏和名字必须都有汉字",Toast.LENGTH_LONG).show();
                }


            }
        });


        //        大运

        bigButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String xing=xingView.getText().toString();
                String name=nameView.getText().toString();

                ChineseBiHua bihua=new ChineseBiHua();
                int xingCount= bihua.getContentCount(xing);
                int nameCount= bihua.getContentCount(name);


                if (xingCount>0&&nameCount>0) {

                    GuaName guaName = new GuaName();
                    int guaNumber = guaName.getGua(xingCount, nameCount);

                    Intent intent=new Intent();
                    intent.setClass(BigSmallYunActivity.this,ShowBigSmallDetailActivity.class);
                    intent.putExtra("xing",xing);
                    intent.putExtra("name",name);
                    intent.putExtra("type","big");
                    intent.putExtra("year",currentYear);
                    intent.putExtra("month",currentMonth);
                    intent.putExtra("day",currentDay);
                    intent.putExtra("guaNumber",guaNumber);
                    startActivity(intent);


                }else {
                    Toast.makeText(BigSmallYunActivity.this,"姓氏和名字必须都有汉字",Toast.LENGTH_LONG).show();
                }

            }
        });


    }


    public void back(View v) {
        finish();
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
