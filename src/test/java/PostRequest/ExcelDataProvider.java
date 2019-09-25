package PostRequest;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

// create class to read data from excel sheet
public class ExcelDataProvider {

	////Static object from file input stream to store the stream of original file
	static FileInputStream fis = null ;

	////method to get property of original file path and pass it to a string then pass the string to the static object of file input stream to read the stream data of the original file
	public static FileInputStream GetFileInputStream() throws FileNotFoundException {
		String filePath = System.getProperty("user.dir") + "/src/test/java/TestData/Sample excel.xlsx";
		File srcFile = new File(filePath);

		fis = new FileInputStream(srcFile);

		return fis;
	}

	////method of object with two dimensional array to read .xlsx file types
	public static Object [] getExcelData() throws IOException
	{
		fis = GetFileInputStream();
		XSSFWorkbook workBook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workBook.getSheetAt(0);

		int startReadExcelRow = 1;
		int totalNumberofRows = sheet.getLastRowNum();
		//int totalNumberofColumns = 2;

		Object [] arrayExcelData = new Object [totalNumberofRows];

		int k = 0;
		
		for (int i =startReadExcelRow; i<=totalNumberofRows;i++)
		{
			XSSFRow row = sheet.getRow(i);
			//System.out.println(row.getCell(1).getStringCellValue());
			arrayExcelData[k] = row.getCell(1).getStringCellValue();
			//System.out.println(arrayExcelData[k]);
			
			k++;

		}

		workBook.close();
		return arrayExcelData;

	}

}
