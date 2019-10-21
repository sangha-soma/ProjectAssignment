package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RETC_049_DeletePropertyPOM {
private WebDriver driver; 
	
	public RETC_049_DeletePropertyPOM(WebDriver driver) {
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
	
	@FindBy(id="post-search-input")
	private WebElement SearchTextBox;
	
	@FindBy(id="search-submit")
	private WebElement SearchTagButton;

	@FindBy(xpath="(//a[@class='row-title'])[1]")
	private WebElement MouseOpProperty;

	@FindBy(xpath="(//a[text()='Trash'])[1]")
	private WebElement IndvPropertyTrash;
	
	public void MouseOverPropertyLink() throws InterruptedException {
		this.SearchTextBox.sendKeys("Prestige");
		this.SearchTagButton.click();
		WebElement propertyTitle=this.MouseOpProperty;
		Actions act= new Actions(driver);
	    act.moveToElement(propertyTitle).build().perform();
	    Thread.sleep(3000);
	    this.IndvPropertyTrash.click();
	    }
	
	@FindBy(xpath="(//a[text()='Trash '])")
	private WebElement PropertyTrashTab;
	
	public void ClickTrashTab() {
		this.PropertyTrashTab.click();
	}
	
	@FindBy(xpath="//tbody[@id='the-list']/tr[1]/td[1]")
	private WebElement MouseOpTrashProperty;

	@FindBy(xpath="(//a[@class='submitdelete'])[1]")
	//@FindBy(xpath="(//div//span//a[text()='Delete Permanently'])[1]")
	private WebElement DeletePermanentlyLink;
	
	public void MouseOverTrashPropertyLink() throws InterruptedException {
		WebElement TrashpropertyTitle=this.MouseOpTrashProperty;
		Actions act= new Actions(driver);
	    act.moveToElement(TrashpropertyTitle).build().perform();
	    Thread.sleep(3000);
	    this.DeletePermanentlyLink.click();
	    }
		
	@FindBy(xpath="//div[@id='message']")
	private WebElement VerifyDeleteConf;
		
	public void AssertDelPropertyVerification() {
		System.out.println(this.VerifyDeleteConf.getText());
		String actualTag= this.VerifyDeleteConf.getText();
		this.VerifyDeleteConf.isDisplayed();
		String expectedTag=("1 post permanently deleted.");
		Assert.assertTrue(actualTag.contains(expectedTag));
	}
}
