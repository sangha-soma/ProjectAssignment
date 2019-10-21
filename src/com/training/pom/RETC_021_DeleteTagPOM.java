package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RETC_021_DeleteTagPOM {
private WebDriver driver;
	
	public RETC_021_DeleteTagPOM(WebDriver driver) {
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
	
	@FindBy(id="tag-search-input")
	private WebElement SearchTextBox;
	
	@FindBy(id="search-submit")
	private WebElement SearchTagButton;
	
	@FindBy(xpath="//input[@name='delete_tags[]'][1]")
	private WebElement SelectDeleteTag;
	
	public void SelectTagDelete() {
		String Tag=this.NameTextBox.getAttribute("value");
		this.SearchTextBox.sendKeys(Tag);
		this.SearchTagButton.click();
		this.SelectDeleteTag.click();
	}
	
	@FindBy(id="bulk-action-selector-top")
	private WebElement BulkActionsList;
	
	public void ClickBulkActionsDrop() {
		this.BulkActionsList.click();
		Select sel= new Select(this.BulkActionsList);
		sel.selectByValue("delete");
	}
	
	@FindBy(id="doaction")
	private WebElement ApplyButton;
	
	public void ClickApplyButton() {
		this.ApplyButton.click();
	}
	
	@FindBy(id="message")
	private WebElement GetDelMsg;

	public void GetDelConfMsg() {
		String expectedmsg=("Tags deleted.");
		String actualmsg= GetDelMsg.getText();
		System.out.println(actualmsg);
		System.out.println(expectedmsg);
		Assert.assertTrue(actualmsg.contains(expectedmsg));
		//Assert.assertEquals(actualmsg,expectedmsg);
	}

}

