package practice_package;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcelSheet {
	public static void main(String[] args) throws Throwable {
		
		/*create object for physical file*/
		FileInputStream fi = new FileInputStream("./src/test/resources/excel.xlsx");
		
		/*create workbook*/
		Workbook wb = WorkbookFactory.create(fi);
		
		/*get sheet*/
		Sheet sh = wb.getSheet("Sheet1");
		
		/*get row*/
		Row ro = sh.createRow(2);
		
		/*create cell*/
		Cell cel = ro.createCell(1);
		cel.setCellValue("Infosys");
		
		FileOutputStream fos = new FileOutputStream("./src/test/resources/excel.xlsx");
		wb.write(fos);
		wb.close();
		
	}		

}
