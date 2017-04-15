package script;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropFile {
public static Properties properties;

public ReadPropFile() {
	File file= new File("R:\\Java\\OrangeHRM-Selenium\\dataFile.properties");
	FileInputStream fileInputStream=null;
	try {
		fileInputStream= new FileInputStream(file);
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	
	properties= new Properties();
	try {
		properties.load(fileInputStream);
	} catch (IOException e) {
		e.printStackTrace();
	}

}	
		

}
