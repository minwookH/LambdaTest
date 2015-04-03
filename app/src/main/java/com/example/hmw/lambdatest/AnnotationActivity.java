package com.example.hmw.lambdatest;

import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

/**
 * Created by hmw on 15. 4. 2..
 */

@EActivity(R.layout.activity_annotation)
public class AnnotationActivity extends ActionBarActivity {

    /*@ViewById(R.id.button)
    Button button;*/

    @Bean
    AnnotationModel annotationModel;

    @Bean
    AnnotationView annotationView;

    /*@ViewById(R.id.textView)
    TextView display;*/

    //private String text;

    @Click(R.id.button)
    @Background
    void clickButton(){
        Log.i("INFO","ClickButton");
        String result = annotationModel.background();

        annotationView.changeText(result);
    }

    /*@Background
    void background(){
        Log.i("INFO","Background");

        OkHttpClient client = new OkHttpClient();

        try{
            Request request = new Request.Builder()
                    .url("https://raw.github.com/square/okhttp/master/README.md")
                    .build();

            Response response = client.newCall(request).execute();
            //text = response.body().string();

            //Log.i("INFO",text);

            changeText(response.body().string());

        }catch (IOException e){
            Log.e("ERROR",e.getMessage());
        }

    }

    @UiThread
    void changeText(String text){
        Log.i("INFO","ChangeText");
        display.setText(text);
    }*/

}
