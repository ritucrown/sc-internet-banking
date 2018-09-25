package runner;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.eclipse.jetty.util.log.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pages.Login;
import utility.ExcelReader;
import dataprovider.ConfigFileReader;

public class TestLogin extends ConfigFileReader {
	
	WebDriver driver;
	ExcelReader readExcel;
	ExtentReports reports;
	ExtentTest logger;
	boolean loginStatus = false;
	
  @Test(enabled = true, dataProvider = "LoginDataExcel")
  public void TestLogin(Object strUsername, Object strPassword) {
	  logger = reports.startTest("TestLogin");
	  Login login = new Login(driver);
	  login.setUser(strUsername.toString());
	  login.setPassword(strPassword.toString());
	  loginStatus=login.submit();
	  assertTrue(loginStatus);;
	  assertTrue(true, "Login Successful");
	  logger.log(LogStatus.PASS, "Login Successful");
	  driver.manage().timeouts().implicitlyWait(getImplicitWait(), TimeUnit.SECONDS);
	  
  }
  @Test(enabled = true)
  public void test1() throws IOException{
	 readExcel= new ExcelReader();
	 List<String> readData = readExcel.readExcel("DataSheet.xlsx", "AddPayee");
	 logger = reports.startTest("test1");
	 assertNotEquals(readData.size(), 0);
	 logger.log(LogStatus.PASS, "Data is read from excel file successfully");
  }
  @Test
  public void titleValidation(){
	  String title = driver.getTitle();
	  logger = reports.startTest("titleValidation");
	  Assert.assertTrue(title.contains("Standard Charted"));
	  logger.log(LogStatus.PASS, "Test for Title Validation is successful");
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  driver.get(getLoginUrl());
  }

  @AfterMethod
  public void afterMethod(ITestResult result) {
	  Login login = new Login(driver);
	 
	  if (result.getStatus() == ITestResult.FAILURE) {
		logger.log(LogStatus.FAIL, result.getName()+" Test is failed");
		logger.log(LogStatus.ERROR, "Test Failed on "+result.getHost());
		logger.log(LogStatus.FAIL, "Test failed is "+result.getThrowable());
		
	}else if (result.getStatus() == ITestResult.SKIP){
		logger.log(LogStatus.SKIP, "Test "+result.getName()+" is skipped");
	}
	  
	  reports.endTest(logger);
	 if (loginStatus) {
		 login.Logout();
	}

  }


  @DataProvider
  public String[][] LoginData() {
	  
    return new String[][] {{"ritesh0107","nayan0107"}};
  }
  @BeforeTest
  public void beforeTest() {
	 reports = new ExtentReports(System.getProperty("user.dir")+"\\Report\\result.html",true);
	 reports.addSystemInfo("Host Name","www.SCinternetbanking.co.in")
	 		.addSystemInfo("Environment","Testing Environment");

	 reports.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	  
	  System.setProperty(getChrome(),getDriverPath());
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	  reports.flush();
	  reports.close();
	  driver.close();
	  driver.quit();
  }

  @DataProvider
  public Object[][] LoginDataExcel() throws IOException{
	  Object[][] tblExcelData = ExcelReader.tblExcelData("DataSheet.xlsx", "Login");
	  System.out.println(tblExcelData[0][0]);
	  return tblExcelData;
  }
}
