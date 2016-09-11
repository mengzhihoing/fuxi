package ninecity.myfragments.Fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import ninecity.myfragments.Activity.DetailActivity;
import ninecity.myfragments.Activity.ShowRiliActivity;
import ninecity.myfragments.Class.Lunar;
import ninecity.myfragments.R;

/**
 * Created by wangxiang on 2016/9/9.
 */
public class YuceFragment extends Fragment {

    private Button buttton;
    private TextView textView;
    static SimpleDateFormat chineseDateFormat = new SimpleDateFormat("yyyy年MM月dd日");


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.yuce_layout, container, false);
        buttton=(Button) view.findViewById(R.id.button);
        textView=(TextView)view.findViewById(R.id.text);
        buttton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


//                Calendar cal=Calendar.getInstance();
//                SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日");
//                cal.setTimeZone(TimeZone.getDefault());
//                System.out.println("公历日期:"+sdf.format(cal.getTime()));
//                Lunar lunar=new Lunar(cal);
//                System.out.print("农历日期:");
//                System.out.print(lunar.year+"年 ");
//                System.out.print(lunar.month+"月 ");
//                System.out.print(lunar.getChinaDayString(lunar.day));
//                System.out.println("*************");


                Intent intent=new Intent();
                intent.setClass(getActivity(),ShowRiliActivity.class);
//                intent.putExtra("guaNumber",kGuaNumber);

                startActivity(intent);


            }

        });



        return view;
    }
}
