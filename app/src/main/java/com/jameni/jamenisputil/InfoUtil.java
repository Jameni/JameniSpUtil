package com.jameni.jamenisputil;

import android.content.Context;

import com.jameni.jamenisplib.secrect.JameniSpUtil;

public class InfoUtil extends JameniSpUtil {
    public InfoUtil(Context context) {
        super(context, "test",JameniSpUtil.SECRECT_TYPE_BASE64);
    }


    public void setName(String name) {
        add("name", name);
    }

    public String getName() {
        return get("name");
    }

}
