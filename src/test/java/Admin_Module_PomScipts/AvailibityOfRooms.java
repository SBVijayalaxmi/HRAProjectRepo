package Admin_Module_PomScipts;

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
import com.HRA.ObjectRepository.AdminDashboardPage;
import com.HRA.ObjectRepository.HomePage;
import com.HRA.ObjectRepository.LoginPage;

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
	String USERNAMEA = fLib.readDataFromPropertFile("usernameA");
	String PASSWORDA = fLib.readDataFromPropertFile("passwordA");
	
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
	
	HomePage hP = new HomePage(driver);
	hP.LoginBtn();

	/* Login as Admin */
	LoginPage lP = new LoginPage(driver);
	lP.loginBtb();
	lP.login(USERNAMEA, PASSWORDA);
//		driver.findElement(By.xpath("//a[text()='Login']")).click();
//		driver.findElement(By.name("username")).sendKeys(usernameA);
//		driver.findElement(By.name("password")).sendKeys(passwordA);
//		driver.findElement(By.name("login")).click();
//		
		
		/*creates the object of AdminDashboardPage*/
		AdminDashboardPage adminDP = new AdminDashboardPage(driver);
		/*Clicking on available rooms link*/
		adminDP.AvailabilityOfRoomsLnk();
//		driver.findElement(By.xpath("//b[text()='Rooms for Rent: ']")).click();
		
		/*logout as admin*/
		lP.logoutBtn();
//		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		
		
		
}
}
