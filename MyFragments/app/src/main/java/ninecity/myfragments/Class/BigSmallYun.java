package ninecity.myfragments.Class;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by meng on 16/9/26.
 */
public class BigSmallYun {


    //    小运周期  1 1 3 0
    private int[] getSmallYunZhouqiArray(String yaoCi) {

        int number1 = 10;
        int number2 = getYaoCiLength(yaoCi);


//        year
        int nian = number1 / number2;

        //    （60-8*7）*12=48
        int shengYuNian = (number1 - nian * number2) * 12;
        //  月
        int yue = shengYuNian / number2;
        //    48-6*7=6
        int shengYuYue = shengYuNian - yue * number2;
        //    日
        int ri = shengYuYue * 30 / number2;
        //   剩余日

        int shengYuRi = shengYuYue * 30 - ri * number2;


        int[] array = {nian, yue, ri, shengYuRi};

        return array;

    }


    //    获取整个小运周期 {[1,2,0,0],[1,2,0,0],}
    private List getAllSmallYunZhouqiArray(List yaociList) {

        List arrayList = new ArrayList();

        for (int i = 0; i < yaociList.size(); i++) {
            String yaoci = yaociList.get(i).toString();

            int[] tmpList = getSmallYunZhouqiArray(yaoci);

            arrayList.add(tmpList);

        }


        return arrayList;
    }


    private int getIndexWithMonth(int month) {

        int index = 0;

        switch (month) {

            case 1:
            case 2: {
                index = 1;
            }

            break;

            case 3:
            case 4: {
                index = 2;

            }

            break;

            case 5:
            case 6: {
                index = 3;

            }

            break;

            case 7:
            case 8: {
                index = 4;

            }

            break;

            case 9:
            case 10: {
                index = 5;

            }

            break;

            case 11:
            case 12: {
                index = 6;

            }

            break;


            default: {

            }

        }

        return index;

    }


    private List sortedArrayWithArray(List list, int month) {

        int index = getIndexWithMonth(month);


        index--;

        if (index == 0) {
            return list;
        }

        List newList = new ArrayList();

        for (int i = index; i < list.size(); i++) {
            newList.add(list.get(i));
        }


        for (int i = 0; i < index; i++) {
            newList.add(list.get(i));
        }


        return newList;


    }


    public List getSortedAllXiaoYunZhouQi(List yaociList, int month) {

        List cycle = getAllSmallYunZhouqiArray(yaociList);

        return sortedArrayWithArray(cycle, month);

    }


    public List getSortedYaoCi(List list, int month) {


        return sortedArrayWithArray(list, month);

    }


    public String getFullXiaoYunYaoCiAndZhouQi(List yaociList, int month) {
//        排序后的爻辞
        List sortedYaoci = getSortedYaoCi(yaociList, month);

        String content = "排序后的爻辞:\n";

        content += hanldList(sortedYaoci);


        //获取小运周期

        List list = getSortedAllXiaoYunZhouQi(yaociList, month);

        content += "\n\n对应周期:\n";


        String[] liveArray = {"出生-10岁: ", "11岁-20岁: ", "21岁-30岁: ", "31岁-40岁: ", "41岁-50岁: ", "51岁-60岁: "};


        for (int i = 0; i < list.size(); i++) {

            content += liveArray[i];

            int[] tempList = (int[]) list.get(i);
            content += handleZhouQi(tempList);
            content += "\n";

        }


        return content;


    }


    private String handleZhouQi(int[] list) {


        return String.format("%d年%d月%d日%d日剩余", list[0], list[1], list[2], list[3]);

    }


    private String hanldList(List listArray) {


        String content = "";

        for (int i = 0; i < listArray.size(); i++) {
            content += String.valueOf(listArray.get(i));
            content += "\n";
        }

        return content;

    }


    public List getXiaoYunYaoZi(List yaociList, int month) {

        //        排序后的爻辞
        List sortedYaoci = getSortedYaoCi(yaociList, month);

        List newList = new ArrayList();

        for (int i = 0; i < sortedYaoci.size(); i++) {

            String yaoci = String.valueOf(sortedYaoci.get(i));


            for (int j = 3; j < yaoci.length(); j++) {
                String yaoZi = yaoci.substring(j, j + 1);
                newList.add(yaoZi);

            }

        }


        return newList;


    }


