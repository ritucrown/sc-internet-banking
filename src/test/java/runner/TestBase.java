package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import dataprovider.ConfigFileReader;

public class TestBase {

	private static WebDriver driver;
	ConfigFileReader config = new ConfigFileReader();
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
}
