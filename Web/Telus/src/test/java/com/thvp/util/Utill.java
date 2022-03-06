package com.thvp.util;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;



public class Utill {

	public static String Address_L1;
	public static String Address_L2;
	public static String city;
	public static String Postal;
	public static String Delivery_phone;
	public static String Ext;
	public Properties prop;

	public void getProp() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\com\\thvp\\configuration\\common.properties");
		prop.load(fis);

		String Address_L1 = prop.getProperty("Address1");

		String Address_L2 = prop.getProperty("Address2");
		String city = prop.getProperty("City");
		String Postal = prop.getProperty("Postal");
		String Delivery_phone = prop.getProperty("Delivery");

		String Ext = prop.getProperty("Ext");

		Utill.Address_L1 = Address_L1;
		Utill.Address_L2 = Address_L2;
		Utill.city = city;
		Utill.Postal = Postal;
		Utill.Delivery_phone = Delivery_phone;
		Utill.Ext = Ext;

	}



}
