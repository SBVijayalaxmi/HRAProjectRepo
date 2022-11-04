package User_Module_genericUtility;

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

public class RaisingComplaint {

public static void main(String[] args) throws Throwable {
		
	DatabaseUtility dbLib = new DatabaseUtility();
	ExcelUtility eLib = new ExcelUtility();
	FileUtility fLib = new FileUtility();
	JavaUtility jLib = new JavaUtility();
	WebDriverUtility webLib = new WebDriverUtility();

	/*Step4: get the value using getProperty*/
	String Browser = fLib.readDataFromPropertFile("browser");
	String url = fLib.readDataFromPropertFile("url");
	String username = fLib.readDataFromPropertFile("username");
	String password = fLib.readDataFromPropertFile("password");
	String usernameA = fLib.readDataFromPropertFile("usernameA");
	String passwordA = fLib.readDataFromPropertFile("passwordA");
	
	/*Launching the browser*/
	WebDriver driver=null;
	
	if(Browser.equalsIgnoreCase("chrome"))
	{
		driver = new ChromeDriver();
	}
	else if (Browser.equalsIgnoreCase("firefox"))
	{
		driver = new FirefoxDriver();
	}
	else 
	{
		System.out.println("Invalid Browser");
	}
	
	driver.manage().window().maximize();
	driver.get(url);
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		/*Login as user*/
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("login")).click();
		
		driver.findElement(By.xpath("//a[text()='Details/Update']")).click();
		
		driver.findElement(By.xpath("(//a[text()='Complaint'])[1]")).click();
		
		driver.findElement(By.name("name")).sendKeys(eLib.readDataFromExcel("raising_complaint", 0, 1));
		driver.findElement(By.name("cmp")).sendKeys(eLib.readDataFromExcel("raising_complaint", 1, 1));
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		
		Thread.sleep(2000);
		
		/*logout as user*/
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		
		Thread.sleep(2000);
		
		/*Login as admin*/
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.name("username")).sendKeys(usernameA);
		driver.findElement(By.name("password")).sendKeys(passwordA);
		driver.findElement(By.name("login")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[text()='Complaint List']")).click();
		
		
		/*logout as admin*/
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		
		
	}
}
