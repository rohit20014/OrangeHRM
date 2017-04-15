package script;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

public class ExcelReadWrite {
	ReadPropFile file= new ReadPropFile();
	private static XSSFWorkbook wrb;
	private static XSSFSheet sh;
	private static XSSFCell cell;
	private static XSSFRow row;
	
	public ExcelReadWrite()
	{
		try {
			FileInputStream excelFile= new FileInputStream(ReadPropFile.properties.getProperty("Path"));
			wrb= new XSSFWorkbook(excelFile);
			sh= wrb.getSheet(ReadPropFile.properties.getProperty("Sheetname"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public static String readExcel(int RowNum, int ColNum){
		try{

			
  			cell = sh.getRow(RowNum).getCell(ColNum);

  			String CellData = cell.getStringCellValue();
  			
  			return CellData;

  			}catch (Exception e){

				return"";

  			}
	}
	
	public static void setExcel(String Result,  int RowNum, int ColNum){
		try{

  			row  = sh.getRow(RowNum);

			cell = row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);

			if (cell == null) {

				cell = row.createCell(ColNum);

				cell.setCellValue(Result);

				} else {

					cell.setCellValue(Result);

				}
		}catch(Exception e){

			e.printStackTrace();
		
	}
		
	}
	
	public static void writeExcel(){
		try {
				FileOutputStream fileOut = new FileOutputStream(ReadPropFile.properties.getProperty("Path"));

				wrb.write(fileOut);

				fileOut.flush();

				fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
