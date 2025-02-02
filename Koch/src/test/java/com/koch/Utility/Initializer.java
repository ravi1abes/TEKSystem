package com.koch.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Initializer {

	public static FileInputStream configfis = null;
	public static Properties configProp = null;
	public static Properties log4jProp = null;
	public static Logger addlog = null;

	public static void initialize() throws Throwable {
		addlog = Logger.getLogger("Initializer");

		// configure log4j properties file
		PropertyConfigurator.configure("E:\\TEKSystem\\Koch\\Config\\Log4j.properties");
		// PropertyConfigurator.configure(System.getProperty("user.dir")+
		// File.separator + "Config " +File.separator + "Log4j.properties");

		// configure Config properties file
		configfis = new FileInputStream(new File(
				System.getProperty("user.dir") + File.separator + "Config" + File.separator + "config.properties"));
		configProp = new Properties();
		configProp.load(configfis);
		PropertyConfigurator.configure(configProp);
		GlobalVar.Browser = configProp.getProperty("Browser");
		GlobalVar.URL = configProp.getProperty("URL");

	}

}
