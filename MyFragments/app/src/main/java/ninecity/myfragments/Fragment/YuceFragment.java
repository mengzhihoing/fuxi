package ninecity.myfragments.Fragment;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import ninecity.myfragments.Activity.BigSmallYunActivity;
import ninecity.myfragments.Activity.CenturyActivity;
import ninecity.myfragments.Activity.ChooseGuaActivity;
import ninecity.myfragments.Activity.ShowRiliActivity;
import ninecity.myfragments.Activity.YearActivity;
import ninecity.myfragments.R;

/**
 * Created by wangxiang on 2016/9/9.
 */
public class YuceFragment extends Fragment {

    private ImageButton riliButtton, fastButton, cityButton, the9GridButton, bigSmallButton, yearButton, centerButton;

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

        riliButtton = (ImageButton) view.findViewById(R.id.rili);
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

        fastButton = (ImageButton) view.findViewById(R.id.fast);
        fastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), ChooseGuaActivity.class);
                intent.putExtra("type","fast");
                startActivity(intent);
            }

        });

    }

    public void city(View view) {

        cityButton = (ImageButton) view.findViewById(R.id.city);
        cityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent();
//                intent.setClass(getActivity(), ShowRiliActivity.class);
//                startActivity(intent);

                Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("https://raw.githubusercontent.com/mengzhihoing/json/master/fuxiyi.apk"));
                it.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
                getActivity().startActivity(it);
            }

        });

    }

    public void the9Grid(View view) {

        the9GridButton = (ImageButton) view.findViewById(R.id.the9Grid);
        the9GridButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), ChooseGuaActivity.class);
                intent.putExtra("type","the9Grid");
                startActivity(intent);
            }

        });

    }

    public void bigSmall(View view) {

        bigSmallButton = (ImageButton) view.findViewById(R.id.bigSmallYun);
        bigSmallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), BigSmallYunActivity.class);
                startActivity(intent);
            }

        });

    }

    public void year(View view) {

        yearButton = (ImageButton) view.findViewById(R.id.year);
        yearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), YearActivity.class);
                startActivity(intent);
            }

        });

    }

    public void center(View view) {

        centerButton = (ImageButton) view.findViewById(R.id.center);
        centerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), CenturyActivity.class);
                startActivity(intent);
            }

        });

    }


}
