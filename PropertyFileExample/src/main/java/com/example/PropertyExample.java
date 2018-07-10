package com.example;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertyExample {

	private static final String CONFIG_FILE_NAME = "application.config";

	public static void main(String[] args) throws IOException {
		
		readFromPropertyFile(CONFIG_FILE_NAME);
		
		writeToPropertyFile();
	}

	private static void writeToPropertyFile() throws FileNotFoundException,
			IOException {
		OutputStream outputStream = 
				new FileOutputStream("src//main//config//output.config");
		Properties properties = new Properties();
		properties.setProperty("lang", "english");
		properties.setProperty("location", "europa");
		
		properties.store(outputStream, "comments");
	}

	private static void readFromPropertyFile(String fileName) throws IOException {
		Properties properties = new Properties();

		InputStream inputStream = PropertyExample.class.getClassLoader().
				getResourceAsStream(fileName);
		
		properties.load(inputStream);
		
		System.out.println("db.username: " + properties.getProperty("db.username"));
		System.out.println("db.password: " + properties.getProperty("db.password"));
		System.out.println("db.url: " + properties.getProperty("db.url"));
	}
}
