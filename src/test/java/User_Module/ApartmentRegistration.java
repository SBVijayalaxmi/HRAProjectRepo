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
import org.openqa.selenium.support.ui.Select;


public class ApartmentRegistration {

public static void main(String[] args) throws Throwable  {
		
	/*To fetch the data from Excel*/
	FileInputStream fi = new FileInputStream("./src/test/resources/excel.xlsx");
	/*create workbook*/
	Workbook wb = WorkbookFactory.create(fi);
	/*get sheet*/
	Sheet sh = wb.getSheet("Apartment_registration");
	
	/*To fetch the data from Property file*/
	FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
	
	/*Step2: Create object for properties class*/
	Properties pObj = new Properties();
	
	/*Step3: Load the keys*/
	pObj.load(fis);

	/*Step4: get the value using getProperty*/
	String BROWSER = pObj.getProperty("browser");
	String URL = pObj.getProperty("url");
	String USERNAME = pObj.getProperty("username");
	String PASSWORD = pObj.getProperty("password");
	
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
		
		/*Login as user*/
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.name("username")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.name("login")).click();
		
		/*Click on Register button*/
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		
		/*Click on Apartment Registration*/
		driver.findElement(By.xpath("//a[text()='Apartment Registration']")).click();
		
		/*to scroll down*/
		WebElement element1 = driver.findElement(By.xpath("//h2[text()='Apartment Room']"));
		
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].scrollIntoView(true)",element1);
		
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("//input[@name='apartment_name']");
		list1.add("(//input[@name='mobile'])[2]");
		list1.add("(//input[@name='alternat_mobile'])[2]");
		list1.add("(//input[@name='email'])[2]");
		list1.add("(//input[@name='plot_number'])[2]");
		list1.add("(//input[@name='country'])[2]");
		list1.add("(//input[@name='state'])[2]");
		list1.add("(//input[@name='city'])[2]");
		list1.add("(//input[@name='landmark'])[2]");
		list1.add("(//input[@name='address'])[2]");
		
		
		for(int i=0;i<=sh.getLastRowNum();i++)
		{
			System.out.println(sh.getLastRowNum());
			String value1 = sh.getRow(i).getCell(1).getStringCellValue();
			driver.findElement(By.xpath(list1.get(i))).sendKeys(value1);
			
		}
		
		Thread.sleep(2000);
		/*Handling file upload pop up*/
		driver.findElement(By.xpath("(//input[@name='image'])[2]")).sendKeys("C:\\Users\\ROOMAN\\OneDrive\\Desktop\\live project screenshoot\\image.png");
		Thread.sleep(2000);
		/*clicking on add more button*/
		driver.findElement(By.xpath("//a[contains(text(),'Add More')]")).click();
		Thread.sleep(2000);
		/*clicking on delete button*/
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		
		/*clicking on add more button*/
		driver.findElement(By.xpath("//a[contains(text(),'Add More')]")).click();
		
		/*to scroll down*/
		WebElement element2 = driver.findElement(By.xpath("(//input[@name='image'])[2]"));
		
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].scrollIntoView(true)",element2);
		
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("fullname[]");
		list2.add("ap_number_of_plats[]");
		list2.add("rooms[]");
		list2.add("area[]");
		list2.add("rent[]");
		list2.add("deposit[]");
		list2.add("accommodation[]");
		list2.add("description[]");
		
	
		for(int i=0;i<=sh.getRow(i).getLastCellNum();i++)
		{
			String value2 = sh.getRow(i).getCell(3).getStringCellValue();
			driver.findElement(By.name(list2.get(i))).sendKeys(value2);
		}
		
		/*Handling purpose drop down list*/
		WebElement purpose = driver.findElement(By.xpath("//select[@name='purpose[]']"));
		Select s1 = new Select(purpose);
		s1.selectByIndex(1);
		
		/*Handling floor drop down list*/
		WebElement floor = driver.findElement(By.xpath("//select[@name='floor[]']"));
		Select s2 = new Select(floor);
		s2.selectByIndex(1);
		
		/*Handling owner or rented drop down list*/
		WebElement ownerRented = driver.findElement(By.xpath("//select[@name='own[]']"));
		Select s3 = new Select(ownerRented);
		s3.selectByIndex(1);
		
		/*Handling Vacant or occupied drop down list*/
		WebElement vecantOccupied = driver.findElement(By.xpath("//select[@name='vacant[]']"));
		Select s4 = new Select(vecantOccupied);
		s4.selectByIndex(1);
		
		/*clicking on submit button*/
		driver.findElement(By.xpath("//button[@name='register_apartment']")).click();
		
		/*Logout from application*/
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		
	}

}
