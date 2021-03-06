package com.training.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RETC_050_RestorePropertyPOM {
private WebDriver driver; 
	
	public RETC_050_RestorePropertyPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[text()='Properties']")
	private WebElement PropertiesLink; 
	
	public void ClickPropertiesLink() {
			this.PropertiesLink.click();
	}
	
	@FindBy(xpath="(//a[text()='All Properties'])[1]")
	private WebElement AllPropertiesLink;
	
	public void ClickAllPropertiesLink() {
			this.AllPropertiesLink.click();
	}
	
	@FindBy(xpath="(//a[text()='Trash '])")
	private WebElement PropertyTrashTab;
	
	public void ClickTrashTab() {
			this.PropertyTrashTab.click();
	}
		
	@FindBy(xpath="//tbody[@id='the-list']/tr[1]/td[1]")
	private WebElement MouseOpTrashProperty;

	@FindBy(xpath="(//div//span//a[text()='Restore'])[1]")
	private WebElement RestoreLink;

	public void MouseOverTrashPropertyLink() throws InterruptedException {
		
		WebElement TrashpropertyTitle=this.MouseOpTrashProperty;
		Actions act= new Actions(driver);
	    act.moveToElement(TrashpropertyTitle).build().perform();
	    Thread.sleep(3000);
	    this.RestoreLink.click();
	    }
	
	@FindBy(xpath="//div[@id='message']")
	private WebElement VerifyRestoreConf;
	
	public void AssertRestorePropertyVerification() {
		
		String actualTag= this.VerifyRestoreConf.getText();
		this.VerifyRestoreConf.isDisplayed();
		String expectedTag=("1 post restored from the Trash.");
		Assert.assertTrue(actualTag.contains(expectedTag));
	}
	
	public void OpenPropertyInNewWindow() throws AWTException, InterruptedException {
		Actions act=new Actions(driver);
		act.contextClick(PropertiesLink).build().perform();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		ArrayList <String> windows = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(1));
		//System.out.println("current window is " +driver.getTitle());
		}

	@FindBy(id="post-search-input")
	private WebElement PropertySearch;
	
	@FindBy(id="search-submit")
	private WebElement SearchPropertyBtn;
	
	public void RestoredPropertySearch() {
		this.PropertySearch.sendKeys("PRESTIGE");
		this.SearchPropertyBtn.click();
		}
	
	@FindBy(xpath="//tbody[@id='the-list'][1]//a[@class='row-title']")
	private WebElement Taglist;
	
	public void AssertPropertyVerification() {
		String expectedTag=this.PropertySearch.getAttribute("value");
		String actualTag = this.Taglist.getText();
		System.out.println("Expected Tag: "+expectedTag);
		System.out.println("Actual Tag: "+actualTag);
		Assert.assertEquals(actualTag,expectedTag);
	}
	
}

	
	
		
	
	

	
