package Admin_Module;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AvailibityOfRooms {
public static void main(String[] args) throws Throwable {
	/*To fetch the data from Property file*/
	FileInputStream fisAdmin = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	
	/*Step2: Create object for admin properties class*/
	Properties admin = new Properties();
	
	/*Step3: Load the keys*/
	admin.load(fisAdmin);

	/*Step4: get the value using getProperty*/
	String BROWSER = admin.getProperty("browser");
	String URL = admin.getProperty("url");
	String usernameA = admin.getProperty("username");
	String passwordA = admin.getProperty("password");
	
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
