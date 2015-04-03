package com.example.hmw.lambdatest;

import android.util.Log;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.androidannotations.annotations.EBean;

import java.io.IOException;

/**
 * Created by Bill Minwook Heo on 15. 4. 3..
 */

@EBean
public class MvpModel {

    public String networking() {

        Log.i("INFO", "networking");

        OkHttpClient client = new OkHttpClient();

        String text = null;

        try {
            Request request = new Request.Builder()
                    .url("https://raw.github.com/square/okhttp/master/README.md")
                    .build();

            Response response = client.newCall(request).execute();
            text = response.body().string();

            Log.i("INFO text", "network text");

        } catch (IOException e) {
            Log.e("ERROR", e.getMessage());
        }

        return text;
    }
}
