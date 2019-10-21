package com.training.sanity.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import com.training.generics.ScreenShot;
import com.training.pom.RETC_021_DeleteTagPOM;

public class RETC_021_DeleteTag extends RETC_020_AddNewTag{
	
	private RETC_021_DeleteTagPOM DeleteTagtest;
	private ScreenShot screenShot;
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test(priority=3)
	public void TagDeletion() throws InterruptedException {
		screenShot = new ScreenShot(driver);
		DeleteTagtest = new RETC_021_DeleteTagPOM(driver);
		DeleteTagtest.SelectTagDelete();
		DeleteTagtest.ClickBulkActionsDrop();
		Thread.sleep(3000);
		DeleteTagtest.ClickApplyButton();
		DeleteTagtest.GetDelConfMsg();
		screenShot.captureScreenShot("Fourth");
		  }
}
