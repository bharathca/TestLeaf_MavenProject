package data.read;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcel {
	@Test
	public String[][] readExcel(String excelName) throws IOException
	{

		XSSFWorkbook workBook = new XSSFWorkbook("./data/"+excelName+".xlsx");

		XSSFSheet workSheet = workBook.getSheet("Sheet1");
		int rowCount = workSheet.getLastRowNum();
		System.out.println("The Row Count "+rowCount);

		XSSFRow headerRow = workSheet.getRow(0);
		int columnCount = headerRow.getLastCellNum();
		System.out.println("The Column Count "+columnCount);

		String data[][] = new String[rowCount][columnCount]; 
		for(int i = 1;i<=rowCount;i++)
		{	XSSFRow row = workSheet.getRow(i);
		for(int j= 0; j<columnCount;j++)
		{
			XSSFCell column = row.getCell(j);
			String value = column.getStringCellValue();
			System.out.println(value);
			data[i-1][j]= value;
		}
		}
		workBook.close();
	return data;
	}

}
