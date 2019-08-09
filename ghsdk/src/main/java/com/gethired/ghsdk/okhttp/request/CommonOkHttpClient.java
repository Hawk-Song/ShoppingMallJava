package com.gethired.ghsdk.okhttp.request;

import com.gethired.ghsdk.okhttp.https.HttpsUtils;

import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.OkHttpClient;

/**
 * @function send request, configure params, support https
 */
public class CommonOkHttpClient {

    private static final int TIME_OUT = 30; // time out
    private static OkHttpClient mOkhttpClient;

    // configure params for client
    static {

        // create builder for client
        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();

        //set up timeout
        okHttpBuilder.connectTimeout(TIME_OUT, TimeUnit.SECONDS);
        okHttpBuilder.readTimeout(TIME_OUT, TimeUnit.SECONDS);
        okHttpBuilder.writeTimeout(TIME_OUT, TimeUnit.SECONDS);

        okHttpBuilder.followRedirects(true);

        //https support
        okHttpBuilder.hostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        });
        okHttpBuilder.sslSocketFactory(HttpsUtils.initSSLSocketFactory(), HttpsUtils.initTrustManager());
    }
}
