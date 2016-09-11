package ninecity.myfragments.Class;

import java.util.GregorianCalendar;

/**
 * Created by meng on 2016/9/11.
 */
public class NongLi {

    int y, m, d;      //solar calendar
    long[] lunarInt = new long[7];  //.year0 .month1 .day2 .yearCyl3 .monCyl4 .dayCyl5 .isLeap6
    String[] lunarStr = new String[7];//.animal0 .lunarMonth1 .lunarDay2 .yearCyl3 .monCyl4 .dayCyl5 .isLeap6

    public NongLi(int y, int m, int d) {
        this.y = y >= 1900 && y < 2100 ? y : 2000; //default 2000
        this.m = m > 0 && m < 13 ? m : 1;          //default 1
        this.d = d > 0 && d < 32 ? d : 1;          //default 1
    }

    final static long[] lunarInfo = new long[]
            {0x04bd8, 0x04ae0, 0x0a570, 0x054d5, 0x0d260, 0x0d950, 0x16554, 0x056a0, 0x09ad0, 0x055d2,
                    0x04ae0, 0x0a5b6, 0x0a4d0, 0x0d250, 0x1d255, 0x0b540, 0x0d6a0, 0x0ada2, 0x095b0, 0x14977,
                    0x04970, 0x0a4b0, 0x0b4b5, 0x06a50, 0x06d40, 0x1ab54, 0x02b60, 0x09570, 0x052f2, 0x04970,
                    0x06566, 0x0d4a0, 0x0ea50, 0x06e95, 0x05ad0, 0x02b60, 0x186e3, 0x092e0, 0x1c8d7, 0x0c950,
                    0x0d4a0, 0x1d8a6, 0x0b550, 0x056a0, 0x1a5b4, 0x025d0, 0x092d0, 0x0d2b2, 0x0a950, 0x0b557,
                    0x06ca0, 0x0b550, 0x15355, 0x04da0, 0x0a5d0, 0x14573, 0x052d0, 0x0a9a8, 0x0e950, 0x06aa0,
                    0x0aea6, 0x0ab50, 0x04b60, 0x0aae4, 0x0a570, 0x05260, 0x0f263, 0x0d950, 0x05b57, 0x056a0,
                    0x096d0, 0x04dd5, 0x04ad0, 0x0a4d0, 0x0d4d4, 0x0d250, 0x0d558, 0x0b540, 0x0b5a0, 0x195a6,
                    0x095b0, 0x049b0, 0x0a974, 0x0a4b0, 0x0b27a, 0x06a50, 0x06d40, 0x0af46, 0x0ab60, 0x09570,
                    0x04af5, 0x04970, 0x064b0, 0x074a3, 0x0ea50, 0x06b58, 0x055c0, 0x0ab60, 0x096d5, 0x092e0,
                    0x0c960, 0x0d954, 0x0d4a0, 0x0da50, 0x07552, 0x056a0, 0x0abb7, 0x025d0, 0x092d0, 0x0cab5,
                    0x0a950, 0x0b4a0, 0x0baa4, 0x0ad50, 0x055d9, 0x04ba0, 0x0a5b0, 0x15176, 0x052b0, 0x0a930,
                    0x07954, 0x06aa0, 0x0ad50, 0x05b52, 0x04b60, 0x0a6e6, 0x0a4e0, 0x0d260, 0x0ea65, 0x0d530,
                    0x05aa0, 0x076a3, 0x096d0, 0x04bd7, 0x04ad0, 0x0a4d0, 0x1d0b6, 0x0d250, 0x0d520, 0x0dd45,
                    0x0b5a0, 0x056d0, 0x055b2, 0x049b0, 0x0a577, 0x0a4b0, 0x0aa50, 0x1b255, 0x06d20, 0x0ada0};

    final public static int lYearDays(int y)//====== 传回农历 y年的总天数
    {
        int i, sum = 348;
        for (i = 0x8000; i > 0x8; i >>= 1) {
            if ((lunarInfo[y - 1900] & i) != 0) sum += 1;
        }
        return (sum + leapDays(y));
    }

    final public static int leapDays(int y)//====== 传回农历 y年闰月的天数
    {
        if (leapMonth(y) != 0) {
            if ((lunarInfo[y - 1900] & 0x10000) != 0) return 30;
            else return 29;
        } else return 0;
    }

    final public static int leapMonth(int y)//====== 传回农历 y年闰哪个月 1-12 , 没闰传回 0
    {
        return (int) (lunarInfo[y - 1900] & 0xf);
    }

    final public static int monthDays(int y, int m)//====== 传回农历 y年m月的总天数
    {
        if ((lunarInfo[y - 1900] & (0x10000 >> m)) == 0) return 29;
        else return 30;
    }

    final public static String AnimalsYear(int y)//====== 传回农历 y年的生肖
    {
        final String[] Animals = new String[]{"鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊", "猴", "鸡", "狗", "猪"};
        return Animals[(y - 4) % 12];
    }

    final public static String cyclicalm(int num)//====== 传入 月日的offset 传回干支, 0=甲子
    {
        final String[] Gan = new String[]{"甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸"};
        final String[] Zhi = new String[]{"子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥"};
        return (Gan[num % 10] + Zhi[num % 12]);
    }

