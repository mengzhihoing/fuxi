package ninecity.myfragments.Class;

import android.content.Context;

import ninecity.myfragments.R;

/**
 * Created by meng on 16/9/19.
 */
public class GuaColor {

    public int getGuaColor(int number ,Context mcontext){

        int color;

        switch (number){

            case 1:
            {
                color= (mcontext.getResources().getColor(R.color.gray));

            }
            break;

            case 2:
            {
                color= (mcontext.getResources().getColor(R.color.blue));

            }
            break;

            case 3:
            {
                color= (mcontext.getResources().getColor(R.color.red));

            }
            break;

            case 4:
            {
                color= (mcontext.getResources().getColor(R.color.black));

            }
            break;

            case 5:
            {
                color= (mcontext.getResources().getColor(R.color.purple));

            }
            break;

            case 6:
            {
                color= (mcontext.getResources().getColor(R.color.green));

            }
            break;

            case 7:
            {
                color= (mcontext.getResources().getColor(R.color.cyan));

            }
            break;

            case 8:
            {
                color= (mcontext.getResources().getColor(R.color.yellow));

            }
            break;


            default:
            {
                color=0;
            }
        }

        return color;

    }

}
