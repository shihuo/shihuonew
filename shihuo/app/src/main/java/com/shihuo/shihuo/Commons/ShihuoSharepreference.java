package com.shihuo.shihuo.Commons;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by cm_qiujiaheng on 2016/11/26.
 */

public class ShihuoSharepreference {

    //存储的sharedpreferences文件名
    private static final String FILE_NAME = "shihuo_sharepreference";

    public static final String KEY_LOGINMODEL = "login_model";

    /**
     * 保存用户登录信息
     * {
     * "code": 0,
     * "data": {
     * "userInfo": {
     * "avatarPicUrl": "123.jpg",
     * "isValid": 1,
     * "lastLoginIp": "",
     * "lastLoginTime": null,
     * "phoneNum": "18510015257",
     * "regTime": "2016-11-26 00:36:31",
     * "userId": "7d848e2408354849aa8c80bf0ba6679a",
     * "userName": "qiujiaheng"
     * },
     * "token": "49047e5d48ca4830bd08f7b4bdc26626"
     * }
     * }
     *
     * @param context
     * @param loginModel
     */
    public static void saveLoginModel(Context context, String loginModel) {
        saveData(context, KEY_LOGINMODEL, loginModel);
    }

    /**
     * 保存数据到文件
     *
     * @param context
     * @param key
     * @param data
     */
    public static void saveData(Context context, String key, Object data) {

        String type = data.getClass().getSimpleName();
        SharedPreferences sharedPreferences = context
                .getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if ("Integer".equals(type)) {
            editor.putInt(key, (Integer) data);
        } else if ("Boolean".equals(type)) {
            editor.putBoolean(key, (Boolean) data);
        } else if ("String".equals(type)) {
            editor.putString(key, (String) data);
        } else if ("Float".equals(type)) {
            editor.putFloat(key, (Float) data);
        } else if ("Long".equals(type)) {
            editor.putLong(key, (Long) data);
        }

        editor.commit();
    }

    /**
     * 从文件中读取数据
     *
     * @param context
     * @param key
     * @param defValue
     * @return
     */
    public static Object getData(Context context, String key, Object defValue) {

        String type = defValue.getClass().getSimpleName();
        SharedPreferences sharedPreferences = context.getSharedPreferences
                (FILE_NAME, Context.MODE_PRIVATE);

        //defValue为为默认值，如果当前获取不到数据就返回它
        if ("Integer".equals(type)) {
            return sharedPreferences.getInt(key, (Integer) defValue);
        } else if ("Boolean".equals(type)) {
            return sharedPreferences.getBoolean(key, (Boolean) defValue);
        } else if ("String".equals(type)) {
            return sharedPreferences.getString(key, (String) defValue);
        } else if ("Float".equals(type)) {
            return sharedPreferences.getFloat(key, (Float) defValue);
        } else if ("Long".equals(type)) {
            return sharedPreferences.getLong(key, (Long) defValue);
        }

        return defValue;
    }

}
