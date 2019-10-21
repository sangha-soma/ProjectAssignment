package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RETC_019_DeleteCategoryPOM {
private WebDriver driver; 
	
	public RETC_019_DeleteCategoryPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[text()='Posts']")
	private WebElement PostsLink; 
	
	public void ClickPostsLink() {
		this.PostsLink.click();
	}
	
	@FindBy(xpath="(//a[text()='Categories'])[1]")
	private WebElement CategoryLink;
	
	public void ClickCategoryLink() {
		this.CategoryLink.click();
	}

	@FindBy(xpath="//input[@name='delete_tags[]'][1]")
	private WebElement SelectCategory;
	
	public void SelectCategoryDelete() {
		this.SelectCategory.click();
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
		String actualmsg= GetDelMsg.getText();
		System.out.println(actualmsg);
		String expectedmsg=("Categories deleted.");
		Assert.assertTrue(actualmsg.contains(expectedmsg));
	}
}