    //    #pragma mark 大运爻辞
    public String getDaYunYaoCiWithGuaNumber(List yaociList, int month) {

        int index = getIndexWithMonth(month);

        String yaoci = (String) yaociList.get(index - 1);


        return yaoci;


    }

//    大运周期

    public int[] getDaYunZhouQi(String yaoci) {

        int number1 = 60;
        int number2 = getYaoCiLength(yaoci);
        //    年
        int nian = number1 / number2;
        //    （60-8*7）*12=48
        int shengYuNian = (number1 - nian * number2) * 12;
        //  月
        int yue = shengYuNian / number2;
        //    48-6*7=6
        int shengYuYue = shengYuNian - yue * number2;
        //    日
        int ri = shengYuYue * 30 / number2;
        //   剩余日

        int shengYuRi = shengYuYue * 30 - ri * number2;

        int[] array = {nian, yue, ri, shengYuRi};

        return array;


    }


    public String getFullDaYunZhouQi(String yaoci) {

        int[] array = getDaYunZhouQi(yaoci);


        return String.format("%d年%d月%d日%d日剩余", array[0], array[1], array[2], array[3]);


    }


    private int getYaoCiLength(String yaoCi) {

        for (int i = 0; i < yaoCi.length(); i++) {
            String subYaoci = yaoCi.substring(i, i + 1);
            if (subYaoci.equals("：")) {
                Log.v("index", String.valueOf(i));
                return yaoCi.length() - i - 1;
            }
        }


        return 0;
    }


    //    大运爻字
    public List getDaYunYaoZi(String yaoCi, int month, int ri) {

        int length = getYaoCiLength(yaoCi);

        int index = getRenShenQishiDian(month, ri, length);

        index--;

        if (length == 16 || length == 6) {
            index--;
        }

        Log.v("index99", String.valueOf(index));

        String chunYaoZi = getChunYaozi(yaoCi);

        List pre = new ArrayList();
        List next = new ArrayList();

        for (int i = 0; i < chunYaoZi.length(); i++) {

            String str = chunYaoZi.substring(i, i + 1);

            if (!str.equals(" ")) {

                if (i < index) {
                    next.add(str);
                } else {
                    pre.add(str);
                }

            }


        }


        List lastList = new ArrayList();

        handleArray(lastList, pre);
        handleArray(lastList, next);


        Log.v("index", String.valueOf(lastList));


        return lastList;


    }


    private void handleArray(List list1, List list2) {


        for (int i = 0; i < list2.size(); i++) {

            String sub = (String) list2.get(i);

            list1.add(sub);


        }


    }


    private String getChunYaozi(String yaoci) {

        List newList = new ArrayList();

        for (int j = 3; j < yaoci.length(); j++) {
            String yaoZi = yaoci.substring(j, j + 1);
            newList.add(yaoZi);

        }

        String content = "";

        for (int i = 0; i < newList.size(); i++) {

            content += (String) newList.get(i);
        }

        return content;

    }


    private int getRenShenQishiDian(int yue, int ri, int hanZiShu) {
        if (yue % 2 == 0) {
            int num = 0;

            int newRi = 30 + ri;

            num = newRi * hanZiShu / 60;

            if (newRi * hanZiShu < 60) {
                return 1;
            } else {

                if (canChujinWithChuShu(newRi * hanZiShu, 60)) {
                    Log.v("chujin", "yes");
                    return num;
                } else {
                    Log.v("buchujin", "yes");

                    return num + 1;
                }
            }

        } else {
            int num = 0;

            int newRi = ri;

            num = newRi * hanZiShu / 60;

            //      小于60
            if (newRi * hanZiShu < 60) {
                return 1;
            } else {

                if (canChujinWithChuShu(newRi * hanZiShu, 60)) {
                    Log.v("chujin1", "yes");

                    return num;
                } else {
                    Log.v("buchujin1", "yes");

                    return num + 1;
                }
            }
        }

//        return 0;


    }


    private boolean canChujinWithChuShu(int chuShu, int beiChuShu) {
        if (beiChuShu == 0) {
            return false;
        } else {

            float beichuNUmber = beiChuShu;
            float tempNum = chuShu / beichuNUmber;


            String result = String.format("%.4f", tempNum);

            float newReult = Float.parseFloat(result);

            float finalReult = newReult * beiChuShu;


            Log.v("dd1", result);
            Log.v("dd2", String.valueOf(finalReult));

            if (finalReult == chuShu) {

                return true;
            }
        }

        return false;


    }

}
