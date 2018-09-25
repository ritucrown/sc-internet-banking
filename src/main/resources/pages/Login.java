package pages;

import org.eclipse.jetty.util.log.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
	WebDriver driver;
	
	WebElement j_username;
	WebElement j_password;
	WebElement Login;
	WebElement Logout;
	@FindBy(xpath = "//*[text()=' Welcome PALIMKAR RITESH TREMBAKRAO. ']")
	WebElement heading;
	
	public Login(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void setUser(String strUser) {
		j_username.sendKeys(strUser);
	}
	public void setPassword(String strPassword) {
		j_password.sendKeys(strPassword);
	}
	
	public boolean submit() {
		Login.click();
		WebDriverWait loginWait = new WebDriverWait(driver, 10);
		loginWait.until(ExpectedConditions.visibilityOf(heading));
		return true;
	}
	
	public void Logout() {
		Logout.click();
	}
}
