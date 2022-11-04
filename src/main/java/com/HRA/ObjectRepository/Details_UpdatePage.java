package com.HRA.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Details_UpdatePage {
	
	/*Declaration*/
	@FindBy(xpath="(//a[text()='Complaint'])[1]")
	private WebElement ComplaintBtn;
	
	/*Initialization*/
	public Details_UpdatePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	/*Utilization*/
	
	/*Business libraries*/
	public void complaintBtn()
	{
		ComplaintBtn.click();
	}
	
}
