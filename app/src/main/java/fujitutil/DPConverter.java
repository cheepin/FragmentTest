package fujitutil;

import android.content.Context;
import android.util.DisplayMetrics;

public class DPConverter
{
    public static int convertPx2Dp(int px, Context context){
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return Math.round(px * metrics.density);
    }
}
