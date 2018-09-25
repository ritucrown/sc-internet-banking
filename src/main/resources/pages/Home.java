package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Home extends Login{

	@FindBy(xpath ="//*[text() = 'Transfers']")
	WebElement Transfer;
	@FindBy(xpath = "//table[@class = 'tbl_menutab']//*[@id ='tab_2']")
	WebElement Third_party_transfer;
	@FindBy(xpath = "//table[@class = 'tbl_form']//*[text() =' Add a new funds transfer payee ']")
	WebElement add_new_payee;
	
	@FindBy(xpath = "//input[@id ='payeeVO.payeeBankAccount']")
	WebElement AccNo;
	@FindBy(xpath = "//input[@id ='payeeVO.payeeBankAccountNumber']")
	WebElement confirmAccNo;
	
	@FindBy(xpath = "//select[@id ='payeeVO.payeeBankAccountType']")
	WebElement selAccType;
	@FindBy(xpath = "//select[@id ='payeeVO.payeeType']")
	WebElement selPayeeType;
	@FindBy(xpath = "//input[@id ='payeeVO.searchSelection1']")
	WebElement radioSearch;
	
	
	public Home(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	public void addPayee() {
		Transfer.click();
		Third_party_transfer.click();
		add_new_payee.click();
		setSelect(selAccType,"Interbank Account Transfer (IMPS/NEFT/RTGS)");
		AccNo.sendKeys("32801991378");;
		confirmAccNo.sendKeys("32801991378");
		setSelect(selPayeeType,"Saving");
		radioSearch.click();
	}
	
	
	public void setSelect(WebElement selElement, String strText) {
		Select selPayeeType = new Select(selElement);
		selPayeeType.selectByVisibleText(strText);
		}
	public void setSelect(WebElement selElement, int intID) {
		Select selPayeeType = new Select(selElement);
		selPayeeType.selectByIndex(intID);
		}
	
}
