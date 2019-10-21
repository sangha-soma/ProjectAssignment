package com.training.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.sun.glass.events.KeyEvent;

public class RETC_079_AddNewFeaturePOM {
private WebDriver driver; 
	
	public RETC_079_AddNewFeaturePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[text()='Properties']")
	private WebElement PropertiesLink; 
	
	public void ClickPropertiesLink() {
		this.PropertiesLink.click();
	}
	
	@FindBy(xpath="//a[text()='Features']")
	private WebElement FeaturesLink;
	
	public void ClickFeaturesLink() {
		this.FeaturesLink.click();
	}
	
	@FindBy(id="tag-name")
	private WebElement NameTextBox;
	
	public void SendNameText(String Name) {
		this.NameTextBox.clear();
		this.NameTextBox.sendKeys(Name);
	}
	
	@FindBy(id="tag-slug")
	private WebElement SlugTextBox;
	
	public void SendSlugText(String Slug) {
		this.SlugTextBox.clear();
		this.SlugTextBox.sendKeys(Slug);
		Actions act= new Actions(driver);
		act.sendKeys(Keys.TAB).perform();
	}
	
	@FindBy(id="parent")
	private WebElement ParentFeatureDropDown;
	
	public void SelectParentFeature(String ParentFeature) throws InterruptedException {
		WebElement ParentFeaturelist= this.ParentFeatureDropDown;
		Select ParentFeatureValue=new Select(ParentFeaturelist);
		Thread.sleep(3000);
		//List <WebElement> ParentFeaturelistValue= ParentFeatureValue.getOptions();
		//System.out.println(ParentFeaturelistValue);
		ParentFeatureValue.selectByVisibleText(ParentFeature);
		ParentFeaturelist.isSelected();
	}
	
	@FindBy(id="tag-description")
	private WebElement DescTextBox;
	
	public void SendDescriptionText(String Description) {
		this.DescTextBox.clear();
		this.DescTextBox.sendKeys(Description);
	}
	
	@FindBy(id="submit")
	private WebElement AddNewFeatureButn;
	
	public void ClickAddFeatureButton() throws AWTException, InterruptedException {
		this.AddNewFeatureButn.click();
		Robot robot = new Robot(); 
	    robot.keyPress(KeyEvent.VK_PAGE_UP);
	    robot.keyPress(KeyEvent.VK_ENTER);
	    Thread.sleep(3000);
	      
	}
	
	@FindBy(id="tag-search-input")
	private WebElement FeatureSearchText;
	
	@FindBy(id="search-submit")
	private WebElement FeatureSearchBtn;
	
	public void AddedFeatureSearch(String Name) {
		this.FeatureSearchText.clear();
		this.FeatureSearchText.sendKeys(Name);
		this.FeatureSearchBtn.click();
		}
		
	@FindBy(xpath="//tbody[@id='the-list'][1]//a[@class='row-title']")
	private WebElement FeatureList;
	
	public void AssertPropertyVerification() {
		String expectedFeature=this.FeatureSearchText.getAttribute("value");
		String actualFeature = this.FeatureList.getText();
		System.out.println("Expected Feature: "+expectedFeature);
		System.out.println("Actual Feature: "+actualFeature);
		Assert.assertEquals(actualFeature,expectedFeature);
	}
	
}
