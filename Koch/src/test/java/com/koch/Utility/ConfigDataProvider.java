package com.koch.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {

	public Properties prop = null;

	public ConfigDataProvider() {

		File file = new File("./Config/config.properties");
		try {
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Exception in reading Config File : - " + e.getMessage());
		}

	}

	public String GetDataFromConfig(String KeyToSearch) {
		return prop.getProperty(KeyToSearch);
	}

	public String GetBrowserKeyValue() {
		return prop.getProperty("Browser");
	}

	public String GetURLKeyValue() {
		return prop.getProperty("URL");
	}
}
