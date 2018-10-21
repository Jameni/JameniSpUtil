package com.jameni.jamenisplib.secrect;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.jameni.jamenisplib.util.Base64Util;

public class JameniSpUtil {
    private Context context; // 上下文
    private SharedPreferences shared; //
    private SharedPreferences.Editor editor;
    private int secrectType;//加密类型
    public static final int SECRECT_TYPE_NONE = 0;
    public static final int SECRECT_TYPE_BASE64 = 1;
    public static final int SECRECT_TYPE_AES = 2;


    public JameniSpUtil(Context context, String fileName) {
        this.context = context;
        this.secrectType = 0;//默认不加密
        initSharedPreference(fileName);// 初始化存储文件
    }


    public JameniSpUtil(Context context, String fileName, int secrectType) {
        this.context = context;
        this.secrectType = secrectType;
        initSharedPreference(fileName);// 初始化存储文件
    }


    // 初始化存储文件
    private void initSharedPreference(String fileName) {

        shared = context.getSharedPreferences(fileName == null || fileName.equals("") ? "tempSave" : fileName, Activity.MODE_PRIVATE);
        editor = shared.edit();
    }

    //加密
    public String encode(String str) {

        String result = "";

        switch (secrectType) {
            case SECRECT_TYPE_NONE:
                result = str;
                break;
            case SECRECT_TYPE_BASE64:
                result = Base64Util.encode(str);
                break;
            case SECRECT_TYPE_AES:
                //待处理
                result = str;
                break;
            default:
                result = str;
                break;
        }

        return result;
    }

    //解密
    public String decode(String str) {

        String result = "";

        switch (secrectType) {
            case SECRECT_TYPE_NONE:
                result = str;
                break;
            case SECRECT_TYPE_BASE64:
                result = Base64Util.decode(str);
                break;
            case SECRECT_TYPE_AES:
                //待处理
                result = str;
                break;
            default:
                result = str;
                break;
        }

        return result;
    }

    //    清空sp
    public void clear() {
        editor.clear();
        editor.commit();
    }

// ============   获取数据   ===================

    //    获取字符串
    public String get(String key) {
        return get(key, "");
    }

    public String get(String key, String def) {
        return decode(shared.getString(encode(key), def));
    }

    //获取布尔型
    public boolean getBool(String key, boolean def) {
        String value = get(key);
        if (value == null || value.equals("")) {
            return def;
        } else {
            return Boolean.valueOf(value);
        }
    }

    //获取整形
    public int getInt(String key) {
        return getInt(key, 0);
    }

    public int getInt(String key, int def) {
        String value = get(key);
        if (value == null || value.equals("")) {
            return def;
        } else {
            return Integer.valueOf(value);
        }
    }

    //    获取长整型
    public long getLong(String key) {
        return getLong(key, 0);
    }

    public long getLong(String key, long def) {
        String value = get(key);
        if (value == null || value.equals("")) {
            return def;
        } else {
            return Long.valueOf(value);
        }
    }

    //获取浮点型
    public float getFloat(String key) {
        return getFloat(key, 0f);
    }

    public float getFloat(String key, float def) {
        String value = get(key);
        if (value == null || value.equals("")) {
            return def;
        } else {
            return Float.valueOf(value);
        }
    }


// ============   保存数据   ===================

    public void add(String key, String value) {
        editor.putString(encode(key), encode(value));
        editor.commit();
    }

    public void add(String key, int value) {
        add(key, String.valueOf(value));
    }

    public void add(String key, float value) {
        add(key, String.valueOf(value));
    }

    public void add(String key, long value) {
        add(key, String.valueOf(value));
    }

    public void add(String key, boolean value) {
        add(key, String.valueOf(value));
    }
}
