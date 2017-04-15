package script;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Handler {
	
	public static WebDriver driver;
	
	public static WebDriver Instance(String browser) {
		String browsername=browser;
		if(browsername.equalsIgnoreCase("Chrome")){
			System.out.println("chrome");
			}
		else{
			System.out.println("here in else");
			  System.setProperty("webdriver.gecko.driver", "C:/Users/Rohit Singh/Downloads/gecko/geckodriver.exe");
			driver=new FirefoxDriver();
			  driver.get(ReadPropFile.properties.getProperty("URL"));
			  driver.manage().window().maximize();
		}
		
		return driver;
	}

}
