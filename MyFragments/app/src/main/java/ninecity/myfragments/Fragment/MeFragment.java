package ninecity.myfragments.Fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.GetCallback;
import com.avos.avoscloud.SaveCallback;
import com.avos.avoscloud.feedback.FeedbackAgent;

import ninecity.myfragments.Activity.AboutActivity;
import ninecity.myfragments.Activity.EyesActivity;
import ninecity.myfragments.R;

/**
 * Created by wangxiang on 2016/9/9.
 */
public class MeFragment extends Fragment {


    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View messageLayout = inflater.inflate(R.layout.me_layout, container, false);


        String[] dataArray = {"意见反馈", "检查更新", "眼跳预测", "关于"};

        ListView listView = (ListView) messageLayout.findViewById(R.id.meListView);

        ListAdapter adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, dataArray);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {

                    case 0: {

                        FeedbackAgent agent = new FeedbackAgent(getActivity());
                        agent.startDefaultThreadActivity();

                    }

                    break;

                    case 1: {


                        String v = "";
                        double currentVersion = 0;

                        try {
                            v = getVersionName().toString();
                            currentVersion = Double.parseDouble(v);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        Log.v("e1", String.valueOf(currentVersion));


//                        版本更新
                        AVQuery<AVObject> avQuery = new AVQuery<>("androidVersion");
                        final Double finalCurrentVersion = currentVersion;
                        avQuery.getInBackground("57e49006816dfa005ed11c70", new GetCallback<AVObject>() {
                            @Override
                            public void done(AVObject avObject, AVException e) {
                                if (e == null) {
                                    // 成功
                                    double version = avObject.getDouble("version");
                                    String content = avObject.getString("content");

                                    if (finalCurrentVersion < version) {

                                        new AlertDialog.Builder(getActivity())

                                                .setTitle("发现新版本")

                                                .setMessage("请在腾讯应用宝中下载新版本\n" + content)

                                                .setPositiveButton("确定", null)

                                                .show();
                                    } else {
                                        Toast.makeText(getActivity(), "当前是最新版", Toast.LENGTH_LONG).show();
                                    }


                                } else {
                                    Log.v("f", "failure");
                                }

                            }
                        });

                    }

                    break;
                    case 2: {

                        Intent intent = new Intent();
                        intent.setClass(getActivity(), EyesActivity.class);
                        startActivity(intent);

                    }

                    break;


                    default: {
                        Intent intent = new Intent();
                        intent.setClass(getActivity(), AboutActivity.class);
                        startActivity(intent);
                    }

                    break;


                }
            }
        });


        return messageLayout;


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
