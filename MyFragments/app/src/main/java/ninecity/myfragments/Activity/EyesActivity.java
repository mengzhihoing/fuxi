package ninecity.myfragments.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ninecity.myfragments.R;

public class EyesActivity extends AppCompatActivity {


    String[] eyesArray = {"子时: 23点-01点", "丑时: 01点-03点", "寅时: 03点-05点", "卯时: 05点-07点", "辰时: 07点-09点", "巳时: 09点-11点", "午时: 11点-13点", "未时: 13点-15点", "申时: 15点-17点", "酉时: 17点-19点", "戌时: 19点-21点", "亥时: 21点-23点"};
    int index = 0;
    private Button leftButton, rightButton, fetchButton, addButton, subButton, timeButton;
    private TextView textView;
    boolean isLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eyes);

        leftButton = (Button) findViewById(R.id.left);
        rightButton = (Button) findViewById(R.id.right);
        fetchButton = (Button) findViewById(R.id.fetchButton);
        addButton = (Button) findViewById(R.id.time_add);
        timeButton = (Button) findViewById(R.id.timeButton);
        subButton = (Button) findViewById(R.id.time_sub);
        textView = (TextView) findViewById(R.id.showEyes);
        isLeft = true;

        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                left();
            }
        });

        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                right();
            }
        });


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                add();
            }
        });

        subButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sub();
            }
        });


        fetchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetch();
            }
        });


    }


    public void back(View view) {

        finish();

    }


    private void add() {

        index++;

        if (index > 11) {
            index = 0;
        }

        updateTime();

    }


    private void sub() {
        index--;

        if (index < 0) {
            index = 11;
        }

        updateTime();
    }


    private void updateTime() {


        String content = eyesArray[index];

        timeButton.setText(content);


    }


    private void left() {

        leftButton.setBackgroundColor((this.getResources().getColor(R.color.purple)));
        rightButton.setBackgroundColor((this.getResources().getColor(R.color.gray)));
        isLeft = true;

    }

    private void right() {

        rightButton.setBackgroundColor((this.getResources().getColor(R.color.purple)));
        leftButton.setBackgroundColor((this.getResources().getColor(R.color.gray)));
        isLeft = false;
    }


    private void fetch() {


        String[] leftContent = {"\t意外之喜降临，会有不错好运，你的心脏要强一点，别兴奋过了头。\n", "\t家中最近很麻烦，大小事困扰着，不知道该怎么办，短期内一筹莫展。\n", "\t会有朋友自远方来狠狠吃你一餐！如果你并非闲钱多，接到朋友电话要装忙哦。\n", "\t贵人或贵客报到，让你生命重现曙光，多留意忽然出现在你身边很久不见的朋友。\n", "\t人际关系会变好，许久不见的朋友再次相逢，可能带来不错的喜讯。\n", "\t会有好处可以捞，目前的你颇有利用价值，别人都会让你三分。\n", "\t长期耕耘总算有了结果，你可以松一口气，准备享受成果吧。\n", "\t你可能在打赌或是玩麻将时输了不少钱，别输光了才后悔。\n", "\t忽然想起什么事情吗？快点去做，当下想到的，最容易成功。\n", "\t为人辛苦，为人忙，好在有收获，帮别人的同时，也是在帮自己。\n", "\t有人指派工作给你，不要想太多，快点答应，其他的问题会自然迎刃而解哦。\n", "\t享受合家团圆、受到多方肯定，再加把劲，你会做得更漂亮。\n"};
        String[] rightContent = {"\t有人请你吃饭，可以省下一笔钱，但这人的目的不明，你要多斟酌。\n", "\t有人思念你，可能是家中长辈，相互牵挂太久了，有空打个电话吧。\n", "\t家人有机会得到意外之财，例如忽然中了奖，也有可能丢掉的钱又找回来了。\n", "\t平安顺利，不必太过担心可能发生危险的状况，吉人自有天相，安心睡觉吧。\n", "\t钱财就这样不知不觉的流失掉，花了许多冤枉钱。\n", "\t开车小心，提醒家人多注意安全，危险出现在四周。\n", "\t意料之外的事情发生了，还好几率不高，继续保持警戒才好。\n", "\t有好事发生，但属于微不足道，你也不会很高兴的那种小事。\n", "\t异性缘佳，你的贵人就是异性，她们对你，比同性宽容多了。\n", "\t刚认识的朋友就可以熟得不得了，和他们多混熟点会很不错。\n", "\t得意忘形了吗？小心小人随时准备落井下石，你别太嚣张喽。\n", "\t提防官司纠纷，你要么是口舌冒犯人，要么就是弄坏东西。\n"};


        String content = "";

        if (isLeft) {

            content = leftContent[index];

        } else {
            content = rightContent[index];
        }

        textView.setText(content);


    }

}
