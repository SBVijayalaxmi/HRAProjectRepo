package com.HRA.ObjectRepository;

import java.util.Map;
import java.util.Map.Entry;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRA.GenericLibraries.IPathConstants;

public class RegistrationPage {

	@FindBy(xpath="//a[text()='Apartment Registration']")
	private WebElement ApartmentRegLnk;
	
	@FindBy(name="apartment_name")
	private WebElement ApartmentnameEdt;
	@FindBy(name="mobile")
	private WebElement MobileEdt;
	@FindBy(name="alternat_mobile")
	private WebElement AltMobileEdt;
	@FindBy(name="email")
	private WebElement EmailEdt;
	@FindBy(name="plot_number")
	private WebElement PlotnoEdt;
	@FindBy(name="country")
	private WebElement CountryEdt;
	@FindBy(name="state")
	private WebElement StateEdt;
	@FindBy(name="city")
	private WebElement CityEdt;
	@FindBy(name="landmark")
	private WebElement LandmarkEdt;
	@FindBy(name="address")
	private WebElement addressEdt;
	
	@FindBy(name="image")
	private WebElement ImageUPop;
	
	@FindBy(xpath="//a[contains(text(),'Add More')]")
	private WebElement AddmoreBtn;
	
	@FindBy(xpath="//a[text()='Delete']")
	private WebElement DeleteBtn;
	
	@FindBy(name="fullname[]")
	private WebElement FullnameEdt;
	@FindBy(name="ap_number_of_plats[]")
	private WebElement FlatNoEdt;
	@FindBy(name="rooms[]")
	private WebElement RoomEdt;
	@FindBy(name="area[]")
	private WebElement AreaEdt;
	@FindBy(name="rent[]")
	private WebElement RentEdt;
	@FindBy(name="deposit[]")
	private WebElement DepositEdt;
	@FindBy(name="accommodation[]")
	private WebElement FacilityEdt;
	@FindBy(name="description[]")
	private WebElement DescriptionEdt;
	
	@FindBy(name="purpose[]")
	private WebElement PurposeDP;
	@FindBy(name="floor[]")
	private WebElement FloorDP;
	@FindBy(name="own[]")
	private WebElement OwnRenDP;
	@FindBy(name="vacant[]")
	private WebElement VacOccDP;
	
	@FindBy(name="register_apartment")
	private WebElement SubmitBtn;
	
	
	
	/*Initialization*/
	public RegistrationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/*Utilization*/

	public WebElement getApartmentRegLnk() {
		return ApartmentRegLnk;
	}
	public WebElement getApartmentnameEdt() {
		return ApartmentnameEdt;
	}
	public WebElement getMobileEdt() {
		return MobileEdt;
	}
	public WebElement getAltMobileEdt() {
		return AltMobileEdt;
	}
	public WebElement getEmailEdt() {
		return EmailEdt;
	}
	public WebElement getPlotnoEdt() {
		return PlotnoEdt;
	}
	public WebElement getCountryEdt() {
		return CountryEdt;
	}
	public WebElement getStateEdt() {
		return StateEdt;
	}
	public WebElement getCityEdt() {
		return CityEdt;
	}
	public WebElement getLandmarkEdt() {
		return LandmarkEdt;
	}
	public WebElement getAddressEdt() {
		return addressEdt;
	}
	public WebElement getImageUPop() {
		return ImageUPop;
	}
	public WebElement getAddmoreBtn() {
		return AddmoreBtn;
	}
	public WebElement getDeleteBtn() {
		return DeleteBtn;
	}
	public WebElement getFullnameEdt() {
		return FullnameEdt;
	}
	public WebElement getFlatNoEdt() {
		return FlatNoEdt;
	}
	public WebElement getRoomEdt() {
		return RoomEdt;
	}
	public WebElement getAreaEdt() {
		return AreaEdt;
	}
	public WebElement getRentEdt() {
		return RentEdt;
	}
	public WebElement getDepositEdt() {
		return DepositEdt;
	}
	public WebElement getFacilityEdt() {
		return FacilityEdt;
	}
	public WebElement getDescriptionEdt() {
		return DescriptionEdt;
	}
	public WebElement getPurposeDP() {
		return PurposeDP;
	}
	public WebElement getFloorDP() {
		return FloorDP;
	}
	public WebElement getOwnRenDP() {
		return OwnRenDP;
	}
	public WebElement getVacOccDP() {
		return VacOccDP;
	}
	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}

	/*Business Libraries*/
	
	public void clickOnAddMoreButton() 
	{
		AddmoreBtn.click();
	}
	
	public void createNewAparment(Map<String, String> map, WebDriver driver)
	{
	for(Entry<String, String> set:map.entrySet())
	{
		driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
	}
	}

	public void apartmentRegLnk() 
	{
		ApartmentRegLnk.click();
	}
	
	public void clickOnDeleteButton() 
	{
		DeleteBtn.click();
	}
	
	public void FileuploadPopup(String path) 
	{
		ImageUPop.sendKeys(path);
	}
	
	public void purposeDP() 
	{
		PurposeDP.click();
	}
	public void floorDP() 
	{
		FloorDP.click();
	}
	public void ownRenDP() 
	{
		OwnRenDP.click();
	}
	public void vacOccDP() 
	{
		VacOccDP.click();
	}
	
	public void submitBtn() 
	{
		SubmitBtn.click();
	}
}
