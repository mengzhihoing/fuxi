package ninecity.myfragments.Fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import ninecity.myfragments.Activity.DetailActivity;
import ninecity.myfragments.Activity.FastFetchActivity;
import ninecity.myfragments.Activity.ShowRiliActivity;
import ninecity.myfragments.Class.Lunar;
import ninecity.myfragments.R;

/**
 * Created by wangxiang on 2016/9/9.
 */
public class YuceFragment extends Fragment {

    private Button riliButtton, fastButton, cityButton, the9GridButton, bigSmallButton, yearButton, centerButton;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.yuce_layout, container, false);

        rili(view);
        fast(view);
        city(view);
        the9Grid(view);
        bigSmall(view);
        year(view);
        center(view);

        return view;
    }

    public void rili(View view) {

        riliButtton = (Button) view.findViewById(R.id.rili);
        riliButtton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), ShowRiliActivity.class);
                startActivity(intent);
            }

        });

    }

    public void fast(View view) {

        fastButton = (Button) view.findViewById(R.id.fast);
        fastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), FastFetchActivity.class);
                startActivity(intent);
            }

        });

    }

    public void city(View view) {

        cityButton = (Button) view.findViewById(R.id.city);
        cityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), ShowRiliActivity.class);
                startActivity(intent);
            }

        });

    }

    public void the9Grid(View view) {

        the9GridButton = (Button) view.findViewById(R.id.the9Grid);
        the9GridButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), ShowRiliActivity.class);
                startActivity(intent);
            }

        });

    }

    public void bigSmall(View view) {

        bigSmallButton = (Button) view.findViewById(R.id.bigSmallYun);
        bigSmallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), ShowRiliActivity.class);
                startActivity(intent);
            }

        });

    }

    public void year(View view) {

        yearButton = (Button) view.findViewById(R.id.year);
        yearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), ShowRiliActivity.class);
                startActivity(intent);
            }

        });

    }

    public void center(View view) {

        centerButton = (Button) view.findViewById(R.id.center);
        centerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), ShowRiliActivity.class);
                startActivity(intent);
            }

        });

    }


}
