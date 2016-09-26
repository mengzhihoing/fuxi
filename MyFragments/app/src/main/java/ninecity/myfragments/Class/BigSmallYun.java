package ninecity.myfragments.Class;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by meng on 16/9/26.
 */
public class BigSmallYun {

    private List getSmallYunZhouqiArray(String yaoCi) {

        int number1 = 10;
        int number2 = 0;

        for (int i = 0; i < yaoCi.length(); i++) {
            String subYaoci = yaoCi.substring(i, i + 1);
            if (subYaoci.equals("：")) {
                Log.v("index", String.valueOf(i));
                number2 = yaoCi.length() - i - 1;
            }
        }

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


        List arrayList = new ArrayList();
//        arrayList.add(String.valueOf(nian));
//        arrayList.add(String.valueOf(yue));
//        arrayList.add(String.valueOf(ri));
//        arrayList.add(String.valueOf(shengYuRi));
        arrayList.add(nian);
        arrayList.add(yue);
        arrayList.add(ri);
        arrayList.add(shengYuRi);


//        Log.v("index", String.valueOf(arrayList));


        return arrayList;

    }


//    获取整个

    private List getAllSmallYunZhouqiArray(List list) {

        List arrayList = new ArrayList();

        for (int i = 0; i < list.size(); i++) {
            String yaoci = list.get(i).toString();

            List tmpList = getSmallYunZhouqiArray(yaoci);

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

        List newList=new ArrayList();

        for (int i=index;i<list.size();i++){
            newList.add(list.get(i));
        }


        for (int i=0;i<index;i++){
            newList.add(list.get(i));
        }


        return newList;


    }


    public List getSortedAllXiaoYunZhouQi(List list,int month){

        List cycle=getAllSmallYunZhouqiArray(list);

        return sortedArrayWithArray(cycle,month);

    }


    public List getSortedYaoCi(List list,int month){


        return sortedArrayWithArray(list,month);

    }


    public String getFullXiaoYunYaoCiAndZhouQi(List yaociList,int month){
//        排序后的爻辞
        List sortedYaoci=getSortedYaoCi(yaociList,month);

       String content="排序后的爻辞:\n";

        content+=hanldList(sortedYaoci);



        //获取小运周期

        List list= getSortedAllXiaoYunZhouQi(yaociList,month);

        content+="\n\n对应周期:\n";


        String[] liveArray={"出生-10岁: ","11岁-20岁: ","21岁-30岁: ","31岁-40岁: ","41岁-50岁: ","51岁-60岁: "};



        for(int i=0;i<list.size();i++) {

            content+=liveArray[i];

            List tempList = (List) list.get(i);
            content += handleZhouQi(tempList);
            content+="\n";

        }


        content+="\n\n";



        return content;


    }


    private String handleZhouQi(List list){


        return String.format("%s年%s月%s日%s日剩余",list.get(0),list.get(1),list.get(2),list.get(3));

    }


    private String hanldList(List list){


        String content="";

        for (int i=0;i<list.size();i++){
            content+=list.get(i).toString();
            content+="\n";
        }

        return content;

    }


    public List getXiaoYunYaoZi(List yaociList,int month){

        //        排序后的爻辞
        List sortedYaoci=getSortedYaoCi(yaociList,month);

        List newList=new ArrayList();

        for (int i=0;i<sortedYaoci.size();i++){

            String yaoci=String.valueOf(sortedYaoci.get(i));


            for (int j=3;j<yaoci.length();j++){
                String yaoZi=yaoci.substring(j,j+1);
                newList.add(yaoZi);

            }

        }


        return newList;


    }


}
