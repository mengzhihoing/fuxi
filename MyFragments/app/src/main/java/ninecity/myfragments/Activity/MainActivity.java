package ninecity.myfragments.Activity;


import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import ninecity.myfragments.Fragment.HomeFragment;
import ninecity.myfragments.Fragment.MeFragment;
import ninecity.myfragments.Fragment.YuceFragment;
import ninecity.myfragments.R;

public class MainActivity extends Activity implements View.OnClickListener {
    /**
     * 用于展示消息的Fragment
     */
    private HomeFragment homeFragment;

    /**
     * 用于展示动态的Fragment
     */
    private YuceFragment yuceFragment;

    /**
     * 用于展示设置的Fragment
     */
    private MeFragment meFragment;

    /**
     * 消息界面布局
     */
    private View messageLayout;

    /**
     * 联系人界面布局
     */
    private View twoLayout;

    /**
     * 动态界面布局
     */
    private View threeLayout;

    /**
     * 用于对Fragment进行管理
     */
    private FragmentManager fragmentManager;

    private ImageView homeImage, yuceImage, meImage;
    private TextView homeText, yuceText, meText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        fragmentManager = getFragmentManager();
        // 第一次启动时选中第0个tab
        setTabSelection(0);
    }

    /**
     * 在这里获取到每个需要用到的控件的实例，并给它们设置好必要的点击事件。
     */

    private void initViews() {
        homeText=(TextView)findViewById(R.id.home_text);
        yuceText=(TextView)findViewById(R.id.yuce_text);
        meText=(TextView)findViewById(R.id.me_text);

        homeImage = (ImageView) findViewById(R.id.message_image);
        yuceImage = (ImageView) findViewById(R.id.contacts_image);
        meImage = (ImageView) findViewById(R.id.news_image);
        messageLayout = findViewById(R.id.message_layout);
        twoLayout = findViewById(R.id.contacts_layout);
        threeLayout = findViewById(R.id.news_layout);
        messageLayout.setOnClickListener(this);
        twoLayout.setOnClickListener(this);
        threeLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.message_layout:
                // 当点击了消息tab时，选中第1个tab
                setTabSelection(0);
                break;
            case R.id.contacts_layout:
                // 当点击了联系人tab时，选中第2个tab
                setTabSelection(1);
                break;
            case R.id.news_layout:
                // 当点击了动态tab时，选中第3个tab
                setTabSelection(2);
                break;
            default:
                break;
        }

    }

    /**
     * 根据传入的index参数来设置选中的tab页。
     *
     * @param index
     * 每个tab页对应的下标。0表示消息，1表示联系人，2表示动态，3表示设置。
     */
    private void setTabSelection(int index) {
        // 每次选中之前先清楚掉上次的选中状态
        clearSelection();
        // 开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        switch (index) {
            case 0:
                homeText.setTextColor(this.getResources().getColor(R.color.textSelectedColor));
                homeImage.setImageResource(R.drawable.home_select);
                if (homeFragment == null) {
                    // 如果MessageFragment为空，则创建一个并添加到界面上
                    homeFragment = new HomeFragment();
                    transaction.add(R.id.content, homeFragment);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(homeFragment);
                }
                break;
            case 1:
                yuceText.setTextColor(this.getResources().getColor(R.color.textSelectedColor));
                yuceImage.setImageResource(R.drawable.mystudy_select);
                if (yuceFragment == null) {
                    // 如果ContactsFragment为空，则创建一个并添加到界面上
                    yuceFragment = new YuceFragment();
                    transaction.add(R.id.content, yuceFragment);
                } else {
                    // 如果ContactsFragment不为空，则直接将它显示出来
                    transaction.show(yuceFragment);
                }
                break;
            case 2:
            default:
                meText.setTextColor(this.getResources().getColor(R.color.textSelectedColor));
                meImage.setImageResource(R.drawable.found_select);
                if (meFragment == null) {
                    // 如果NewsFragment为空，则创建一个并添加到界面上
                    meFragment = new MeFragment();
                    transaction.add(R.id.content, meFragment);
                } else {
                    // 如果NewsFragment不为空，则直接将它显示出来
                    transaction.show(meFragment);
                }
                break;
        }
        transaction.commit();
    }

    /**
     * 将所有的Fragment都置为隐藏状态。
     *
     * @param transaction
     * 用于对Fragment执行操作的事务
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (homeFragment != null) {
            transaction.hide(homeFragment);
        }
        if (yuceFragment != null) {
            transaction.hide(yuceFragment);
        }
        if (meFragment != null) {
            transaction.hide(meFragment);
        }
    }

    /**
     * 清除掉所有的选中状态。
     */
    private void clearSelection() {
//        messageLayout.setBackgroundColor(0xffffffff);
//        twoLayout.setBackgroundColor(0xffffffff);
//        threeLayout.setBackgroundColor(0xffffffff);

        homeText.setTextColor(this.getResources().getColor(R.color.gray));
        yuceText.setTextColor(this.getResources().getColor(R.color.gray));
        meText.setTextColor(this.getResources().getColor(R.color.gray));

        homeImage.setImageResource(R.drawable.home_normal);
        yuceImage.setImageResource(R.drawable.mystudy_normal);
        meImage.setImageResource(R.drawable.found_normal);
    }
}
