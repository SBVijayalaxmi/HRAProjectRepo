package User_Module_genericUtility;


import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.HRA.GenericLibraries.DatabaseUtility;
import com.HRA.GenericLibraries.ExcelUtility;
import com.HRA.GenericLibraries.FileUtility;
import com.HRA.GenericLibraries.JavaUtility;
import com.HRA.GenericLibraries.WebDriverUtility;



public class IndividualHomeRegistration {

	public static void main(String[] args) throws Throwable {
		
		DatabaseUtility dbLib = new DatabaseUtility();
		ExcelUtility eLib = new ExcelUtility();
		FileUtility fLib = new FileUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility webLib = new WebDriverUtility();

		/* get the value using getProperty */
		String BROWSER = fLib.readDataFromPropertFile("browser");
		String URL = fLib.readDataFromPropertFile("url");
		String USERNAME = fLib.readDataFromPropertFile("username");
		String PASSWORD = fLib.readDataFromPropertFile("password");

		
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
		
		/*Login as new user*/
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.name("username")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.name("login")).click();
		
		/*Registering new Individual Home Registration*/
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		
		/*to scroll down*/
		WebElement element = driver.findElement(By.xpath("//h2[text()='Register Room']"));
		webLib.scrollAction(driver, element);
		
		/* fetching the data from excel sheet */
		eLib.getList(driver, "Home_registration", 0, 0, 1);
		
		Thread.sleep(2000);
		/*Handling drop down list*/
		WebElement listbox = driver.findElement(By.name("vacant"));
		webLib.select(listbox, 0);
		
		Thread.sleep(2000);
		
		/*Handling file upload pop up*/
		driver.findElement(By.id("image")).sendKeys("C:\\Users\\ROOMAN\\OneDrive\\Desktop\\live project screenshoot\\image.png");
		Thread.sleep(2000);
		
		driver.findElement(By.name("register_individuals")).click();
	
		/*Logout from application*/
		driver.findElement(By.xpath("//a[text()='Logout']")).click();

	}

}
