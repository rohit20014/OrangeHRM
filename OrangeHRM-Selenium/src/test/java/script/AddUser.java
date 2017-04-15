package script;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class AddUser{
	ReadPropFile file= new ReadPropFile();
	WebDriver driver=script.Handler.Instance(ReadPropFile.properties.getProperty("browser"));
	WebElements elements= new WebElements(driver);
	ExcelReadWrite rw= new ExcelReadWrite();

	//@Test(priority = 1)
	//Blank password is provided
  public void invalidLoginBlankPassword() throws InterruptedException {
	  driver.navigate().refresh();
	  Thread.sleep(2000);
	  String expected=ExcelReadWrite.readExcel(1, 2);	 
	 
	  elements.username.clear();
	  elements.username.sendKeys(ReadPropFile.properties.getProperty("username"));
	  
	  elements.loginbtn.click();
	  
	  Thread.sleep(2000);
	  
	  verifyTestCase(elements.textLoginMessage, expected,1);
	  ExcelReadWrite.setExcel("Pass", 1, 4);
  }
	
	//@Test(priority=2)
	//Blank user name is provided
  public void invalidLoginBlankUsername() throws InterruptedException {
	  driver.navigate().refresh();
	  Thread.sleep(2000);
	  String expected=ExcelReadWrite.readExcel(2, 2);	 
	  
	  elements.password.clear();
	  elements.password.sendKeys(ReadPropFile.properties.getProperty("password"));
	  
	  elements.loginbtn.click();
	  
	  Thread.sleep(2000);
	  
	  verifyTestCase(elements.textLoginMessage, expected,2);
	  ExcelReadWrite.setExcel("Pass", 2, 4);
  }
	
	//@Test(priority=3)
	//User name and Password are kept blank
	  public void invalidloginBlank() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(2000);
		  String expected=ExcelReadWrite.readExcel(3, 2);	 
		 		  
		  elements.loginbtn.click();
		  
		  Thread.sleep(2000);
		  
		  verifyTestCase(elements.textLoginMessage, expected,3);
		  ExcelReadWrite.setExcel("Pass", 3, 4);
	  }
	
	//@Test(priority=4)
	//Wrong password is provided
	 public void ivalidLoginWrongPassword() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(2000);
	  String expected=ExcelReadWrite.readExcel(4, 2);	 
	  
	  elements.username.clear();
	  elements.username.sendKeys(ReadPropFile.properties.getProperty("username"));
	  
	  elements.password.clear();
	  elements.password.sendKeys(ReadPropFile.properties.getProperty("InvalidPass"));
	  
	  elements.loginbtn.click();
	  
	  Thread.sleep(2000);
	  
	  verifyTestCase(elements.textLoginMessage, expected,4);
	  ExcelReadWrite.setExcel("Pass", 4, 4);
  }
	
	//@Test(priority=5)
	//Wrong user name is provided
	 public void ivalidLoginWrongUsername() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(2000);
	  String expected=ExcelReadWrite.readExcel(5, 2);	 
	  
	  elements.username.clear();
	  elements.username.sendKeys(ReadPropFile.properties.getProperty("InvalidUser"));
	  
	  elements.password.clear();
	  elements.password.sendKeys(ReadPropFile.properties.getProperty("password"));
	  
	  elements.loginbtn.click();
	  
	  Thread.sleep(2000);
	  
	  verifyTestCase(elements.textLoginMessage, expected,5);
	  ExcelReadWrite.setExcel("Pass", 5, 4);
  }
	
	//@Test(priority=6)
	//Wrong user name and password is provided
	 public void ivalidLogin() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(2000);
	  String expected=ExcelReadWrite.readExcel(6, 2);	 
	  
	  elements.username.clear();
	  elements.username.sendKeys(ReadPropFile.properties.getProperty("InvalidUser"));
	  
	  elements.password.clear();
	  elements.password.sendKeys(ReadPropFile.properties.getProperty("password"));
	  
	  elements.loginbtn.click();
	  
	  Thread.sleep(2000);
	  
	  verifyTestCase(elements.textLoginMessage, expected,6);
	  ExcelReadWrite.setExcel("Pass", 6, 4);
  }
	
	@Test(priority = 7)
	//Correct user name and password is provided
  public void login() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(2000);
	  String expected=ExcelReadWrite.readExcel(7, 2);	 
	  
	  elements.username.clear();
	  elements.username.sendKeys(ReadPropFile.properties.getProperty("username"));
	  
	  elements.password.clear();
	  elements.password.sendKeys(ReadPropFile.properties.getProperty("password"));
	  
	  elements.loginbtn.click();
	  
	  Thread.sleep(2000);
	  
	  verifyTestCase(elements.textDashboard, expected,7);
	  ExcelReadWrite.setExcel("Pass", 7, 4);
  }
	
	public void verifyTestCase(WebElement element,String expected,int RowNum){
		  String actual=element.getText();
		  ExcelReadWrite.setExcel(actual, RowNum, 3);
		  Assert.assertEquals(actual, expected);
		
	}
	
	@Test(priority = 8)
	//Add USer
  public void addUser() throws InterruptedException {
		elements.adminUser.click();
		elements.addUser.click();
		select(elements.userRole,"ESS");
		elements.empName.clear();
		elements.empName.sendKeys("Fiona Grace");
		elements.username.clear();
		elements.userName.sendKeys("rohit123");
		select(elements.status, "Enabled");
		elements.pass.clear();
		elements.pass.sendKeys("eMee@123");
		elements.confirmpassword.clear();
		elements.confirmpassword.sendKeys("eMee@123");
		
  }
	
	public void select(WebElement element, String value){
		Select select= new Select(element);
		select.selectByVisibleText(value);
	}
	
	@AfterTest
	public void teardown()
	{
		ExcelReadWrite.writeExcel();
		driver.close();
	}
}

