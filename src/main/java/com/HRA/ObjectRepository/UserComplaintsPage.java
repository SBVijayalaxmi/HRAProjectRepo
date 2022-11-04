package com.HRA.ObjectRepository;

import java.util.Map;
import java.util.Map.Entry;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserComplaintsPage {

	/*Declaration*/
	@FindBy(name="name")
	private WebElement FullnameEdt;
	
	@FindBy(name="cmp")
	private WebElement ComplaintTxtEdt;
	
	@FindBy(name="register")
	private WebElement SubmitBtn;
	
	/*Initialization*/
	public UserComplaintsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	/*Utilization*/
	public WebElement getFullnameEdt() {
		return FullnameEdt;
	}

	public WebElement getComplaintTxtEdt() {
		return ComplaintTxtEdt;
	}

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}
	
	/*Business libraries*/
	
	public void UserComplaint(Map<String, String> map, WebDriver driver)
	{
	for(Entry<String, String> set:map.entrySet())
	{
		driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
	}
	}
	
	public void ClickOnSubmitBtn()
	{
		SubmitBtn.click();	
	}
	
	
}
