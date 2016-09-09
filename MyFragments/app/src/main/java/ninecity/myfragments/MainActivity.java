package ninecity.myfragments;


import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity implements View.OnClickListener {
    /**
     * 用于展示消息的Fragment
     */
    private MessageFragment messageFragment;

    /**
     * 用于展示动态的Fragment
     */
    private TwoFragment twoFragment;

    /**
     * 用于展示设置的Fragment
     */
    private ThreeFragment threeFragment;

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

    private ImageView oneimg, twoimg, threeimg;

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
        oneimg = (ImageView) findViewById(R.id.message_image);
        twoimg = (ImageView) findViewById(R.id.contacts_image);
        threeimg = (ImageView) findViewById(R.id.news_image);
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
//                messageLayout.setBackgroundColor(0xff0000ff);
//                messageLayout.setBackgroundResource(R.drawable.home_select);
                oneimg.setImageResource(R.drawable.home_select);
                if (messageFragment == null) {
                    // 如果MessageFragment为空，则创建一个并添加到界面上
                    messageFragment = new MessageFragment();
                    transaction.add(R.id.content, messageFragment);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(messageFragment);
                }
                break;
            case 1:
                // 当点击了联系人tab时，改变控件的图片和文字颜色
//                twoLayout.setBackgroundColor(0xff0000ff);
//                twoLayout.setBackgroundResource(R.drawable.mystudy_select);
                twoimg.setImageResource(R.drawable.mystudy_select);
                if (twoFragment == null) {
                    // 如果ContactsFragment为空，则创建一个并添加到界面上
                    twoFragment = new TwoFragment();
                    transaction.add(R.id.content, twoFragment);
                } else {
                    // 如果ContactsFragment不为空，则直接将它显示出来
                    transaction.show(twoFragment);
                }
                break;
            case 2:
            default:
                // 当点击了动态tab时，改变控件的图片和文字颜色
//                threeLayout.setBackgroundColor(0xff0000ff);
//                threeLayout.setBackgroundResource(R.drawable.found_select);
                threeimg.setImageResource(R.drawable.found_select);
                if (threeFragment == null) {
                    // 如果NewsFragment为空，则创建一个并添加到界面上
                    threeFragment = new ThreeFragment();
                    transaction.add(R.id.content, threeFragment);
                } else {
                    // 如果NewsFragment不为空，则直接将它显示出来
                    transaction.show(threeFragment);
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
        if (messageFragment != null) {
            transaction.hide(messageFragment);
        }
        if (twoFragment != null) {
            transaction.hide(twoFragment);
        }
        if (threeFragment != null) {
            transaction.hide(threeFragment);
        }
    }

    /**
     * 清除掉所有的选中状态。
     */
    private void clearSelection() {
//        messageLayout.setBackgroundColor(0xffffffff);
//        twoLayout.setBackgroundColor(0xffffffff);
//        threeLayout.setBackgroundColor(0xffffffff);

        oneimg.setImageResource(R.drawable.home_normal);
        twoimg.setImageResource(R.drawable.mystudy_normal);
        threeimg.setImageResource(R.drawable.found_normal);
    }
}
