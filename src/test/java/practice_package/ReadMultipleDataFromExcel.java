package practice_package;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromExcel {
public static void main(String[] args) throws Throwable {
		
		/*create object for physical file*/
		FileInputStream fi = new FileInputStream("./src/test/resources/excel.xlsx");
		
		/*create workbook*/
		Workbook wb = WorkbookFactory.create(fi);
		
		/*get sheet*/
		Sheet sh = wb.getSheet("Sheet1");
		
		for (int i = 1;i<=sh.getLastRowNum();i++)
		{
		Row ro = sh.getRow(i);
		Cell cel = ro.getCell(1);
		String value = cel.getStringCellValue();
		System.out.println(value);
		}		
}
}