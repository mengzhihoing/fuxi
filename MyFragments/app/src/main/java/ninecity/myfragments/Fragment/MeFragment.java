package ninecity.myfragments.Fragment;

import android.app.Fragment;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import ninecity.myfragments.R;

/**
 * Created by wangxiang on 2016/9/9.
 */
public class MeFragment extends Fragment {

    private Button qqButton, zhifubaoButton;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View messageLayout = inflater.inflate(R.layout.me_layout, container, false);


        qqButton = (Button) messageLayout.findViewById(R.id.QQ);
        zhifubaoButton = (Button) messageLayout.findViewById(R.id.donate);

        qqButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ClipboardManager cmb = (ClipboardManager)getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
                cmb.setText("523683078");

                Toast.makeText(getActivity(), "复制成功", Toast.LENGTH_LONG).show();


            }
        });



        zhifubaoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ClipboardManager cmb = (ClipboardManager)getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
                cmb.setText("lzpszy@163.com");

                Toast.makeText(getActivity(), "复制成功", Toast.LENGTH_LONG).show();


            }
        });


        return messageLayout;


    }
}
