package com.training.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RETC_080_AddPropertyPOM {
private WebDriver driver; 
	
	public RETC_080_AddPropertyPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[text()='Properties']")
	private WebElement PropertiesLink;
	
	public void ClickPropertiesLink() {
		this.PropertiesLink.click();
	}
	
	@FindBy(xpath="//a[@class='page-title-action' and text()='Add New']")
	private WebElement AddNewPropertiesLink;
	
	public void ClickAddNewPropertiesLink() {
		this.AddNewPropertiesLink.click();
	}
	
	@FindBy(name="post_title")
	private WebElement PropertiesTitle; 
	
	public void sendPropertyTitle(String Properties) {
		this.PropertiesTitle.clear(); 
		this.PropertiesTitle.sendKeys(Properties); 
		driver.switchTo().frame("content_ifr");
	}
	
	@FindBy(xpath="(//body[@id='tinymce'])[1]")
	private WebElement PropertiesDescText;
	
	public void sendPropertyDesc(String Description) {
		this.PropertiesDescText.clear(); 
		this.PropertiesDescText.sendKeys(Description); 
		driver.switchTo().defaultContent();
	}
	
	@FindBy(id="_price")
	private WebElement PriceBox; 
	
	public void EnterPrice(String Price) {
		this.PriceBox.clear(); 
		this.PriceBox.sendKeys(Price); 
	}
	
	@FindBy(id="_price_per")
	private WebElement PricePerSqFtBox; 
	
	public void EnterPricePerSqFt(String PPSqft) {
		this.PricePerSqFtBox.clear(); 
		this.PricePerSqFtBox.sendKeys(PPSqft); 
	}
		
	@FindBy(xpath="//a[contains(text(),'Main Details')]")
	private WebElement MainDetailsTabLink;
	
	public void ClickMainDetailsLink() {
		this.MainDetailsTabLink.click();
	}
		
	@FindBy(id="_status")
	private WebElement StatusTextBox; 
	
	public void EnterStatus(String Status) {
		this.StatusTextBox.sendKeys(Status); 
	}
	
	@FindBy(id="_location")
	private WebElement LocationTextBox; 
	
	public void EnterLocation(String Location) {
		this.LocationTextBox.sendKeys(Location); 
	}

	@FindBy(id="_possession")
	private WebElement PossessionTextBox; 
	
	public void EnterPossession(String Possession) {
		this.PossessionTextBox.sendKeys(Possession); 
	}
	
	@FindBy(xpath="//a[contains(text(),'Location')]")
	private WebElement LocationTabLink;
	
	public void ClickLocationTab() {
		this.LocationTabLink.click();
	}
		
	@FindBy(id="_friendly_address")
	private WebElement AddressTextBox; 
	
	public void EnterAddress(String Address) {
		this.AddressTextBox.sendKeys(Address); 
	}
	
	@FindBy(id="_address")
	private WebElement GoogleAddressMapTextBox; 
	
	public void EnterGoogleMapAddress(String GooMapAddress) {
		this.GoogleAddressMapTextBox.sendKeys(GooMapAddress); 
	}
	
	@FindBy(id="_geolocation_lat")
	private WebElement LatitudeTextBox; 
	
	public void EnterLatitude(String Latitude) {
		this.LatitudeTextBox.sendKeys(Latitude); 
	}
	
	@FindBy(id="_geolocation_long")
	private WebElement LongitudeTextBox; 
	
	public void EnterLongitude(String Longitude) {
		this.LongitudeTextBox.sendKeys(Longitude); 
	}
	
	@FindBy(xpath="//a[text()='Details']")
	private WebElement DetailsTabLink;
	
	public void ClickDetailsTab() {
		this.DetailsTabLink.click();
	}
	
	@FindBy(id="_storage_room")
	private WebElement StorageRoomTextBox; 
	
	public void EnterStorageRoom(String StorageBox) {
		this.StorageRoomTextBox.sendKeys(StorageBox);
	}
	
	@FindBy(xpath="(//span[text()='Central Bangalore'])[1]")
	private WebElement KeywordCheckBox;
	
	public void SelectKeywordCheckBox() throws AWTException, InterruptedException {
		Robot robot = new Robot(); 
		robot.keyPress(KeyEvent.VK_PAGE_DOWN); 
		robot.keyPress(KeyEvent.VK_PAGE_DOWN); 
		Thread.sleep(4000);
		this.KeywordCheckBox.click();
		robot.keyPress(KeyEvent.VK_PAGE_UP); 
		robot.keyPress(KeyEvent.VK_PAGE_UP); 
		
	}
	
	@FindBy(id="in-property_feature-431")
	private WebElement FeaturesCheckBox;
	
	public void SelectFeaturesCheckBox() {
		this.FeaturesCheckBox.click();
	}
		
	@FindBy(xpath="(//li//label[text()=' Central Bangalore'])[1]")
	private WebElement RegionsCheckBox;
	
	public void SelectRegionsCheckBox() {
		this.RegionsCheckBox.click();
	}
	
	@FindBy(id="publish")
	private WebElement PublishButton;
	
	public void ClickPublishButton() {
		this.PublishButton.click();
	}
	
	@FindBy(xpath="//p[contains(text(),'Post published. ')]")
	private WebElement VerifyAddedPropertyConf;
	
	public void AssertAddedPropertyVerification() {
		System.out.println(this.VerifyAddedPropertyConf.getText());
		//String actualTag= this.VerifyAddedPropertyConf.getText();
		this.VerifyAddedPropertyConf.isDisplayed();
		//String expectedTag=("Post published. ");
		//Assert.assertTrue(actualTag.contains(expectedTag));
	}
	
	@FindBy(xpath="//img[@class='avatar avatar-26 photo']")
	private WebElement UserLogInImg;
	
	@FindBy(xpath="//li[@id='wp-admin-bar-logout']")
	private WebElement LogOutButtonClick;
	
	public void MouseOverLogOutButtonClick() throws InterruptedException {
		Actions act = new Actions(driver); 
		act.moveToElement(UserLogInImg).build().perform();
		Thread.sleep(3500);
		act.moveToElement(LogOutButtonClick).click().build().perform(); 		
	}
		
	@FindBy(xpath="//a[text()='Real Estate']")
	private WebElement RealEstateLink;
	
	public void ClickRealEstateLink() {
		this.RealEstateLink.click();
	}
	
	@FindBy(xpath="(//input[@name='phrase'])[1]")
	private WebElement RealEstateSearchTextBox;
	
	public void SendRealEstateSearch(String SrchRealEst) {
		this.RealEstateSearchTextBox.sendKeys(SrchRealEst); 
		}
	
	//@FindBy(xpath="//tbody[@id='the-list'][1]//a[@class='row-title']")
	@FindBy(xpath="//a[@class='asl_res_url']")
	private WebElement PropertyList;
	
	public void AssertPropertyVerification() {
		String expectedProperty=this.RealEstateSearchTextBox.getAttribute("value");
		String actualProperty = this.PropertyList.getText();
		System.out.println("Expected Property: "+expectedProperty);
		System.out.println("Actual Property: "+actualProperty);
		Assert.assertEquals(actualProperty,expectedProperty);
	}
}