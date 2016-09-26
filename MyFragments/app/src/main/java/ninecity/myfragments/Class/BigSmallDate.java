package ninecity.myfragments.Class;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by meng on 16/9/26.
 */
public class BigSmallDate {


    public List getSmallYunDate(int[] date, List zhouQiList, List yaoCiList) {


        int[] newDate = date;


        List mList = new ArrayList();

        for (int i = 0; i < zhouQiList.size(); i++) {

            int[] subZhouqi = (int[]) zhouQiList.get(i);

            int count = getYaoCiLength(String.valueOf(yaoCiList.get(i)));
//          装的是list,有日期数组,新日期数组
            List list = getXiaoYunWithBirthDayDate(newDate, subZhouqi, count);






            List temtList = (List) list.get(list.size() - 1);

            newDate = getLastDate(temtList);


            for (int j=0;j<list.size();j++){

                List dateList=(List) list.get(j);

                int[] pre=(int[]) dateList.get(0);
                int[] next=(int[]) dateList.get(1);

                String content=String.format("%d年%d月%d日-%d年%d月%d日",pre[0],pre[1],pre[2],next[0],next[1],next[2]);

                mList.add(content);



            }




        }


        return mList;


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


    private List getXiaoYunWithBirthDayDate(int[] date, int[] zhouQiList, int count) {


        int nian = date[0];
        int yue = date[1];
        int ri = date[2];


        int cycleNian = zhouQiList[0];
        int cycleYue =  zhouQiList[1];
        int cycleRi =  zhouQiList[2];
        int cycleYuRi =  zhouQiList[3];
        int firstYear = nian;

        List mList = new ArrayList();

        for (int i = 0; i < count; i++) {


//            String dateStr = String.format("%d年%.2d月%.2d日", nian, yue, ri);

            int[] dateArray = {nian, yue, ri};


            //      calculate day
            ri += cycleRi;

            int[] riList = handleDate(ri, yue, nian, cycleYue);
            ri = riList[0];
            yue = riList[1];

            //      calculate month
            yue += cycleYue;
            int[] yueList = handleYueAndNian(yue, nian);
            yue = yueList[0];
            nian = yueList[1];


            //      calculate year
            nian += cycleNian;

            if (cycleYuRi > 0 && nian == firstYear + 5) {
                int preDay = cycleYuRi / 2;
                ri += preDay;

                int[] riArray = handleDate(ri, yue, nian, cycleYue);
                ri = riArray[0];
                yue = riArray[1];

            } else if (cycleYuRi > 0 && nian == firstYear + 10) {
                int preDay = cycleYuRi / 2;
                int lastDay = cycleYuRi - preDay;
                ri += lastDay;

                int[] riArray = handleDate(ri, yue, nian, cycleYue);
                ri = riArray[0];
                yue = riArray[1];
            }

//            String newDateStr =
//
//
//            String result = String.format("%s-%s", dateStr, newDateStr);

            int[] newDateArray = handleLastDateWithNian(nian, yue, ri);


            String content=String.format("%d年%d月%d日-%d年%d月%d日",dateArray[0],dateArray[1],dateArray[2],newDateArray[0],newDateArray[1],newDateArray[2]);

            Log.v("hh",content);

            List tempList = new ArrayList();
            tempList.add(dateArray);
            tempList.add(newDateArray);


            mList.add(tempList);

        }


        return mList;


    }


    private int[] handleDate(int ri, int yue, int nian, int cycleYue) {


        switch (cycleYue + yue) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12: {
                if (ri > 31) {
                    ri -= 31;
                    yue++;
                }
            }
            break;
            case 2: {

                if (isRunNian(nian)) {
                    if (ri > 29) {
                        ri -= 29;
                        yue++;
                    }
                } else {

                    if (ri > 28) {
                        ri -= 28;
                        yue++;
                    }
                }
            }
            break;

            default: {
                if (ri > 30) {
                    ri -= 30;
                    yue++;
                }
            }
            break;
        }


        int[] array = {ri, yue};

        return array;


    }


    private boolean isRunNian(int year) {

        if (year % 100 == 0) {
            if (year % 400 == 0) {
                return true;
            }
        } else if (year % 4 == 0) {
            return true;
        }

        return false;


    }


    private int[] handleYueAndNian(int yue, int nian) {

        if (yue > 12) {
            yue -= 12;
            nian++;
        }

        int[] array = {yue, nian};

        return array;


    }


    private int[] handleLastDateWithNian(int nian, int yue, int ri) {

        switch (yue) {

            case 3: {
                if (ri == 1) {
                    yue--;
                    if (isRunNian(nian)) {
                        ri = 29;
                    } else {
                        ri = 28;
                    }
                } else {
                    ri--;
                }

            }
            break;

            case 2:
            case 4:
            case 6:
            case 9:
            case 11: {
                if (ri == 1) {
                    yue--;
                    ri = 31;
                } else {
                    ri--;
                }
            }
            break;

            default: {
                if (ri == 1) {
                    yue--;
                    ri = 30;
                } else {
                    ri--;
                }

            }
            break;
        }
//        return String.format("%d年%.2d月%.2d日", nian, yue, ri);


        int[] array = {nian, yue, ri};

        return array;

    }


    private int[] getLastDate(List date) {


        int[] array = (int[]) date.get(1);


        int[] newArray = {array[0], array[1], array[2] + 1};


        return newArray;

    }


}
