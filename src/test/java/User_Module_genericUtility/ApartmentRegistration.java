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

public class ApartmentRegistration {

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

		/* Launching the browser */
		WebDriver driver = null;

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("Invalid Browser");
		}

		driver.manage().window().maximize();
		driver.get(URL);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		/* Login as user */
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.name("username")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.name("login")).click();

		/* Click on Register button */
		driver.findElement(By.xpath("//a[text()='Register']")).click();

		/* Click on Apartment Registration */
		driver.findElement(By.xpath("//a[text()='Apartment Registration']")).click();

		WebElement element1 = driver.findElement(By.xpath("//h2[text()='Apartment Room']"));
		webLib.scrollAction(driver, element1);

		/* fetching the data from excel sheet */
		eLib.getList(driver, "Apartment_registration", 0, 0, 1);

		/* Handling file upload pop up */
		driver.findElement(By.xpath("(//input[@name='image'])[2]")).sendKeys("C:\\Users\\ROOMAN\\OneDrive\\Desktop\\live project screenshoot\\image.png");

		/* clicking on add more button */
		driver.findElement(By.xpath("//a[contains(text(),'Add More')]")).click();

		/* clicking on delete button */
		driver.findElement(By.xpath("//a[text()='Delete']")).click();

		/* clicking on add more button */
		driver.findElement(By.xpath("//a[contains(text(),'Add More')]")).click();

		/* to scroll down */
		WebElement element2 = driver.findElement(By.xpath("(//input[@name='image'])[2]"));
		webLib.scrollAction(driver, element2);

		/* fetching the data from excel sheet */
		eLib.getList(driver, "Apartment_registration", 0, 2, 3);

		/* Handling purpose drop down list */
		WebElement purpose = driver.findElement(By.xpath("//select[@name='purpose[]']"));
		webLib.select(purpose, 1);

		/* Handling floor drop down list */
		WebElement floor = driver.findElement(By.xpath("//select[@name='floor[]']"));
		webLib.select(floor, 1);

		/* Handling owner or rented drop down list */
		WebElement ownerRented = driver.findElement(By.xpath("//select[@name='own[]']"));
		webLib.select(ownerRented, 1);
		
		/* Handling Vacant or occupied drop down list */
		WebElement vecantOccupied = driver.findElement(By.xpath("//select[@name='vacant[]']"));
		webLib.select(vecantOccupied, 1);

		/* clicking on submit button */
		driver.findElement(By.xpath("//button[@name='register_apartment']")).click();

		/* Logout from application */
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		
		

	}

}
