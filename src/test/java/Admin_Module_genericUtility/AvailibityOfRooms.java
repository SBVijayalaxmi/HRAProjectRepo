package Admin_Module_genericUtility;

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

public class AvailibityOfRooms {
	
public static void main(String[] args) throws Throwable {

	DatabaseUtility dbLib = new DatabaseUtility();
	ExcelUtility eLib = new ExcelUtility();
	FileUtility fLib = new FileUtility();
	JavaUtility jLib = new JavaUtility();
	WebDriverUtility webLib = new WebDriverUtility();
	
	
	/* get the value using getProperty */
	String BROWSER = fLib.readDataFromPropertFile("browser");
	String URL = fLib.readDataFromPropertFile("url");
	String usernameA = fLib.readDataFromPropertFile("usernameA");
	String passwordA = fLib.readDataFromPropertFile("passwordA");
	
	/*Launching the browser*/
	WebDriver driver=null;
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		driver = new ChromeDriver();
	}
	else if (BROWSER.equalsIgnoreCase("firefox"))
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
		
		/*Login as user*/
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.name("username")).sendKeys(usernameA);
		driver.findElement(By.name("password")).sendKeys(passwordA);
		driver.findElement(By.name("login")).click();
		
		/*Clicking on available rooms link*/
		driver.findElement(By.xpath("//b[text()='Rooms for Rent: ']")).click();
		
		/*logout as admin*/
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		
		
		
}
}
