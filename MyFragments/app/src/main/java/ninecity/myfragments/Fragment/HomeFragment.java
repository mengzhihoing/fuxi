package ninecity.myfragments.Fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ninecity.myfragments.Class.ChineseBiHua;
import ninecity.myfragments.Activity.DetailActivity;
import ninecity.myfragments.Class.GuaName;
import ninecity.myfragments.R;

/**
 * Created by wangxiang on 2016/9/9.
 */

public class HomeFragment extends Fragment {
    private Context mcontext;
    private Button fetchButton;
    private Button detailButton;

    //    是否可以进入详情
    private boolean canGo=false;
    private int kGuaNumber=0;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.home_layout, container, false);


        mcontext = getActivity();

        fetchButton = (Button) view.findViewById(R.id.button);
        detailButton = (Button) view.findViewById(R.id.button1);
        detailButton();

        fetchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent=new Intent();
//                intent.setClass(mcontext,Main2Activity.class);
//                startActivity(intent);


                TextView textView=(TextView)getActivity().findViewById(R.id.showText);
                EditText edit=(EditText)getActivity().findViewById(R.id.xing);
                EditText edit1=(EditText)getActivity().findViewById(R.id.name);

                String xingContent=edit.getText().toString();
                String nameContent=edit1.getText().toString();

                ChineseBiHua bihua=new ChineseBiHua();
                int xingCount= bihua.getContentCount(xingContent);
                int nameCount= bihua.getContentCount(nameContent);



                GuaName gua=new GuaName();

                int guaNumber=gua.getGua(xingCount,nameCount);



                String describe="";
                if (xingCount>0&&nameCount>0) {

                    canGo=true;
                    kGuaNumber=guaNumber;

                    String benMingGua=String.format("本命卦：%s",gua.getFullBenMing(guaNumber));
                    String successGua=String.format("成功卦：%s",gua.getFullSuccess(guaNumber));
                    String failureGua=String.format("失败卦：%s",gua.getFullFailure(guaNumber));
                    String shuaiBianGua=String.format("衰变卦：%s",gua.getFullShuaiBian(guaNumber));

                    describe = String.format("\"%s%s\"的笔画数是：%d+%d=%d\n %s\n %s\n %s\n %s", xingContent, nameContent, xingCount, nameCount, xingCount + nameCount, benMingGua, successGua, failureGua, shuaiBianGua);
                }else {
                    canGo=false;
                    describe = String.format("\"%s%s\"的笔画数是：%d+%d=%d\n ", xingContent, nameContent, xingCount, nameCount, xingCount + nameCount);
                }

                textView.setText(describe);

            }


        });
        return view;
    }


    public void detailButton(){


        detailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushToDetail();
            }
        });

    }

    //    进入详情
    public void pushToDetail(){

        if(canGo==false) {

            Toast.makeText(getActivity(), "姓氏和名字都必须有汉字", Toast.LENGTH_LONG).show();

            Log.i("warning","name is null");

        }else {



            Intent intent=new Intent();
            intent.setClass(mcontext,DetailActivity.class);
            intent.putExtra("guaNumber",kGuaNumber);

            startActivity(intent);
        }

    }



}
