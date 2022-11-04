package User_Module;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;

public class RaisingComplaint {

public static void main(String[] args) throws Throwable {
		
	/*To fetch the data from Excel*/
	FileInputStream fi = new FileInputStream("./src/test/resources/excel.xlsx");
	/*create workbook*/
	Workbook wb = WorkbookFactory.create(fi);
	/*get sheet*/
	Sheet sh = wb.getSheet("raising_complaint");
	
	/*To fetch the data from Property file*/
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	
	/*Step2: Create object for user properties class*/
	Properties pObj = new Properties();
	
	/*Step3: Load the keys*/
	pObj.load(fis);

	/*Step4: get the value using getProperty*/
	String Browser = pObj.getProperty("browser");
	String url = pObj.getProperty("url");
	String username = pObj.getProperty("username");
	String password = pObj.getProperty("password");
	String usernameA = pObj.getProperty("usernameA");
	String passwordA = pObj.getProperty("passwordA");
	
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
		
		driver.findElement(By.name("name")).sendKeys(sh.getRow(0).getCell(1).getStringCellValue());
		driver.findElement(By.name("cmp")).sendKeys(sh.getRow(1).getCell(1).getStringCellValue());
		
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
