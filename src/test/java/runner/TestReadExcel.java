package runner;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import utility.ExcelReader;

public class TestReadExcel {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		 ExcelReader readFile = new ExcelReader();
		  List<String> excelData;
		try {
			excelData = readFile.readExcel("DataSheet", "AddPayee");
			 for (int cnt = 0; cnt < excelData.size(); cnt++) {
					System.out.println(excelData.get(cnt));
				}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
