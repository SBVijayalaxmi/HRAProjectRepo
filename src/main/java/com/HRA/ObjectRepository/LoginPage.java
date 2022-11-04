package com.HRA.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	/*Declaration*/
	@FindBy(name="username")
	private WebElement UsernameEdt;
	
	@FindBy(name ="password")
	private WebElement PasswordEdt;
	
	@FindBy(name="login")
	private WebElement LoginBtb;
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement LogoutBtn;
	
	/*Initialization*/
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	/*Utilization*/

	public WebElement getUsernameEdt() {
		return UsernameEdt;
	}

	public WebElement getPasswordEdt() {
		return PasswordEdt;
	}

	public WebElement getLoginBtb() {
		return LoginBtb;	
	}
	
	public WebElement getLogoutBtn() {
		return LogoutBtn;
	}
	
	/*Business Libraries*/
	public void login(String USERNAME, String PASSWORD)
	{
		UsernameEdt.sendKeys(USERNAME);
		PasswordEdt.sendKeys(PASSWORD);
		LoginBtb.click();
	}
	
	public void loginBtb()
	{
		LoginBtb.click();
	}
	
	public void logoutBtn()
	{
		LogoutBtn.click();
	}
}
