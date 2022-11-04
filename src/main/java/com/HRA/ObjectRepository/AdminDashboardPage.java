package com.HRA.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminDashboardPage {

	/*Declaration*/
	@FindBy(xpath="//a[text()='Complaint List']")
	private WebElement ComplaintlistLnk;
	
	@FindBy(xpath="//b[text()='Rooms for Rent: ']")
	private WebElement AvailabilityOfRoomsLnk;
	
	/*Initialization*/
	public AdminDashboardPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	/*Utilization*/
	public WebElement getComplaintlistLnk() {
		return ComplaintlistLnk;
	}
	
	public WebElement getAbailabilityOfRoomsLnk() {
		return AvailabilityOfRoomsLnk;
	}
	
	/*Business Libraries*/
	public void ComplaintlistLnk()
	{
		ComplaintlistLnk.click();
	}
	
	public void AvailabilityOfRoomsLnk()
	{
		AvailabilityOfRoomsLnk.click();
	}
	
}