    final public static String cyclical(int y)//====== 传入 offset 传回干支, 0=甲子
    {
        int num = y - 1900 + 36;
        return (cyclicalm(num));
    }

    final public long[] getLunarInt()
    //传出y年m月d日对应的农历.year0 .month1 .day2 .yearCyl3 .monCyl4 .dayCyl5 .isLeap6
    {
        //long[] lunarInt = new long[7];  //.year0 .month1 .day2 .yearCyl3 .monCyl4 .dayCyl5 .isLeap6
        int i = 0, temp = 0, leap = 0;
        GregorianCalendar baseDate = new GregorianCalendar(1900, 0, 31);
        GregorianCalendar objDate = new GregorianCalendar(y, m - 1, d);
        long offset = (objDate.getTimeInMillis() - baseDate.getTimeInMillis()) / 86400000L;
        lunarInt[5] = offset + 40;
        lunarInt[4] = 14;
        for (i = 1900; i < 2050 && offset > 0; i++) {
            temp = lYearDays(i);
            offset -= temp;
            lunarInt[4] += 12;
        }
        if (offset < 0) {
            offset += temp;
            i--;
            lunarInt[4] -= 12;
        }
        lunarInt[0] = i;
        lunarInt[3] = i - 1864;
        leap = leapMonth(i); //闰哪个月
        lunarInt[6] = 0;
        for (i = 1; i < 13 && offset > 0; i++) {
            //闰月
            if (leap > 0 && i == (leap + 1) && lunarInt[6] == 0) {
                --i;
                lunarInt[6] = 1;
                temp = leapDays((int) lunarInt[0]);
            } else {
                temp = monthDays((int) lunarInt[0], i);
            }
            //解除闰月
            if (lunarInt[6] == 1 && i == (leap + 1)) lunarInt[6] = 0;
            offset -= temp;
            if (lunarInt[6] == 0) lunarInt[4]++;
        }
        if (offset == 0 && leap > 0 && i == leap + 1) {
            if (lunarInt[6] == 1) {
                lunarInt[6] = 0;
            } else {
                lunarInt[6] = 1;
                --i;
                --lunarInt[4];
            }
        }
        if (offset < 0) {
            offset += temp;
            --i;
            --lunarInt[4];
        }
        lunarInt[1] = i;
        lunarInt[2] = offset + 1;
        return lunarInt;
    }

    final public String[] getLunarStr() {
        long[] lun = getLunarInt();
        //String[] lunarStr = new String[7];//.animal0 .lunarMonth1 .lunarDay2 .yearCyl3 .monCyl4 .dayCyl5 .isLeap6
        String lMonth = "";
        switch ((int) lun[1]) {
            case 1:
                lMonth = "一";
                break;
            case 2:
                lMonth = "二";
                break;
            case 3:
                lMonth = "三";
                break;
            case 4:
                lMonth = "四";
                break;
            case 5:
                lMonth = "五";
                break;
            case 6:
                lMonth = "六";
                break;
            case 7:
                lMonth = "七";
                break;
            case 8:
                lMonth = "八";
                break;
            case 9:
                lMonth = "九";
                break;
            case 10:
                lMonth = "十";
                break;
            case 11:
                lMonth = "十一";
                break;
            case 12:
                lMonth = "十二";
                break;
        }
        String lDay = "";
        if (lun[2] == 10)
            lDay = "初十";
        int two = (int) ((lun[2]) / 10);
        if (two == 0)
            lDay = "初";
        if (two == 1)
            lDay = "十";
        if (two == 2)
            lDay = "廿";
        if (two == 3)
            lDay = "卅";
        int one = (int) (lun[2] % 10);
        switch (one) {
            case 1:
                lDay += "一";
                break;
            case 2:
                lDay += "二";
                break;
            case 3:
                lDay += "三";
                break;
            case 4:
                lDay += "四";
                break;
            case 5:
                lDay += "五";
                break;
            case 6:
                lDay += "六";
                break;
            case 7:
                lDay += "七";
                break;
            case 8:
                lDay += "八";
                break;
            case 9:
                lDay += "九";
                break;
        }
        lunarStr[0] = AnimalsYear((int) lun[0]);
        lunarStr[1] = lMonth;
        lunarStr[2] = lDay;
        lunarStr[3] = cyclical((int) lun[0]);
        lunarStr[4] = cyclicalm((int) lun[4]);
        lunarStr[5] = cyclicalm((int) lun[5]);
        lunarStr[6] = lun[6] == 0 ? "" : "闰";
        return lunarStr;
    }

    public void printLunar() {
        getLunarStr();
        System.out.println("公历：" + y + "年" + m + "月" + d + "日");
        System.out.println("农历：" + lunarInt[0] + "年" + lunarInt[1] + "月" + lunarInt[2] + "日");
        System.out.println("农历：" + lunarStr[0] + "年" + lunarStr[6] + lunarStr[1] + "月" + lunarStr[2] + ", " + lunarStr[3] + "年" + lunarStr[4] + "月" + lunarStr[5] + "日");
    }


    public String getFullNongli(){

        String text=String.format(lunarStr[3] + "年" + lunarStr[6] + lunarStr[1] + "月" + lunarStr[2] );

        return  text;


    }

    public int getNongliRi(){

        return  (int) lunarInt[2];

    }

}