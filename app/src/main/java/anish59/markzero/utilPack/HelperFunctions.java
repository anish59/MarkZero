package anish59.markzero.utilPack;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.compat.BuildConfig;
import android.util.Log;
import android.widget.Toast;


/**
 * Created by anish on 03-04-2017.
 */

public class HelperFunctions {
    private enum logType {d, e}

    public static void utilLog(logType type, String tag, String print) {
        if (BuildConfig.DEBUG) {
            switch (type) {
                case d:
                    Log.d(tag, print);
                    break;
                case e:
                    Log.e(tag, print);
                    break;
            }
        }
    }

    public static void simpleToast(Context ctx, String msg, boolean isDebug) {
        if (isDebug) {

            if (BuildConfig.DEBUG) {
                Toast.makeText(ctx, msg, Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(ctx, msg, Toast.LENGTH_SHORT).show();
        }
    }
    //todo: need to have a nice animated toast keep in mind to make it

    public static boolean isConnectedToInternet(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
