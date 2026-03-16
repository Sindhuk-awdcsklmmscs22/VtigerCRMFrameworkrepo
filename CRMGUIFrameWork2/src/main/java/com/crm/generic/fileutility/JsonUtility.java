package com.crm.generic.fileutility;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonUtility {

	public String getDataFromJsonFile(String key) throws Throwable {
		FileReader fr = new FileReader("./testdata/appCommonData.json");
		//step1 : aprse JSon physical file into java object using JSonParse class 
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(fr);
		
		//step2 : covert java object into JSonObject using down casting
		JSONObject map = (JSONObject) obj;
		String data = map.get(key).toString();
		
		return data;
	}
}
