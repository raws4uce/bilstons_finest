package weka_test;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.opencsv.CSVWriter;

public class SqlToArff {
	public static void main(String[] args) throws SQLException, IOException {
		CSVWriter writer = new CSVWriter(new FileWriter("C:\\Users\\saura\\Documents\\alevel\\coursework.ComputerScience();\\sql2.csv"));
		Boolean includeHeaders = true;

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/csmathapp", "root", "1M@Y0URb17144473");
		Statement stmt = con.createStatement();

		ResultSet myResultSet = stmt.executeQuery("SELECT correct, difficulty, topic, hintid, rating FROM results;");
		writer.writeAll(myResultSet, includeHeaders);
		writer.close();
		System.out.print("fdnfbd");
	}

}
