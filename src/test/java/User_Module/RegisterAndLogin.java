package User_Module;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class RegisterAndLogin {
	public static void main(String[] args) throws Throwable {

		/*To fetch the data from Excel*/
		FileInputStream fi = new FileInputStream("./src/test/resources/excel.xlsx");
		/*create workbook*/
		Workbook wb = WorkbookFactory.create(fi);
		/*get sheet*/
		Sheet sh = wb.getSheet("Register");
		
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

		/* Launching the browser */
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get(URL);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		/*Registering new user*/
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		
		ArrayList<String> columnlist = new ArrayList<String>();
		columnlist.add("fullname");
		columnlist.add("username");
		columnlist.add("mobile");
		columnlist.add("email");
		columnlist.add("password");
		columnlist.add("c_password");
		
		for(int i=0;i<=sh.getLastRowNum();i++)
		{
		 String value = sh.getRow(i).getCell(1).getStringCellValue();
		driver.findElement(By.name(columnlist.get(i))).sendKeys(value);
		}
		
		driver.findElement(By.name("register")).click();
		
		/*Login as new user*/
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.name("username")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.name("login")).click();
		
		/*Logout from application*/
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
	}

}
