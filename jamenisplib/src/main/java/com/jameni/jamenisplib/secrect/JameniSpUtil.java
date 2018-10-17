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
    protected String get(String key) {
        return get(key, "");
    }

    protected String get(String key, String def) {
        return decode(shared.getString(encode(key), def));

    }

    //获取布尔型
    protected boolean getBool(String key, boolean def) {
        return shared.getBoolean(encode(key), def);

    }

    //获取整形
    protected int getInt(String key) {
        return getInt(key, 0);
    }

    protected int getInt(String key, int def) {
        return shared.getInt(encode(key), def);
    }

    //    获取长整型
    protected long getLong(String key) {
        return getLong(key, 0);
    }

    protected long getLong(String key, int def) {
        return shared.getLong(encode(key), def);
    }

    //获取浮点型
    protected float getFloat(String key) {
        return getFloat(key, 0);
    }

    protected float getFloat(String key, int def) {
        return shared.getFloat(encode(key), def);
    }


    // ============   保存数据   ===================

    protected void add(String key, String value) {
        editor.putString(encode(key), encode(value));
        editor.commit();
    }

    protected void add(String key, int value) {
        editor.putInt(encode(key), value);
        editor.commit();
    }

    protected void add(String key, float value) {
        editor.putFloat(encode(key), value);
        editor.commit();
    }

    protected void add(String key, boolean value) {
        editor.putBoolean(encode(key), value);
        editor.commit();
    }

    protected void add(String key, long value) {
        editor.putLong(encode(key), value);
        editor.commit();
    }
}
