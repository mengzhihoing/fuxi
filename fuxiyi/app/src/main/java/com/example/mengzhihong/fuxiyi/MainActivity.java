package com.example.mengzhihong.fuxiyi;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.example.mengzhihong.fuxiyi.Fragment.HomeFragment;
import com.example.mengzhihong.fuxiyi.Fragment.MeFragment;
import com.example.mengzhihong.fuxiyi.Fragment.YuceFragment;

public class MainActivity extends AppCompatActivity implements AHBottomNavigation.OnTabSelectedListener {

    AHBottomNavigation bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        bottomNavigation=(AHBottomNavigation)findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnTabSelectedListener(this);
        this.createNavItems();

    }

    public void createNavItems(){

        AHBottomNavigationItem homeItem=new AHBottomNavigationItem("home",R.drawable.ic_launcher);
        AHBottomNavigationItem yuceItem=new AHBottomNavigationItem("yuce",R.drawable.ic_launcher);
        AHBottomNavigationItem meItem=new AHBottomNavigationItem("me",R.drawable.ic_launcher);

        bottomNavigation.addItem(homeItem);
        bottomNavigation.addItem(yuceItem);
        bottomNavigation.addItem(meItem);

        bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#FEFEFE"));

        bottomNavigation.setCurrentItem(0);
    }


    @Override
    public boolean onTabSelected(int position, boolean wasSelected) {

        if (position==0){
            HomeFragment homeFragment=new HomeFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_id,homeFragment).commit();
        }else  if (position==1){
            YuceFragment yuceFragment=new YuceFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_id,yuceFragment).commit();
        }else  if (position==2){
            MeFragment meFragment=new MeFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_id,meFragment).commit();
        }
        return true;

    }





}
