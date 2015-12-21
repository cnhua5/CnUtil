package lmt.com.cnutil;

import android.util.Log;

/**
 * Created by wuchunhua on 2015/12/21.
 */
public class CnLogUtil {

    public static void printLogError(String sb) {
        printLog(true, sb);
    }

    public static void printLogInfo(String sb) {
        printLog(false, sb);
    }

    private static void printLog(boolean error, String sb) {
        if (sb.length() > 4000) {
            int chunkCount = sb.length() / 4000; // integer division
            for (int i = 0; i <= chunkCount; i++) {
                int max = 4000 * (i + 1);
                if (max >= sb.length()) {
                    print(error, sb.substring(4000 * i));
                } else {
                    print(error, sb.substring(4000 * i, max));
                }
            }
        } else {
            print(error, sb.toString());
        }
    }

    private static void print(boolean error, String val) {
        if (isLoggble()) {
            if (error) {
                Log.e("mm", val);
            } else {
                Log.i("mm", val);
            }
        }
    }

    public static boolean isLoggble() {
        return true;
//		return Log.isLoggable("mm", Log.VERBOSE);
    }
}
