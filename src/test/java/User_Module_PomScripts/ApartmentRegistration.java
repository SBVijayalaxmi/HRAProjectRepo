package User_Module_PomScripts;


import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

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
import com.HRA.ObjectRepository.HomePage;
import com.HRA.ObjectRepository.LoginPage;
import com.HRA.ObjectRepository.RegistrationPage;
import com.HRA.ObjectRepository.UserDashboardPage;
import com.HRA.ObjectRepository.UserRegisterPage;

import io.github.bonigarcia.wdm.WebDriverManager;

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

		
		WebDriverManager.chromedriver().setup();
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
		
		/*Clicking on login button on homepage*/
		HomePage hP = new HomePage(driver);
		hP.LoginBtn();
		
		/* Login as user */
		LoginPage lP = new LoginPage(driver);
		lP.loginBtb();
		lP.login(USERNAME, PASSWORD);

		/* Click on Register button */
		UserDashboardPage userDP = new UserDashboardPage(driver);
		
		userDP.registerLnk();
		
		
		/* Click on Apartment Registration */
		RegistrationPage regP = new RegistrationPage(driver);
		regP.apartmentRegLnk();
		/*stores the data in Hashmap from excel*/
		Map<String, String> data1 = eLib.getList(driver, "Apartment_registration", 0, 0, 1);
		/*fetches the data from Hashmap*/
		regP.createNewAparment(data1, driver);

		/* Handling file upload pop up */
//		driver.findElement(By.xpath("(//input[@name='image'])[2]")).sendKeys("C:\\Users\\ROOMAN\\OneDrive\\Desktop\\live project screenshoot\\image.png");
		regP.FileuploadPopup("C:\\Users\\ROOMAN\\OneDrive\\Desktop\\live project screenshoot\\image.png");
		/* Click on Add more button */
		regP.clickOnAddMoreButton();
		/* Click on Delete button */
		regP.clickOnDeleteButton();
		/* Click on Add more button */
		regP.clickOnAddMoreButton();
		
		/*stores the data in Hashmap from excel*/
		Map<String, String> data2 = eLib.getList(driver, "Apartment_registration", 0, 2, 3);
		/*fetches the data from Hashmap*/
		regP.createNewAparment(data2, driver);
		
		
//		/* clicking on add more button */
//		driver.findElement(By.xpath("//a[contains(text(),'Add More')]")).click();
//
//		/* clicking on delete button */
//		driver.findElement(By.xpath("//a[text()='Delete']")).click();
//
//		/* clicking on add more button */
//		driver.findElement(By.xpath("//a[contains(text(),'Add More')]")).click();
//
//		/*scroll to the element*/
//		webLib.scrollAction(driver, regP.getImageUPop());
//
//		/* fetching the data from excel sheet */
//		eLib.getList(driver, "Apartment_registration", 0, 2, 3);

		/* Handling purpose drop down list */
//		WebElement purpose = driver.findElement(By.xpath("//select[@name='purpose[]']"));
//		webLib.select(purpose, 1);
		webLib.select(regP.getPurposeDP(), 1);
		
		/* Handling floor drop down list */
		webLib.select(regP.getFloorDP(), 1);

		/* Handling owner or rented drop down list */
		webLib.select(regP.getOwnRenDP(), 1);
		
		/* Handling Vacant or occupied drop down list */
		webLib.select(regP.getVacOccDP(), 1);

		/* clicking on submit button */
//		driver.findElement(By.xpath("//button[@name='register_apartment']")).click();
		regP.submitBtn();
		
		
		/* Logout from application */
//		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		lP.logoutBtn();
	}

}
