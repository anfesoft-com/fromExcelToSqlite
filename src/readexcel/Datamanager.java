package readexcel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Datamanager {
	public static String dataUri = "jdbc:sqlite:/run/media/andressanchez/LENOVO/DATA/DATA_8/sample.db";
	private Connection conn() throws SQLException
	{
	Connection conn = DriverManager.getConnection(dataUri);
		return conn;
	}
	
	private void insert(String query) throws SQLException
	{
		//System.out.println(query);
		Connection conn = this.conn();
		conn.createStatement().execute(query);
		conn.close();
	}
	
	
	
	public void processinsert(String rawstring)
	{
		//
		String[] valuesfordb = rawstring.split(";");
		System.out.println("================================================"+valuesfordb[10]+"==============================================");
		StringBuilder sb = new StringBuilder("INSERT INTO fromexcel");
		sb.append(" ('id','t_date','t_type','t_desc1','t_desc2','t_place','t_user','t_numero_factura','t_unit_price','t_quantity','t_total','t_currency','t_proyect','t_transtype')");
		sb.append(" VALUES (");
		sb.append("?,");
		sb.append("'");
		sb.append(valuesfordb[1]);
		sb.append("','");
		sb.append(valuesfordb[2]);
		sb.append("','");
		sb.append(valuesfordb[3]);
		sb.append("','");
		sb.append(valuesfordb[4]);
		sb.append("','");
		sb.append(valuesfordb[5]);
		sb.append("','");
		sb.append(valuesfordb[6]);
		sb.append("','");
		sb.append(valuesfordb[7]);
		sb.append("','");
		sb.append(valuesfordb[8]);
		sb.append("','");
		sb.append(valuesfordb[9]);
		sb.append("','");
		sb.append(valuesfordb[10]);
		sb.append("','");
		sb.append(valuesfordb[11]);
		sb.append("','");
		sb.append(valuesfordb[11]);
		sb.append("','");
		sb.append(valuesfordb[10]);
		sb.append("');");
		try {
			this.insert(sb.toString());
			System.out.println(sb.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
