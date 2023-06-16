package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcelFile {

	public static void main(String[] args) throws IOException {
		
		// Step1: Open the fie in java readable format
				FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
				
				//Step2: Create a workbook factory
				Workbook wb=WorkbookFactory.create(fis);
				
				//Step3: get control of sheet
				Sheet sh = wb.getSheet("Organisation");
				
				//Step4: get control of row
				Row row = sh.createRow(6);
				
				//Step5: get control of cell
				Cell cell = row.createCell(7);
				
				//Step6: set the cell value
				cell.setCellValue("Vinutha");
				
				//Step7: Open the file in java write format
				FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\Testdata.xlsx");
				
				//Step8: Write data into the file
				wb.write(fos);
				System.out.println("Data Written");
				wb.close();

	}


}
