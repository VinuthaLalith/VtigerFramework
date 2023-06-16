package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public String readDataFromExcel(String sheetname,int rowno,int cellno) throws IOException {
		
		FileInputStream fis=new FileInputStream(IConstantutility.excelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		String value=wb.getSheet(sheetname).getRow(rowno).getCell(cellno).getStringCellValue();
		wb.close();
		return value;

	}
	public void writeDataIntoExcel(String sheetname,int rowno,int cellno,String value) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis=new FileInputStream(IConstantutility.excelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		wb.createSheet(sheetname).createRow(rowno).createCell(cellno).setCellValue(value);
		
		FileOutputStream fos=new FileOutputStream(IConstantutility.excelFilePath);
		wb.write(fos);
		wb.close();
		
	}
	
	
	/**
	 * This method will read multiple data from excel and has to given to DataProvider
	 * @param sheetname
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] readMultipleData(String sheetname) throws EncryptedDocumentException, IOException{

		FileInputStream fis=new FileInputStream(IConstantutility.excelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		int lastRow=sh.getLastRowNum();
		int lastCell=sh.getRow(0).getLastCellNum();
		
		Object[][] data=new Object[lastRow][lastCell];
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastCell;j++)
			{
				data[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		
		
		return data;
		
	}
	
	

}
