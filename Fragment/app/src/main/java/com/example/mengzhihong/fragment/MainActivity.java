package com.example.mengzhihong.fragment;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TabHost;
import android.widget.Toast;

public class MainActivity extends FragmentActivity
{
    private TabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //取得TabHost对象
        mTabHost = (TabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup();
        //为TabHost添加标签
        mTabHost.addTab(mTabHost.newTabSpec("tab1").setIndicator("首页",getResources().getDrawable(R.drawable.home_select)).setContent(R.id.tab1));
        mTabHost.addTab(mTabHost.newTabSpec("tab2").setIndicator("预测",getResources().getDrawable(R.drawable.found_normal)).setContent(R.id.tab2));
        mTabHost.addTab(mTabHost.newTabSpec("tab3").setIndicator("我",getResources().getDrawable(R.drawable.mystudy_normal)).setContent(R.id.tab3));
//        mTabHost.addTab(mTabHost.newTabSpec("tab4").setIndicator("Frag4",getResources().getDrawable(R.drawable.ic_launcher)).setContent(R.id.tab4));
        //设置TabHost的背景颜色
//        mTabHost.setBackgroundColor(Color.argb(150, 22, 70, 150));
        //设置当前显示哪一个标签
        mTabHost.setCurrentTab(0);

        //标签切换事件处理，setOnTabChangedListener
        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener()
        {
            @Override
            public void onTabChanged(String tabId)
            {
//                Toast.makeText(MainActivity.this, "你选择了标签为:"+tabId, Toast.LENGTH_SHORT).show();
            }
        });
    }

}

