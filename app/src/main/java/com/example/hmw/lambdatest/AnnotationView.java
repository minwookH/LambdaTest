package com.example.hmw.lambdatest;

import android.util.Log;
import android.widget.TextView;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

/**
 * Created by hmw on 15. 4. 3..
 */
@EBean
public class AnnotationView {
    @ViewById(R.id.textView)
    TextView display;

    @UiThread
    void changeText(String text){
        Log.i("INFO", "ChangeText");
        display.setText(text);
    }


}
