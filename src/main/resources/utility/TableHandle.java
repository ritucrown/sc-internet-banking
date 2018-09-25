package utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TableHandle {
	
	
	public int getRowCount(WebElement eleTable) {
		List<WebElement> rowCount = eleTable.findElements(By.tagName("tr"));
		return rowCount.size();
	}

	public String tblReader(WebElement tblRead, String strText) {
		String strReturn = null;
		
		List<WebElement> rows = tblRead.findElements(By.tagName("tr"));
		for (int cRow = 0; cRow < rows.size(); cRow++) {
			List<WebElement> cols = rows.get(cRow).findElements(By.tagName("td"));
			if (strText.equals(cols.get(0).getText())) {
				strReturn = cols.get(1).getText();
			}
		}
		return strReturn;
	}
}
