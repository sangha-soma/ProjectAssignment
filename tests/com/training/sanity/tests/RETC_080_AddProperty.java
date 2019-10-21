package com.training.sanity.tests;

import java.awt.AWTException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RETC_080_AddPropertyPOM;

public class RETC_080_AddProperty extends LoginTests {
	
	private RETC_080_AddPropertyPOM AddPropertyTest;
	private ScreenShot screenShot;
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
  @Test(priority=1)
  public void addProperty() throws AWTException, InterruptedException {
	  AddPropertyTest= new RETC_080_AddPropertyPOM(driver);
	  AddPropertyTest.ClickPropertiesLink();
	  AddPropertyTest.ClickAddNewPropertiesLink();
	  AddPropertyTest.sendPropertyTitle("new launch");
	  AddPropertyTest.sendPropertyDesc("new launch");
	  AddPropertyTest.EnterPrice("50000");
	  AddPropertyTest.EnterPricePerSqFt("200");
	  AddPropertyTest.ClickMainDetailsLink();
	  AddPropertyTest.EnterStatus("New");
	  AddPropertyTest.EnterLocation("Electronic city");
	  AddPropertyTest.EnterPossession("immediate");
	  AddPropertyTest.ClickLocationTab();
	  AddPropertyTest.EnterAddress("yeshwanthapur");
	  AddPropertyTest.EnterGoogleMapAddress("yeshwanthapur");
	  AddPropertyTest.EnterLatitude("120");
	  AddPropertyTest.EnterLongitude("56");
	  AddPropertyTest.ClickDetailsTab();
	  AddPropertyTest.EnterStorageRoom("2");
	  AddPropertyTest.SelectKeywordCheckBox();
	  AddPropertyTest.SelectFeaturesCheckBox();
	  AddPropertyTest.SelectRegionsCheckBox();
	  AddPropertyTest.ClickPublishButton();
	  AddPropertyTest.AssertAddedPropertyVerification();
	  AddPropertyTest.MouseOverLogOutButtonClick();
	  AddPropertyTest.ClickRealEstateLink();
	  AddPropertyTest.SendRealEstateSearch("new launch");
	  AddPropertyTest.AssertPropertyVerification();
	  screenShot.captureScreenShot("Ninth");
  }
}
