package com.mvvm.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import java.util.ArrayList;

/**
 * SharedPreferences 工具类
 */
public class SPUtils {
	private final String NAME = "MVVMDEMO";
	private SharedPreferences sharedPreferences;
	public static SPUtils SPUtils;

	public SPUtils(Context context) {
		// TODO Auto-generated constructor stub
		sharedPreferences = context.getSharedPreferences(NAME, 0);
	}

	public static SPUtils getInstance(Context context){
		if(SPUtils == null){
			SPUtils = new SPUtils(context);
		}
		return SPUtils;
	}
	/**
	 * 
	 * @Method: getBooleanValues
	 * @Description: 取Boolean值
	 * @param @param key 对应key值
	 * @param defaultValue
	 *            默认值
	 * @return boolean
	 * @throws
	 */
	public boolean getBooleanValues(String key, boolean defaultValue) {
		return sharedPreferences.getBoolean(key, defaultValue);
	}

	/**
	 * 
	 * @Method: putBooleanValues
	 * @Description: 写入Boolean值
	 * @param @param key 写入key值
	 * @param @param value 写入value值
	 * @return void
	 * @throws
	 */
	public void putBooleanValues(String key, boolean value) {
		Editor editor = sharedPreferences.edit();
		editor.putBoolean(key, value);
		editor.commit();
	}

	/**
	 * 
	 * @Method: getStringValues
	 * @Description: 取String 类型值
	 * @param @param key 对应key值
	 * @return String
	 * @throws
	 */
	public String getStringValues(String key) {
		return sharedPreferences.getString(key, "");
	}
	
	public String getStringValues(String key,String defValue) {
		return sharedPreferences.getString(key, defValue);
	}


	/**
	 * 
	 * @Method: putStringValues
	 * @Description: 写入String类型值
	 * @param @param key 写入key值
	 * @param @param value 写入value值
	 * @return void
	 * @throws
	 */
	public void putStringValues(String key, String value) {
		Editor editor = sharedPreferences.edit();
		editor.putString(key, value);
		editor.commit();
	}
	/**
	 * 
	 * @Method: getLongValues
	 * @Description: 取long 类型值
	 * @param @param key 对应key值
	 * @return String
	 * @throws
	 */
	public long getLongValues(String key) {
		return sharedPreferences.getLong(key, 0);
	}
	
	/**
	 * 
	 * @Method: putLongValues
	 * @Description: 写入long类型值
	 * @param @param key 写入key值
	 * @param @param value 写入value值
	 * @return void
	 * @throws
	 */
	public void putLongValues(String key, long value) {
		Editor editor = sharedPreferences.edit();
		editor.putLong(key, value);
		editor.commit();
	}
	

	/**
	 * 
	 * @Method: putArrayListValues 
	 * @Description: ArrayList 转字符串保存
	 * @param @param key
	 * @param @param values
	 * @return void
	 * @throws
	 */
	public void putArrayListValues(String key,ArrayList<Integer> values){
		String value = "";
		for (int i = 0; i < values.size(); i++) {
			value += values.get(i)+",";
		}
		if(!"".equals(value)&&value.indexOf(",")>0){
			value = value.substring(0, value.lastIndexOf(","));
		}
		Editor editor = sharedPreferences.edit();
		editor.putString(key, value);
		editor.commit();
	}
	
	/**
	 * 
	 * @Method: getArrayListValues 
	 * @Description: 取保存的ArrayList值
	 * @param @param key
	 * @param @return
	 * @return ArrayList<Object>
	 * @throws
	 */
	public ArrayList<Integer> getArrayListValues(String key){
		ArrayList<Integer> values = new ArrayList<Integer>();
		String valueStr = sharedPreferences.getString(key, "");
		if(!"".equals(valueStr)){
			if(valueStr.indexOf(",")>0){
				String[] value = valueStr.split(",");
				for (int i = 0; i < value.length; i++) {
					values.add(Integer.parseInt(value[i]));
				}
			}else{
				values.add(Integer.parseInt(valueStr));
			}
			
		}
		return values;
	}
}
