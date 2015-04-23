package com.example.hmw.com.example.hmw.newSupportLibrary;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.hmw.lambdatest.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

/**
 * Created by Bill Minwook Heo on 15. 4. 23..
 */
@EActivity(R.layout.activity_support_library)
public class SupportTestActivity extends AppCompatActivity {

    Spinner spinner;
    Button btnAlertDialog;

    @AfterViews
    public void initView() {
        setupActionbar();

        spinner = (Spinner) findViewById(R.id.spinner);
        btnAlertDialog = (Button) findViewById(R.id.btnAlertDialog);

        ArrayAdapter<String> adtVersions =
                new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,
                        new String[]{"Honeycomb", "IceCreamSandwich", "Jellybean", "KitKat", "Lollypop"});
        adtVersions.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adtVersions);

        btnAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(SupportTestActivity.this)
                        .setTitle("Alert dialog")
                        .setMessage("Message")
                        .setPositiveButton(android.R.string.ok, null)
                        .setNegativeButton(android.R.string.cancel, null)
                        .show();
            }
        });
    }

    @Click(R.id.goToTwo)
    void goToTwo() {
        Intent intent = new Intent(this, SupportTestTwoActivity_.class);
        startActivity(intent);

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
