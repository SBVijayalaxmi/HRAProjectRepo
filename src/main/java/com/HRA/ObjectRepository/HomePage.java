package com.HRA.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	

	/*Declaration*/
	@FindBy(xpath="//a[text()='Register']")
	private WebElement RegisterBtn;
	
	@FindBy(xpath="//a[text()='Login']")
	private WebElement LoginBtn;
	
	/*Initialization*/
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	/*Utilization*/
	public WebElement getRegisterEdt() {
		return RegisterBtn;
	}

	public WebElement getLoginEdt() {
		return LoginBtn;
	}
	
	/*business libraries*/
	
	public void registerBtn()
	{
		RegisterBtn.click();
	}
	
	public void LoginBtn()
	{
		LoginBtn.click();
	}
	
}
