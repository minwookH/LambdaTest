package com.example.hmw.com.example.hmw.newSupportLibrary;

import android.app.AlertDialog;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.hmw.lambdatest.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

/**
 * Created by Bill Minwook Heo on 15. 4. 23..
 */

@EActivity(R.layout.activity_support_library_two)
public class SupportTestTwoActivity extends AppCompatActivity {

    Button btnAlertDialog;

    @AfterViews
    public void initView() {
        setupActionbar();

        btnAlertDialog = (Button) findViewById(R.id.alertButton);

        btnAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(SupportTestTwoActivity.this)
                        .setTitle("Alert dialog")
                        .setMessage("Message")
                        .setPositiveButton(android.R.string.ok, null)
                        .setNegativeButton(android.R.string.cancel, null)
                        .show();
            }
        });
    }

    private void setupActionbar() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.layout_toolbar);

        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("test two");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayUseLogoEnabled(false);
        actionBar.setIcon(
                new ColorDrawable(getResources().getColor(android.R.color.transparent)));
    }

}
