package lmt.com.cnutil;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;

import java.io.ByteArrayInputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

/**
 * Created by wuchunhua on 2015/12/21.
 */
public class CnPackageUtil {

    public static void getPackageSigner(Context ctx) {
        PackageManager manager = ctx.getPackageManager();
        PackageInfo packageInfo = null;
        try {
            packageInfo = manager.getPackageInfo(ctx.getPackageName(), PackageManager.GET_SIGNATURES);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (packageInfo != null) {
            Signature[] signatures = packageInfo.signatures;

            Signature signer = signatures[0];
            parseSigner(signer.toByteArray());

            StringBuilder builder = new StringBuilder();
            for (Signature signature : signatures) {
                builder.append(signature.toCharsString());
            }
            /************** 得到应用签名 **************/
            String signature = builder.toString();
        }
    }

    private static void parseSigner(byte[] signature) {
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            X509Certificate certificate = (X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(signature));
            String publicKey = certificate.getPublicKey().toString();
            String signerNumber = certificate.getSerialNumber().toString();
            byte[] encoded = certificate.getEncoded();
        } catch (CertificateException e) {
            e.printStackTrace();
        }
    }
}
