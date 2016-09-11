package ninecity.myfragments.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ninecity.myfragments.R;

/**
 * Created by wangxiang on 2016/9/9.
 */
public class MeFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View messageLayout = inflater.inflate(R.layout.me_layout, container, false);

        return messageLayout;
    }
}
