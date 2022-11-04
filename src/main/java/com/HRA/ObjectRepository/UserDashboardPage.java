package com.HRA.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserDashboardPage {
	
	/*Declaration*/
	@FindBy(xpath="//a[text()='Register']")
	private WebElement RegisterLnk;
	
	@FindBy(xpath="//a[text()='Details/Update']")
	private WebElement UpdDetLnk;


	/*Initialization*/
	public UserDashboardPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	/*Utilization*/
	public WebElement getRegisterLnk() {
		return RegisterLnk;
	}
	
	public WebElement getUpdDetLnk() {
		return UpdDetLnk;
	}
	
	/*Business Libraries*/
	public void registerLnk()
	{
		RegisterLnk.click();
	}
	
	public void updDetLnk()
	{
		UpdDetLnk.click();
	}
	
}
