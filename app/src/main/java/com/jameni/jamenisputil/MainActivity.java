package com.jameni.jamenisputil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    InfoUtil infoUtil;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        infoUtil = new InfoUtil(this);
    }

    public void test(View v) {
        index++;
        infoUtil.setName("name" + index);
    }

    public void test2(View v) {
        String a = infoUtil.getName();
        tip(a);
    }

    public void tip(String tip) {
        Toast.makeText(this, tip, Toast.LENGTH_SHORT).show();
    }
}
