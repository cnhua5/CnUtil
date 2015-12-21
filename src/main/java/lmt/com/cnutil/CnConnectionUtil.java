package lmt.com.cnutil;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by wuchunhua on 2015/12/21.
 */
public class CnConnectionUtil {

    public static boolean isWifiConnected(Context ctx) {
        if (ctx == null) {
            return false;
        }
        NetworkInfo localNetworkInfo = ((ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        if ((localNetworkInfo != null) && (localNetworkInfo.getType() == ConnectivityManager.TYPE_WIFI)) {
            return true;
        } else {
            return false;
        }
    }
}
