package com.example.hmw.com.example.hmw.newSupportLibrary;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.hmw.lambdatest.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

/**
 * Created by Bill Minwook Heo on 15. 4. 23..
 */
@EActivity(R.layout.activity_support_libarary)
public class SupportTestActivity extends AppCompatActivity {


    @AfterViews
    public void initView() {
        setupActionbar();
    }


    private void setupActionbar() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.layout_toolbar);

        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("test");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayUseLogoEnabled(false);
        actionBar.setIcon(
                new ColorDrawable(getResources().getColor(android.R.color.transparent)));
    }

}
