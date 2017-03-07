package com.ysstech.micro.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.ysstech.micro.model.JDBCBase;

public class ReadXMLUtil {
	/*public static void main(String[] args) {
		JDBCBase jb = read("oracle","dataSource1");
	}*/

	public static JDBCBase read(String dbName ,String dataSourceName) {
		URL base = ClassLoader.getSystemResource("");
		File xmlFile = new File(base.getFile(), "dbsetting.xml");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(xmlFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err.println("File is not exsit!");
		}

		SAXReader saxReader = new SAXReader();
		JDBCBase jb = new JDBCBase();
		try {
			// 生成xml对应实体
			Document doc = saxReader.read(fis);
			Element root = doc.getRootElement();
			for (Iterator iter = root.elementIterator(); iter.hasNext();) {
				Element element = (Element) iter.next();
				String name = element.attributeValue("name");
				if(name.equals(dbName+"/"+dataSourceName)){
					jb.setDriverClassName(element.attributeValue("driverClassName"));
					jb.setUrl(element.attributeValue("url"));
					jb.setUsername(element.attributeValue("username"));
					jb.setPassword(element.attributeValue("password"));
					jb.setInitialSize(element.attributeValue("initialSize"));
					jb.setMaxIdle(element.attributeValue("maxIdle"));
					jb.setMinIdle(element.attributeValue("minIdle"));
				}
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return jb;
	}
}
