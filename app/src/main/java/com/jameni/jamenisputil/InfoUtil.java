package com.jameni.jamenisputil;

import android.content.Context;

import com.jameni.jamenisplib.secrect.JameniSpUtil;

public class InfoUtil extends JameniSpUtil {
    public InfoUtil(Context context) {
        super(context, "test", JameniSpUtil.SECRECT_TYPE_NONE);
    }


    public void setName(String name) {
        add("name", name);
    }

    public String getName() {
        return get("name");
    }


    public void setAge(int age) {
        add("age", age);
    }

    public int getAge() {
        return getInt("age", 20);
    }

    public void setGood(boolean is) {
        add("good", is);
    }

    public boolean getGood() {
        return getBool("good", true);
    }


    public void setYear(long is) {
        add("year", is);
    }

    public long getYear() {
        return getLong("year", 100);
    }


    public void setPrice(float is) {
        add("price", is);
    }

    public float getPrice() {
        return getFloat("price", 12.344f);
    }


}
