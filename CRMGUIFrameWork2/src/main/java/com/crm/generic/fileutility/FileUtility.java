package com.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtility {

	public String getDataFromPropertiesFile(String Key) throws Throwable {
		FileInputStream fis = new FileInputStream("./testdata/commonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(Key);	
	}
}
