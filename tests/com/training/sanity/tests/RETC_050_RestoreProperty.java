package com.training.sanity.tests;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import com.training.generics.ScreenShot;
import com.training.pom.RETC_050_RestorePropertyPOM;

public class RETC_050_RestoreProperty extends LoginTests {
	
	private RETC_050_RestorePropertyPOM RestorePropertytest;
	private ScreenShot screenShot;
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test(priority=1)
	  public void RestorePropertyTrash() throws InterruptedException, AWTException {
		  screenShot = new ScreenShot(driver);
		  RestorePropertytest = new RETC_050_RestorePropertyPOM(driver);
		  RestorePropertytest.ClickPropertiesLink();
		  RestorePropertytest.ClickAllPropertiesLink();
		  RestorePropertytest.ClickTrashTab();
		  RestorePropertytest.MouseOverTrashPropertyLink();
		  RestorePropertytest.AssertRestorePropertyVerification();
		  RestorePropertytest.OpenPropertyInNewWindow();
		  RestorePropertytest.RestoredPropertySearch();
		  RestorePropertytest.AssertPropertyVerification();
		  screenShot.captureScreenShot("Sixth");
		  
	  }
}

