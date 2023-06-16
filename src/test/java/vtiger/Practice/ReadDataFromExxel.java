package vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExxel {

	public static void main(String[] args) throws IOException {
		
		// Step1: Open the fie in java readable format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
		
		//Step2: Create a workbook factory
		Workbook wb=WorkbookFactory.create(fis);
		
		//Step3: get control of sheet
		Sheet sh = wb.getSheet("Organisation");
		
		//Step4: get control of row
		Row row = sh.getRow(1);
		
		//Step5: get control of cell
		Cell cell = row.getCell(2);
		Cell cell2= row.getCell(1);
		
		//Step6: capture the information o=inside the cell
		String value = cell.getStringCellValue();
		String value2 = cell2.getStringCellValue();
		System.out.println(value);
		System.out.println(value2);
		
	}

}
