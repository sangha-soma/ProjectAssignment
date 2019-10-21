package com.training.sanity.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import com.training.generics.ScreenShot;
import com.training.pom.RETC_020_AddNewTagPOM;

public class RETC_020_AddNewTag extends LoginTests {
	
	private RETC_020_AddNewTagPOM AddNewTagtest;
	public ScreenShot screenShot;
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
  
  @Test(priority=2)
	public void SelectAddNewTags() throws InterruptedException {
	  	screenShot = new ScreenShot(driver);
		AddNewTagtest = new RETC_020_AddNewTagPOM(driver);
		AddNewTagtest.ClickPostsLink();
		AddNewTagtest.ClickTagsLink();
		AddNewTagtest.SendNameText();
		AddNewTagtest.SendSlugText();
		AddNewTagtest.SendDescriptionText();
		AddNewTagtest.ClickAddTagButton();
		AddNewTagtest.AssertTagVerification();
		screenShot.captureScreenShot("Third");
		  }
  }

