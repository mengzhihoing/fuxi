package com.example.meng.listview;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends ListActivity {


    private List<Map<String, Object>> mData;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String[] dataArray={"1","2","3","4","5","6"};

        ListAdapter adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,dataArray);

        ListView listView=(ListView) findViewById(R.id.listView);
         listView.setAdapter(adapter);

    }




}

