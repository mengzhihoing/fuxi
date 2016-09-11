package ninecity.myfragments.Class;

import android.util.Log;

/**
 * Created by mengzhihong on 2016/9/1.
 */
public class GuaName {

    private int handleNameNumber(int number){
        if (number>8){

            if(number%8==0){

                return 8;
            }

            return number%8;
        }

        return number;
    }

    public int getGua(int xingCount,int nameCount){

        int pre=handleNameNumber(xingCount);
        int next=handleNameNumber(nameCount);

        return pre*10+next;

    }

    public String getFullFailure(int guaNumber){


        String guaText="";

        int gua[]=getFailure(guaNumber);

        if (gua[1]>0){
            guaText =String.format("%d%s和%d%s",gua[0],getBenMingGua(gua[0]),gua[1],getBenMingGua(gua[1]));
        }else {
            guaText = String.format("%d%s", gua[0], getBenMingGua(gua[0]));
        }

        return guaText;
    }

    public String getFullBenMing(int guaNumber){

      String text= String.format("%d%s",guaNumber, getBenMingGua(guaNumber));

        return text;
    }

    public String getFullShuaiBian(int guaNumber ){

        int gua[]= getShuaiBian(guaNumber);
        Log.i("success",gua.toString());
        String guaText="";

        if (gua[1]>0){
            guaText =String.format("%d%s和%d%s",gua[0],getBenMingGua(gua[0]),gua[1],getBenMingGua(gua[1]));
        }else {
            guaText = String.format("%d%s", gua[0], getBenMingGua(gua[0]));
        }

        return guaText;

    }

    public String getFullSuccess(int guaNumber ){

      int gua[]= getSuccess(guaNumber);
        Log.i("success",gua.toString());
        String guaText="";

        if (gua[1]>0){
            guaText =String.format("%d%s和%d%s",gua[0],getBenMingGua(gua[0]),gua[1],getBenMingGua(gua[1]));
        }else {
            guaText = String.format("%d%s", gua[0], getBenMingGua(gua[0]));
        }

        return guaText;

    }

    public int[] getShuaiBian(int number){
        int gua[]={-1,-1};

        int preNumber=number/10;
        int nextNumber=number%10;

        switch (number){

            case 11:
            case 22:
            case 33:
            case 44:
            case 55:
            case 66:
            case 77:
            case 88:
            {
                int result1=handleNumber(9-preNumber)*10+handleNumber(9-preNumber+1);
                int result2=handleNumber(9-preNumber+1)*10+handleNumber(9-preNumber);

                gua[0]=result1;
                gua[1]=result2;

//                String gua1=getBenMingGua(result1);
//                String gua2=getBenMingGua(result2);
//
//                gua=String.format(String.valueOf(result1)+gua1+"和"+String.valueOf(result2)+gua2);

            }

            break;

            case 18:
            case 27:
            case 36:
            case 45:
            case 54:
            case 63:
            case 72:
            case 81:
            {
                int result1=nextNumber*10+handleNumber((preNumber-1));
                int result2=handleNumber((nextNumber+1))*10+preNumber;

//                String gua1=getBenMingGua(result1);
//                String gua2=getBenMingGua(result2);
//
//                gua=String.format(String.valueOf(result1)+gua1+"和"+String.valueOf(result2)+gua2);

                gua[0]=result1;
                gua[1]=result2;

            }

            break;

            default:
            {
                int result =( 9-nextNumber)*10+(9-preNumber);

//                gua=String.valueOf(result) + getBenMingGua(result);

                gua[0]=result;

            }

            break;





        }



        return gua;
    }

    public int[] getFailure(int number){

        int gua[]={-1,-1};

        int preNumber=number/10;
        int nextNumber=number%10;

//        String gua="";

        int result=(9-preNumber)*10+(9-nextNumber);

//        gua=String.valueOf(result)+getBenMingGua(result);

        gua[0]=result;
        return gua;

    }


    public int[] getSuccess(int number){
        int gua[]={-1,-1};

        int preNumber=number/10;
        int nextNumber=number%10;

        switch (number){

            case 11:
            case 22:
            case 33:
            case 44:
            case 55:
            case 66:
            case 77:
            case 88:
            {
                int result1=preNumber*10+handleNumber((nextNumber+1));
                int result2=handleNumber((preNumber+1))*10+nextNumber;

                gua[0]=result1;
                gua[1]=result2;

//                String gua1=getBenMingGua(result1);
//                String gua2=getBenMingGua(result2);


//                gua=String.format(String.valueOf(result1)+gua1+"和"+String.valueOf(result2)+gua2);

            }

            break;

            case 18:
            case 27:
            case 36:
            case 45:
            case 54:
            case 63:
            case 72:
            case 81:
            {
                int result1=preNumber*10+handleNumber((nextNumber-1));
                int result2=handleNumber((preNumber+1))*10+nextNumber;

                gua[0]=result1;
                gua[1]=result2;

//                String gua1=getBenMingGua(result1);
//                String gua2=getBenMingGua(result2);
//
//                gua=String.format(String.valueOf(result1)+gua1+"和"+String.valueOf(result2)+gua2);

            }

            break;

            default:
            {
              int result = nextNumber*10+preNumber;

//                gua=String.valueOf(result) + getBenMingGua(result);

                gua[0]=result;

            }

            break;





        }



        return gua;
    }


