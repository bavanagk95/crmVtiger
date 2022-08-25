package com.vTiger.GenericUtilities;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

/**
 * 
 * @author bavana
 *
 */

/**
 */
public class FileUtility
{
	
	/**
	 *    its used return the value from the property file based on key
	 * @param key
	 * @return
	 * @throws Throwable
	 */
public String getPropertyKeyValue(String key) throws Throwable {
		
		FileInputStream fis = new FileInputStream(".\\Data\\Commondata.properties");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
		
	}}
