package SystemTestCases;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.HRA.GenericLibraries.DatabaseUtility;
import com.HRA.GenericLibraries.ExcelUtility;
import com.HRA.GenericLibraries.FileUtility;
import com.HRA.GenericLibraries.JavaUtility;
import com.HRA.GenericLibraries.WebDriverUtility;

public class RegisterAndLogin {
	
	public static void main(String[] args) throws Throwable {
		
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
		
		/*Registering new user*/
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		
		/*calling the excel utility method to fetch the data from excel sheet*/
		eLib.getList(driver, "Register", 0, 0, 1);
		
		driver.findElement(By.name("register")).click();
		
		/*Login as new user*/
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.name("username")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.name("login")).click();
		
		/*Logout from application*/
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
	}

}
