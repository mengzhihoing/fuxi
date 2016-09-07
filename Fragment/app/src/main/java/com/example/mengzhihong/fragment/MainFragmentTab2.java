package com.example.mengzhihong.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by mengzhihong on 2016/9/7.
 */
public class MainFragmentTab2 extends Fragment
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        System.out.println("MainTab2 onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        System.out.println("MainTab2 onCreateView");
        return inflater.inflate(R.layout.main_tab2, container, true);
    }
}
