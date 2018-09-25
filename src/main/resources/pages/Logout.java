package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dataprovider.ConfigFileReader;

public class Logout {

	@FindBy(xpath="//table[@class='tbl_info_blue']//*[text()=' Login again ']")
	WebElement Login_again;
	
	@FindBy(xpath="//table[@class='tbl_info_blue']//*[text()=' Go to Standard Chartered India ']")
	WebElement goto_SC_india;
	
	@FindBy(xpath ="//table[@class='tbl_info_blue']//*[text()=' Email us for further assistance ']")
	WebElement goto_email;
	
	@FindBy(xpath ="//table[@class='tbl_info_blue']//*[text()=' Contact our Phone Banking ']")
	WebElement phone_banking;
	
	@FindBy(xpath ="//table[@class='tbl_form']//input[@name='j_username']")
	WebElement username;
	
	WebDriver driver ;
	public Logout(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
		this.driver = driver;	
	}
	
	public boolean LoginAgain() throws InterruptedException {
		Login_again.click();
		ConfigFileReader config = new ConfigFileReader();
		WebDriverWait validate = new WebDriverWait(driver, config.getImplicitWait());
		validate.until(ExpectedConditions.visibilityOf(username));
		
		return true;
	}
	
	public boolean goto_SC_india() throws InterruptedException {
		goto_SC_india.click();
		return true;
	}
	
	public boolean goto_email() throws InterruptedException {
		goto_email.click();
		return true;
	}
	public boolean phone_banking() throws InterruptedException {
		phone_banking.click();
		return true;
	}
	
}
