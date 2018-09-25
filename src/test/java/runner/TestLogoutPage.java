package runner;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import pages.Logout;
import dataprovider.ConfigFileReader;

public class TestLogoutPage {
	WebDriver driver;
	ConfigFileReader config;
	Logout logoutPage;
	//Test Case to check Login again link present on the logout page
@Test(enabled=true)
  public void TestLoginAgain() throws InterruptedException {
	  logoutPage = new Logout(driver);
	  logoutPage.LoginAgain();
	  driver.manage().timeouts().implicitlyWait(config.getImplicitWait(), TimeUnit.SECONDS);
  }

@Test
	public void TestSCIndia() throws InterruptedException {
		// TODO Auto-generated method stub
	  logoutPage = new Logout(driver);
	  logoutPage.goto_SC_india();
	  driver.manage().timeouts().implicitlyWait(config.getImplicitWait(), TimeUnit.SECONDS);
  
	}
@Test
public void TestPhoneBanking() throws InterruptedException {
	// TODO Auto-generated method stub
  logoutPage = new Logout(driver);
  logoutPage.phone_banking();
  driver.manage().timeouts().implicitlyWait(config.getImplicitWait(), TimeUnit.SECONDS);
}
@Test
public void TestEmail() throws InterruptedException {
	// TODO Auto-generated method stub
  logoutPage = new Logout(driver);
  logoutPage.goto_email();
  driver.manage().timeouts().implicitlyWait(config.getImplicitWait(), TimeUnit.SECONDS);

}
  @BeforeMethod
  public void beforeMethod() {
	  config = new ConfigFileReader();
	  driver.get(config.getLogoutUrl());
  }

  @AfterMethod
  public void afterMethod() {
	  
  }

  @BeforeTest
  public void beforeTest() {
	  driver = new FirefoxDriver();
	  
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
