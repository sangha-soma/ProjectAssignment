package com.training.regression.tests;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.RETC_079_AddNewFeaturePOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_079_AddFeatureExcelTest {
	private WebDriver driver;
	private String adminUrl;
	private LoginPOM loginPOM;
	private RETC_079_AddNewFeaturePOM AddNewFeatureTest;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		loginPOM = new LoginPOM(driver);
		AddNewFeatureTest = new RETC_079_AddNewFeaturePOM(driver);
		adminUrl = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(adminUrl);
	}

	/*
	 * @BeforeMethod public void setUp() throws Exception { driver =
	 * DriverFactory.getDriver(DriverNames.CHROME); loginPOM = new LoginPOM(driver);
	 * AddNewFeatureTest = new AddNewFeaturePOM(driver); adminUrl =
	 * properties.getProperty("adminURL"); screenShot = new ScreenShot(driver); //
	 * open the browser driver.get(adminUrl); }
	 */
	
	  @AfterMethod public void tearDown() throws Exception { 
		  driver.quit(); 
		  }
	 	
	@Test(priority=0)
	  public void adminLogin() {
		  	loginPOM.ClickLogInLink();
			loginPOM.sendUserName("manipal");
			loginPOM.sendPassword("manipal@123");
			loginPOM.clickSigninBtn(); 
			AddNewFeatureTest.ClickPropertiesLink();
			AddNewFeatureTest.ClickFeaturesLink();
			
			screenShot.captureScreenShot("First");
	  }
	
	@Test(dataProvider = "excel-inputs", dataProviderClass = LoginDataProviders.class,priority=1)
	public void loginDBTest(String Name, String Slug, String ParentFeature, String Description) throws InterruptedException, AWTException {
		AddNewFeatureTest.SendNameText(Name);
		AddNewFeatureTest.SendSlugText(Slug);
		AddNewFeatureTest.SelectParentFeature(ParentFeature);
		AddNewFeatureTest.SendDescriptionText(Description);
		AddNewFeatureTest.ClickAddFeatureButton();
		Thread.sleep(2000);
		AddNewFeatureTest.AddedFeatureSearch(Name);
		Thread.sleep(3000);
		AddNewFeatureTest.AssertPropertyVerification();
		screenShot.captureScreenShot(Name);
	}

}