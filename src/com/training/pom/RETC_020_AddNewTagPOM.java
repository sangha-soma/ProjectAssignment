package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RETC_020_AddNewTagPOM {
	private WebDriver driver;
	
	public RETC_020_AddNewTagPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[text()='Posts']")
	private WebElement PostsLink; 
	
	public void ClickPostsLink() {
		this.PostsLink.click();
	}
	
	@FindBy(xpath="(//a[text()='Tags'])[1]")
	private WebElement TagsLink; 
	
	public void ClickTagsLink() {
		this.TagsLink.click();
	}
	
	@FindBy(id="tag-name")
	private WebElement NameTextBox;
	
	public void SendNameText() {
		this.NameTextBox.sendKeys("yyyy");
	}
	
	@FindBy(id="tag-slug")
	private WebElement SlugTextBox;
	
	public void SendSlugText() {
		this.SlugTextBox.sendKeys("launch");
	}
	
	@FindBy(id="tag-description")
	private WebElement DescTextBox;
	
	public void SendDescriptionText() {
		this.DescTextBox.sendKeys("New Launches of vilas, apartments, flats");
	}
	
	@FindBy(id="submit")
	private WebElement AddTagButn;
	
	public void ClickAddTagButton() {
		this.AddTagButn.click();
	}
	
	@FindBy(id="tag-search-input")
	private WebElement SearchTextBox;
	
	@FindBy(id="search-submit")
	private WebElement SearchTagButton;
	
	@FindBy(xpath="//tbody[@id='the-list'][1]//a[@class='row-title']")
	private WebElement Taglist;
	
	public void AssertTagVerification() {
		String expectedTag=this.NameTextBox.getAttribute("value");
		this.SearchTextBox.sendKeys(expectedTag);
		this.SearchTagButton.click();
		String actualTag = this.Taglist.getText();
		System.out.println("Expected Tag: "+expectedTag);
		System.out.println("Actual Tag: "+actualTag);
		Assert.assertEquals(actualTag,expectedTag);
	}
}
