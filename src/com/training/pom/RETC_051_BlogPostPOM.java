package com.training.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RETC_051_BlogPostPOM {
private WebDriver driver; 
	
	public RETC_051_BlogPostPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
}
	@FindBy(xpath="(//a[text()='Blog'])[1]")
	//@FindBy(linkText="Blog")
	private WebElement BlogLink;
	
	public void ClickBlogLink() throws AWTException, InterruptedException {
		this.BlogLink.click();
		Robot robot = new Robot(); 
	    robot.keyPress(KeyEvent.VK_PAGE_DOWN); 
	    Thread.sleep(3000);
	    robot.keyPress(KeyEvent.VK_PAGE_DOWN); 
	    Thread.sleep(3000);
	}

	@FindBy(xpath="(//a[@class='read-more'])[2]")
	private WebElement ReadMoreLink;
		
	public void ClickReadMoreLink() {
		this.ReadMoreLink.click();
	}
	
	@FindBy(name="comment")
	private WebElement PostComment;
	
	public void SendPostComment() throws InterruptedException, AWTException {
		Robot robot = new Robot(); 
	    robot.keyPress(KeyEvent.VK_PAGE_DOWN); 
	    Thread.sleep(3000);
	    robot.keyPress(KeyEvent.VK_PAGE_DOWN); 
	    Thread.sleep(3000);
		this.PostComment.sendKeys("Beautiful");
		Thread.sleep(3000);
	}
	
	
	@FindBy(id="author")
	private WebElement AddName;
	
	public void EnterNameTextBox() {
		this.AddName.sendKeys("ManipalTesting");
	}
	
	@FindBy(id="email")
	private WebElement AddEmail;
	
	public void EnterEmailTextBox() {
		this.AddEmail.sendKeys("ManipalTesting@gmail.com");
	}
	
	@FindBy(id="submit")
	private WebElement SubmitPost;
		
	public void SubmitBlogPost() {
		this.SubmitPost.click();
		}
	
	@FindBy(xpath="//div[text()='Dashboard']")
	private WebElement DashboardLink; 
	
	public void ClickDashboardLink() {
		this.DashboardLink.click();
	}
	
	@FindBy(xpath="//ul[@id='the-comment-list']/li[1]")
	private WebElement MouseOpRecentComments;

	@FindBy(xpath="(//a[text()='Reply'])[1]")
	private WebElement ReplyRecentCommentsLink;
	
	public void MouseOverRecentComment() throws InterruptedException {
		WebElement RecentCommentTitle=this.MouseOpRecentComments;
		Actions act= new Actions(driver);
	    act.moveToElement(RecentCommentTitle).build().perform();
	    Thread.sleep(3000);
	    this.ReplyRecentCommentsLink.click();
	}
		
	@FindBy(id="replycontent")
	private WebElement SubmitReplyToComment;
	
	public void SendReplyCommentText() {
		this.SubmitReplyToComment.sendKeys("Thank You!");
		//String expectedCommentReply = this.SubmitReplyToComment.getAttribute("value");
		//System.out.println("Expected Comment: "+expectedCommentReply);
		}
	
	@FindBy(id="replybtn")
	private WebElement SubmitComment;
	
	public void ClickReplyButton() {
		this.SubmitComment.click();
	}
	
	
	@FindBy(xpath="(//div[@class=\"dashboard-comment-wrap has-row-actions\"])[1]")
	private WebElement VerifyComment;
			
	public void AssertReplyVerification() throws InterruptedException {
		String actualCommentReply= this.VerifyComment.getText();
		System.out.println("Actual Comment: "+actualCommentReply);
		String expectedCommentReply=("Thank You");
		Assert.assertTrue(actualCommentReply.contains(expectedCommentReply));
	}
}
