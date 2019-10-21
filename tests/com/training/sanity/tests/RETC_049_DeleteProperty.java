package com.training.sanity.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RETC_049_DeletePropertyPOM;

public class RETC_049_DeleteProperty extends LoginTests {
	
	private RETC_049_DeletePropertyPOM DeletePropertytest;
	private ScreenShot screenShot;
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
  @Test(priority=1)
  public void DeletePropertyTrash() throws InterruptedException {
	  screenShot = new ScreenShot(driver);
	  DeletePropertytest = new RETC_049_DeletePropertyPOM(driver);
	  DeletePropertytest.ClickPropertiesLink();
	  DeletePropertytest.ClickAllPropertiesLink();
	  DeletePropertytest.MouseOverPropertyLink();
	  DeletePropertytest.ClickTrashTab();
	  DeletePropertytest.MouseOverTrashPropertyLink();
	  DeletePropertytest.AssertDelPropertyVerification();
	  screenShot.captureScreenShot("Fifth");
  }
}
