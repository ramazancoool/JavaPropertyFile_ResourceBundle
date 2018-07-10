package com.example;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleExample 
{
    private static final String FILE_NAME = "application";

	public static void main( String[] args )
    {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(FILE_NAME);
        //default is en 
        System.out.println("default greet: " + resourceBundle.getString("greet"));
        
        resourceBundle = ResourceBundle.getBundle(FILE_NAME, new Locale("tr"));
        System.out.println("tr greet: " + resourceBundle.getString("greet"));

        resourceBundle = ResourceBundle.getBundle(FILE_NAME, new Locale("en"));
        System.out.println("en greet: " + resourceBundle.getString("greet"));
        
        //There is no property for 'fr', it look for first 'application_en.properties'
        //'application_en.properties' also not contain 'bye', it look default file(application.properties'
        resourceBundle = ResourceBundle.getBundle(FILE_NAME, new Locale("fr"));
        
        System.out.println("fr greet: " + resourceBundle.getString("greet") );
        System.out.println("fr bye: " + resourceBundle.getString("bye"));
        
    }
}
