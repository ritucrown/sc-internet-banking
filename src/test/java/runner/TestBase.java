package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import dataprovider.ConfigFileReader;

public class TestBase {

	public static WebDriver driver;
	ConfigFileReader config;
	public WebDriver getFirefoxDriver() {
		return driver = new FirefoxDriver();
	}
	public void openURL(String url) {
		driver.get(url);
	}
	public WebDriver getChromeDriver() {
		System.getProperty(config.getChrome(),config.getDriverPath());
		driver = new ChromeDriver();
		return driver;
	}
	public void getConfigReader() {
		config = new ConfigFileReader();
	}
}
