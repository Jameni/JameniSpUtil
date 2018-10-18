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

    boolean isGood;

    public void test(View v) {
        index++;

//        infoUtil.setAge(index);

//        if (isGood) {
//            isGood = false;
//        } else {
//            isGood = true;
//        }
//        infoUtil.setGood(isGood);

//        float a = 0.5f +index;
//        infoUtil.setPrice(a);


        long  b =  10+index;
        infoUtil.setYear(b);
    }


    public void test2(View v) {
        tip(""+infoUtil.getYear());
    }

    public void tip(String tip) {
        Toast.makeText(this, tip, Toast.LENGTH_SHORT).show();
    }
}
