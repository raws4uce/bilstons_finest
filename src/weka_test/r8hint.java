package weka_test;
//CREATING THE TRAINING DATASET, just making sure that each topic at each difficulty (had some hints with "y" values) ->appropriate hints 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import Student.Level;

public class r8hint {
	static ArrayList<String> qData = new ArrayList<>();
	static ArrayList<String> hData = new ArrayList<>();
	private static Scanner scan;
	public static void main(String[] args) throws Exception {
		LocalDateTime date = LocalDateTime.now();    
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String dateDB = date.format(format);
		String topic = "div";
		Level val = null;
		long time = 0;
		//iterates through each difficulty
		for(int i=0 ; i < 3 ; i++) {
			String difficulty = "";
			if(i == 0) {difficulty = "e"; val = Level.EASY;}
			if(i == 1) {difficulty = "m"; val = Level.MEDIUM;}
			if(i == 2) {difficulty = "h"; val = Level.HARD;}
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/csmathapp", "root", "1M@Y0URb17144473");
			int x =0;
			Statement stmt = con.createStatement();
			for(int j = 0; 11 >= j; j++) {
				time = System.currentTimeMillis();

				ResultSet getquestion = stmt.executeQuery("SELECT * FROM "+ topic + difficulty+" WHERE id"+ topic + difficulty+" = " + (j+1));
				while(getquestion.next()) {
					//stores row of data for question
					for(int k = 1; k <= getquestion.getMetaData().getColumnCount(); k++) {
						qData.add(getquestion.getString(k));
					}
				}
				getquestion.close();
				//there are 12 hints, it is here to loop
				x++;
				if (x >12) {
					x=1;
				}
				ResultSet gethint = stmt.executeQuery("SELECT * FROM hints WHERE idhints = " +x);
				while(gethint.next()) {
					//store row of data for hint
					for(int l = 1; l <= gethint.getMetaData().getColumnCount(); l++) {
						hData.add(gethint.getString(l));
					}
				}
				gethint.close();
				scan = new Scanner(System.in);
				System.out.println("answer the question: "+ qData.get(1));
				String input = scan.nextLine();
				long longago = System.currentTimeMillis() - time;
				int difference = Integer.parseInt(input) - Integer.parseInt(qData.get(2));
				//instead of storing answer (pointless), store the difference between answer and input
				if(difference < 0) {
					difference *= -1;
				}
				if(input != qData.get(2)) {
					boolean correct = false;
					System.out.println(hData.get(1));
					System.out.println("rate this Y/N");
					String rating = scan.nextLine();
					storeData(1, difference, correct, dateDB, longago/1000, val, topic, qData.get(0), hData.get(0), rating);
				}
				//reset array
				qData = new ArrayList<String>();
				hData = new ArrayList<String>();
			}
			stmt.close();
			con.close();
		}
	}
	public static void storeData(int userID, int answer, boolean correct, String date, long timereal, Level val, String topic, String questionid, String hintID, String rating) throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/csmathapp", "root", "1M@Y0URb17144473");
		String SQLquery = "INSERT INTO results (idStudent, sAnswer, correct, date, time, difficulty, topic, questionid, hintID, Rating) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement studentpstmt = connection.prepareStatement(SQLquery);
		int hint = Integer.parseInt(hintID);
		studentpstmt.setInt(1, userID);
		studentpstmt.setInt(2, answer);	
		studentpstmt.setBoolean(3, correct);
		studentpstmt.setString(4, date);
		studentpstmt.setLong(5, timereal+6);
		studentpstmt.setString(6, val.toString());
		studentpstmt.setString(7, topic); // topic name
		studentpstmt.setString(8, questionid);
		studentpstmt.setInt(9, hint);
		studentpstmt.setString(10, rating);
		studentpstmt.executeUpdate();
	}

}
