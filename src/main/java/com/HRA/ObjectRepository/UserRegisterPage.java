package com.HRA.ObjectRepository;

import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRA.GenericLibraries.ExcelUtility;

public class UserRegisterPage {
	
	/*Declaration*/
	@FindBy(name="fullname")
	private WebElement FullnameEdt;
	@FindBy(name="username")
	private WebElement UsernameEdt;
	@FindBy(name="mobile")
	private WebElement MobileEdt;
	@FindBy(name="email")
	private WebElement EmailEdt;
	@FindBy(name="password")
	private WebElement PasswordEdt;
	@FindBy(name="c_password")
	private WebElement CFPasswordEdt;
	@FindBy(name="register")
	private WebElement SubmitBtn;
	@FindBy(name="Login")
	private WebElement LoginBtn;
	
	/*Initialization*/
	public UserRegisterPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	/*Utilization*/
	
	public WebElement getFullnameEdt() {
		return FullnameEdt;
	}

	public WebElement getUsernameEdt() {
		return UsernameEdt;
	}

	public WebElement getMobileEdt() {
		return MobileEdt;
	}

	public WebElement getEmailEdt() {
		return EmailEdt;
	}

	public WebElement getPasswordEdt() {
		return PasswordEdt;
	}

	public WebElement getCFPasswordEdt() {
		return CFPasswordEdt;
	}

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}

	public WebElement getLoginBtn() {
		return LoginBtn;
	}
	
	/*Business libraries*/
	
	public void regNewUser(Map<String, String> map, WebDriver driver)
	{
	for(Entry<String, String> set:map.entrySet())
	{
		driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
	}
	}
	
	public void GetSubmitBtn()
	{
		SubmitBtn.click();	
	}
	
	public void loginBtn()
	{
		LoginBtn.click();	
	}
	
}
