package com.nexos.backend.api.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Message {
	private static Properties properties;
	static {
		String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		String appConfigPath = rootPath + "message.properties";
		
		properties = new Properties();
		try {
			properties.load(new FileInputStream(appConfigPath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String getMessage(MessageCode messageCode) {
		return properties.getProperty(messageCode.code);
	}
}
