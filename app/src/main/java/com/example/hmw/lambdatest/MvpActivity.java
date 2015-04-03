package com.example.hmw.lambdatest;

import android.app.Activity;
import android.util.Log;
import android.widget.TextView;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Bill Minwook Heo on 15. 4. 3..
 */
@EActivity(R.layout.activity_mvp)
public class MvpActivity extends Activity implements MvpView {

    @ViewById(R.id.textViewMvp)
    TextView display;

    @Bean(MvpPresenterImpl.class)
    MvpPresenter presenter;

    @Click(R.id.buttonMvp)
    @Background
    void buttonClick() {
        Log.i("INFO", "MvpActivity click");
        presenter.networking();
    }

    @Override
    public void displayText(String text) {
        Log.i("INFO", "MvpActivity displayText");
        display.setText(text);
    }
}
