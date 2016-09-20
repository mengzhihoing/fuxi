package ninecity.myfragments.Fragment;

import android.app.Fragment;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import ninecity.myfragments.R;

/**
 * Created by wangxiang on 2016/9/9.
 */
public class MeFragment extends Fragment {

    private Button qqButton, zhifubaoButton;
    private TextView textView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View messageLayout = inflater.inflate(R.layout.me_layout, container, false);


        qqButton = (Button) messageLayout.findViewById(R.id.QQ);
        zhifubaoButton = (Button) messageLayout.findViewById(R.id.donate);
        textView = (TextView) messageLayout.findViewById(R.id.show_version);

        showContent();


        qqButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ClipboardManager cmb = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
                cmb.setText("523683078");

                Toast.makeText(getActivity(), "复制成功", Toast.LENGTH_LONG).show();


            }
        });


        zhifubaoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ClipboardManager cmb = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
                cmb.setText("lzpszy@163.com");

                Toast.makeText(getActivity(), "复制成功", Toast.LENGTH_LONG).show();


            }
        });


        return messageLayout;


    }


    private void showContent() {


        String content = "版本:";

        String v = "";

        try {
            v = getVersionName().toString();
            content += v;
        } catch (Exception e) {
            e.printStackTrace();
        }

        content += "\n\n本软件下载、使用完全免费，限学习交流使用，请勿用于商业目的。\n iOS版可以在app store搜索“伏羲易”下载。\n\n目前缺大小运和城市卦,预计11完成.有任何问题请在群里反映\n\n";

        textView.setText(content);

    }


    private String getVersionName() throws Exception {
        // 获取packagemanager的实例
        PackageManager packageManager = getActivity().getPackageManager();
        // getPackageName()是你当前类的包名，0代表是获取版本信息
        PackageInfo packInfo = packageManager.getPackageInfo(getActivity().getPackageName(), 0);
        String version = packInfo.versionName;
        return version;
    }
}
