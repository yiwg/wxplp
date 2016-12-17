package com.yiwg.plp.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;


public class ConfigUtil {
	private static Logger log = LoggerFactory.getLogger(ConfigUtil.class);
	private static Properties properties = null;
	
	public final static String AGENT_APPKEY = "agent.appKey";
	public final static String AUS_WS_URL = "aus.ws.url";
	
	static {
		loadProperties();
	}

	private static void loadProperties() {
		InputStream istream = null;
		try {
			istream = ConfigUtil.class.getResourceAsStream("/config.properties");
			properties = new Properties();
			properties.load(istream);
		} catch (Exception e) {
			log.error("读取属性文件[config.properties]失败.", e);
			return;
		} finally {
			if (istream != null) {
				try {
					istream.close();
				} catch (Exception ignore) {
				}
			}
		}
	}

	public static void reloadProperties() {
		loadProperties();
	}

	private ConfigUtil() {
	}

	public static String getString(String key) {
		return properties.getProperty(key);
	}

	public static String getString(String key, String defaultValue) {
		return properties.getProperty(key, defaultValue);
	}

	public static int getInt(String key) {
		return Integer.parseInt(getString(key));
	}

	public static int getInt(String key, int defaultValue) {
		return Integer.parseInt(getString(key, String.valueOf(defaultValue)));
	}

	public static long getLong(String key, long defaultValue) {
		return Long.parseLong(getString(key, String.valueOf(defaultValue)));
	}

	public  static boolean getBoolean(String key, boolean defaultValue) {
		String r = getString(key, String.valueOf(defaultValue));
		if ("true".equalsIgnoreCase(r)) {
			return true;
		} else {
			return false;
		}
	}

	public static Date getDate(String key, Date defaultValue) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return df.parse(getString(key));
		} catch (ParseException e) {
			return defaultValue;
		} catch (NullPointerException e) {
			return defaultValue;
		}
	}
	
	
}
