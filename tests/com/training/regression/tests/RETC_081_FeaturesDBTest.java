package com.training.regression.tests;

import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.RETC_081_AddMultipleNewFeaturePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class RETC_081_FeaturesDBTest {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	public RETC_081_AddMultipleNewFeaturePOM AddNewFeatureTest;
	private static Properties properties;
	private ScreenShot screenShot;
	private GenericMethods genericMethods; 
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}
	
    @BeforeMethod
    public void setUp() throws Exception {
	  driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		loginPOM = new LoginPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		genericMethods = new GenericMethods(driver); 
		// open the browser
		driver.get(baseUrl);
  }

  @AfterMethod
  public void tearDown() throws Exception {
	  Thread.sleep(1000);
		driver.quit();
  }

@Test(dataProvider = "db-inputs", dataProviderClass = LoginDataProviders.class)
public void featuresDBTest(String Name, String Slug, String Parent_Feature, String Description ) {
	AddNewFeatureTest.ClickPropertiesLink();
	AddNewFeatureTest.ClickFeaturesLink();
	AddNewFeatureTest.AddedFeatureSearch(Name);
}

}