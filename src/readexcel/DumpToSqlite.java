package readexcel;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
public class DumpToSqlite {
	public static String excelfile = "/run/media/andressanchez/LENOVO/DATA/DATA_8/sample.xls";

	private void dumptoSqlite(HSSFSheet sheet)
	{
		
		Iterator<Row> rowIterator = sheet.iterator();
		Datamanager dm = new Datamanager();
		
	while (rowIterator.hasNext())
	{	
	   StringBuilder sb = new StringBuilder();
		Row row = rowIterator.next();
		Iterator<Cell> cellIterator = row.cellIterator();
		while (cellIterator.hasNext())
		{
			Cell cell = cellIterator.next();
			cell.getCellType();
			if(cell.getCellType().equals(CellType.STRING))
			{
				System.out.println(cell.getStringCellValue());
				sb.append(cell.getStringCellValue()+";");
				
			} else if (cell.getCellType().equals(CellType.NUMERIC))
				{
					System.out.println(cell.getNumericCellValue());
					sb.append(cell.getNumericCellValue()+";");
				}
			else if (cell.getCellType().equals(CellType.BLANK))
			{
				sb.append("-;");
			}
			else if (cell.getCellType().equals(CellType._NONE)) 
			{
				sb.append("-;");
			}
			else 
			{
				sb.append("-;");
			}
			}
		dm.processinsert(sb.toString());
		}
	}
	
	public void readExcel() throws IOException, SQLException
	{
		FileInputStream fi = new FileInputStream(excelfile);
		HSSFWorkbook wb = new HSSFWorkbook(fi);
		
		for(int i =0; i< wb.getNumberOfSheets();i++)
		{
		HSSFSheet sheet = wb.getSheetAt(i);
		this.dumptoSqlite(sheet);
		}
		wb.close();
	}
	
	
}
