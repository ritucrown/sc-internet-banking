package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import dataprovider.ConfigFileReader;

public class ExcelReader extends ConfigFileReader {
	FileInputStream fileInputStream;
	Workbook workbook;
	Sheet sheet;
	List<String> rtnList = new ArrayList<String>();
	
	public List<String> readExcel( String fileName, String sheetName) throws IOException {
		
		String filePath = getDataFilePath()+fileName;
		File file = new File(filePath);
		String exten = filePath.substring(filePath.indexOf("."));
		String property = System.getProperty("user.dir");
		String workDir = property;
		File file1 = new File(workDir+getExcelLocation()+fileName);
		System.out.println(exten);
		if (exten.equals(".xlsx")) {
			fileInputStream = new FileInputStream(file1);
			workbook = new XSSFWorkbook(fileInputStream);
			sheet = workbook.getSheet(sheetName);

			for (int cRow = 0; cRow <= sheet.getLastRowNum(); cRow++) {
				Row row = sheet.getRow(cRow);
				for (int cCol = 0; cCol < row.getLastCellNum(); cCol++) {
					Cell cell = row.getCell(cCol, MissingCellPolicy.RETURN_BLANK_AS_NULL);
					if (cell.getCellType() == 1) {
						rtnList.add(cell.getStringCellValue());
					} else {
						double num = cell.getNumericCellValue();
						rtnList.add(String.valueOf(num));
					}
				}
			}
			fileInputStream.close();
			workbook.close();
		}
		return rtnList;
	}
	
	static Workbook wb;
	static Sheet tblSheet;
	static FileInputStream inputFile;
	static Row row;
	static Cell cell;
	static ConfigFileReader config = new ConfigFileReader();
	
	public static Object[][] tblExcelData(String fileName, String sheetName) throws IOException {
		Object[][] rtnData = null;
		String filePath = System.getProperty("user.dir")+config.getExcelLocation()+fileName;
		String strExtension = filePath.substring(filePath.indexOf('.'));
		
			inputFile = new FileInputStream(filePath);

		if (strExtension.equals(".xlsx")) {
			wb = new XSSFWorkbook(inputFile);			
		} else {
			wb = new HSSFWorkbook(inputFile);
		}
			tblSheet = wb.getSheet(sheetName);
			int cntRow = tblSheet.getLastRowNum();
			int cntCol = tblSheet.getRow(1).getLastCellNum();
			rtnData = new Object[cntRow+1][cntCol];
			for (int cRow = 0; cRow <=cntRow; cRow++) {
				for (int cCol = 0; cCol <cntCol; cCol++) {
					System.out.println(cRow+" "+cCol);
					rtnData[cRow][cCol] = getValue(cRow, cCol);
					
				}
			}
			inputFile.close();
			wb.close();
		return rtnData;
		
	}
	
	public static String getValue(int Row, int Col) {
		Cell cell = tblSheet.getRow(Row).getCell(Col, MissingCellPolicy.RETURN_BLANK_AS_NULL);
		System.out.println(cell.getStringCellValue());
		if (cell.getCellType() == 1) {
			return cell.getStringCellValue();
		} else {
			double num = cell.getNumericCellValue();
			return String.valueOf(num);
		}
	}
}
