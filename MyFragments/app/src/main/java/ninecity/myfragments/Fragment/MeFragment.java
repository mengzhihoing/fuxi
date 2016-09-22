package ninecity.myfragments.Fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

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

                    }

                    break;
                    case 2: {

                        Intent intent=new Intent();
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


//

        return messageLayout;


    }


}
