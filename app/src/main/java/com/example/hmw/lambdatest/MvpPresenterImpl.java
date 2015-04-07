package com.example.hmw.lambdatest;

import android.util.Log;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

/**
 * Created by Bill Minwook Heo on 15. 4. 3..
 */

@EBean
public class MvpPresenterImpl implements MvpPresenter {

    @Bean
    MvpModel model;

    MvpView mvpView;

    @Override
    public void networking() {
        Log.i("INFO", "MvpPresenterImpl click");

        String text = model.networking();
        Log.i("INFO", "MvpPresenterImpl text : " + text.length());
        mvpView.displayText(text);

    }

    @Override
    public void setView(MvpView view) {
        this.mvpView = view;
    }


}
