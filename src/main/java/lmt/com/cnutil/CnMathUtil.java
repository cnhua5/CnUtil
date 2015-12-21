package lmt.com.cnutil;

/**
 * Created by wuchunhua on 2015/12/19.
 */
public class CnMathUtil {

    public static int getMid(int targetNum, int array[]) {
        int left = 0, right = 0;
        int midIndex = 0;
        for (right = array.length - 1; left != right; ) {
            midIndex = (right + left) / 2;
            int mid = (right - left);
            int midValue = array[midIndex];
            if (targetNum == midValue) {
                return midIndex;
            }

            if (targetNum > midValue) {
                left = midIndex;
            } else {
                right = midIndex;
            }

            if (mid <= 2) {
                break;
            }
        }
        return midIndex;
    }

    public static String byte2hex(byte[] b) {
        StringBuffer hs = new StringBuffer(b.length);
        String stmp = "";
        int len = b.length;
        for (int n = 0; n < len; n++) {
            stmp = Integer.toHexString(b[n] & 0xFF);
            if (stmp.length() == 1)
                hs = hs.append("0").append(stmp);
            else {
                hs = hs.append(stmp);
            }
        }
        return String.valueOf(hs);
    }
}
