package User_Module_PomScripts;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.HRA.GenericLibraries.DatabaseUtility;
import com.HRA.GenericLibraries.ExcelUtility;
import com.HRA.GenericLibraries.FileUtility;
import com.HRA.GenericLibraries.JavaUtility;
import com.HRA.GenericLibraries.WebDriverUtility;
import com.HRA.ObjectRepository.HomePage;
import com.HRA.ObjectRepository.LoginPage;
import com.HRA.ObjectRepository.UserRegisterPage;

public class RegisterAndLogin {
	
	public static void main(String[] args) throws Throwable {
		
		/*Creates the object of generic utility*/
		
		DatabaseUtility dbLib = new DatabaseUtility();
		ExcelUtility eLib = new ExcelUtility();
		FileUtility fLib = new FileUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility webLib = new WebDriverUtility();

		/*get the value using getProperty*/
		
		String BROWSER = fLib.readDataFromPropertFile("browser");
		String URL = fLib.readDataFromPropertFile("url");
		String USERNAME = fLib.readDataFromPropertFile("username");
		String PASSWORD = fLib.readDataFromPropertFile("password");
		
		/*Launching the browser*/
		
		WebDriver driver = null;
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("Invalid Browser");
		}
		
		driver.manage().window().maximize();
		driver.get(URL);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		/**/
		HomePage hP = new HomePage(driver);
		UserRegisterPage userReg = new UserRegisterPage(driver);
		LoginPage lP = new LoginPage(driver);
		
		/*Registering new user*/

		/*Creating the object of HomePage pom class*/
		//HomePage hP = new HomePage(driver);
		
		hP.registerBtn();
		userReg.regNewUser(eLib.getList(driver, "Register", 0, 0, 1), driver);
	
		
	//	UserRegisterPage userReg = new UserRegisterPage(driver);
	
		userReg.getSubmitBtn();
		
		//userReg.regNewUser(eLib.getList("Register", 0, 0, 1), driver);
		
		userReg.getLoginBtn();
		
	//	LoginPage lP = new LoginPage(driver);
		
		/*Login as new user*/
		lP.login(USERNAME, PASSWORD);
		
		/*Logout from application*/
		lP.getLogoutBtn();
		

	}
	}
