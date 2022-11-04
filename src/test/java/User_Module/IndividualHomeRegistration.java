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



public class IndividualHomeRegistration {

	public static void main(String[] args) throws Throwable {
		
		/*To fetch the data from Excel*/
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\excel.xlsx");
		/*create workbook*/
		Workbook wb = WorkbookFactory.create(fi);
		/*get sheet*/
		Sheet sh = wb.getSheet("Home_Registration");
		
		/*To fetch the data from Property file*/
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
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
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)",element);
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("fullname");
		list.add("mobile");
		list.add("alternat_mobile");
		list.add("email");
		list.add("plot_number");
		list.add("rooms");
		list.add("country");
		list.add("state");
		list.add("city");
		list.add("rent");
		list.add("deposit");
		list.add("accommodation");
		//list.add("description");
		list.add("landmark");
		list.add("address");

		for(int i=0;i<=sh.getLastRowNum();i++)
		{
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			driver.findElement(By.name(list.get(i))).sendKeys(value);
		}
		
		Thread.sleep(2000);
		/*Handling drop down list*/
		WebElement listbox = driver.findElement(By.name("vacant"));
		Select s = new Select(listbox);
		s.selectByIndex(0);
		
		Thread.sleep(2000);
		/*Handling file upload pop up*/
		driver.findElement(By.id("image")).sendKeys("C:\\Users\\ROOMAN\\OneDrive\\Desktop\\live project screenshoot\\image.png");
		Thread.sleep(2000);
		
		driver.findElement(By.name("register_individuals")).click();
	
		/*Logout from application*/
		driver.findElement(By.xpath("//a[text()='Logout']")).click();

	}

}
