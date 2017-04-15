package script;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebElements{
	
	WebDriver driver;
//Login Elements	
	@FindBy(id="txtUsername")
	WebElement username;
	
	@FindBy(id="txtPassword")
	WebElement password;
	
	@FindBy(id="btnLogin")
	WebElement loginbtn;
	
	@FindBy(id="menu_admin_viewSystemUsers")
	WebElement systemUsers;
	
	@FindBy(id="spanMessage")
	WebElement textLoginMessage;
	
	@FindBy(xpath="/html/body/div[1]/div[3]/div/div[1]/h1")
	WebElement textDashboard;
	
//Add User
	
	@FindBy(id="menu_admin_viewSystemUsers")
	WebElement adminUser;
	
	@FindBy(id="btnAdd")
	WebElement addUser;
	
	@FindBy(id="systemUser_userType")
	WebElement userRole;
	
	@FindBy(id="systemUser_employeeName_empName")
	WebElement empName;
	
	@FindBy(id="systemUser_userName")
	WebElement userName;
	
	@FindBy(id="systemUser_status")
	WebElement status;
	
	@FindBy(id="systemUser_password")
	WebElement pass;
	
	@FindBy(id="systemUser_confirmPassword")
	WebElement confirmpassword;
	
	@FindBy(id="btnSave")
	WebElement saveUser;
	
	public WebElements(WebDriver driver ) {
		PageFactory.initElements(driver, this);
	}

}
