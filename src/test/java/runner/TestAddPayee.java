package runner;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import dataprovider.ConfigFileReader;
import pages.Home;
import pages.Login;
import pages.Logout;
import utility.ExcelReader;

public class TestAddPayee {
	
	Login login;
	Home home;
	Logout logout;
	ConfigFileReader config;
	WebDriver driver;
	
  @Test
  public void testAddPayee() {
	  home = new Home(driver);
	  home.addPayee();
	 	 
  }
 
  @Test(priority =0, dataProvider = "LoginDetail")
  public void login(String strUser, String strPass){
	  login = new Login(driver);
	  login.setUser(strUser);
	  login.setPassword(strPass);
	  login.submit();
	  
	 
  }
  @BeforeTest
  public void beforTest(){
	  config = new ConfigFileReader();
	  System.setProperty(config.getChrome(), config.getDriverPath());
		
	  driver = new ChromeDriver();
	  driver.get(config.getLoginUrl());
  }

  @DataProvider
  public String[][] LoginDetail(){
		  return new String[][] {{"ritesh0107","nayan0107"}};
  }
  
  @AfterTest
  public void afterTest() {
	 home.Logout();
  }

}
