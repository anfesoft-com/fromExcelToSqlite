package readexcel;
/*Reads excel file , tab by tab and dump it's contents into a database sqlite*/
import java.io.IOException;
import java.sql.SQLException;

public class Entry {
	
	
	public static void main(String[] args) throws IOException, SQLException {
		// TODO Auto-generated method stub
		DumpToSqlite ds = new DumpToSqlite();
		ds.readExcel();
	}

}