    private int handleNumber(int number){

        if (number<1||(number%8==0)){
            return 8;
        }else if(number>8){
            return 1;
        }

        return number;
    }



    public String getBenMingGua(int number){
        String name="";

        switch (number){

            case 11:
            {
                name="乾";
            }
            break;

            case 12 :
            {
                name="夬";

            }
            break;
            case 13 :
            {
                name="大有";

            }
            break;
            case 14 :
            {
                name="大壮";

            }
            break;
            case 15 :
            {
                name="小畜";

            }
            break;
            case 16 :
            {
                name="需";

            }
            break;
            case 17 :
            {
                name="大畜";

            }
            break;
            case 18 :
            {
                name="泰";

            }
            break;
            case 21 :
            {
                name="履";

            }
            break;
            case 22 :
            {
                name="兑";

            }
            break;
            case 23 :
            {
                name="睽";

            }
            break;
            case 24 :
            {
                name="归妹";

            }
            break;
            case 25 :
            {
                name="中孚";

            }
            break;
            case 26:
            {
                name="节";

            }
            break;
            case 27 :
            {
                name="损";

            }
            break;
            case 28 :
            {
                name="临";

            }
            break;
            case 31 :
            {
                name="同人";

            }
            break;
            case 32:
            {
                name="革";

            }
            break;
            case 33:
            {
                name="离";

            }
            break;
            case 34:
            {
                name="丰";

            }
            break;
            case 35:
            {
                name="家人";

            }
            break;
            case 36 :
            {
                name="既济";
            }
            break;
            case 37 :
            {
                name="贲";
            }
            break;
            case 38 :
            {
                name="名夷";
            }
            break;
            case 41 :
            {
                name="无妄";
            }
            break;
            case 42 :
            {
                name="随";
            }
            break;
            case 43 :
            {
                name="噬嗑";
            }
            break;
            case 44 :
            {
                name="震";
            }
            break;
            case 45 :
            {
                name="益";
            }
            break;
            case 46 :
            {
                name="屯";
            }
            break;
            case 47 :
            {
                name="颐";
            }
            break;
            case 48 :
            {
                name="复";
            }
            break;

            case 51 :
            {
                name="姤";
            }
            break;
            case  52:
            {
                name="大过";
            }
            break;
            case  53:
            {
                name="鼎";
            }
            break;
            case 54 :
            {
                name="恒";
            }
            break;
            case 55 :
            {
                name="巽";
            }
            break;
            case  56:
            {
                name="井";
            }
            break;
            case  57:
            {
                name="蛊";
            }
            break;
            case  58:
            {
                name="升";
            }
            break;

            case  61:
            {
                name="讼";
            }
            break;
            case  62:
            {
                name="困";
            }
            break;
            case  63:
            {
                name="未济";
            }
            break;
            case  64:
            {
                name="解";
            }
            break;
            case 65 :
            {
                name="涣";
            }
            break;
            case 66 :
            {
                name="坎";
            }
            break;
            case  67:
            {
                name="蒙";
            }
            break;
            case 68 :
            {
                name="师";
            }
            break;
            case  71:
            {
                name="遁";
            }
            break;
            case 72 :
            {
                name="咸";
            }
            break;
            case 73 :
            {
                name="旅";
            }
            break;
            case  74:
            {
                name="小过";
            }
            break;
            case 75 :
            {
                name="渐";
            }
            break;
            case  76:
            {
                name="蹇";
            }
            break;
            case 77 :
            {
                name="艮";
            }
            break;
            case  78:
            {
                name="谦";
            }
            break;
            case 81 :
            {
                name="否";
            }
            break;
            case  82:
            {
                name="萃";
            }
            break;
            case  83:
            {
                name="晋";
            }
            break;
            case 84 :
            {
                name="豫";
            }
            break;
            case 85 :
            {
                name="观";
            }
            break;
            case 86 :
            {
                name="比";
            }
            break;
            case 87 :
            {
                name="剥";
            }
            break;
            case 88 :
            {
                name="坤";
            }
            break;


            default:
            {
                name="";

            }
            break;

        }



        return name;

    }

}
