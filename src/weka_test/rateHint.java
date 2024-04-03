package weka_test;
import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Student.Level;

public class rateHint {
	public static final String JDBC_URL = "jdbc:mysql://localhost:3306/csmathapp";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "1M@Y0URb17144473";
	public static ArrayList<Integer> list = new ArrayList<Integer>(12);

	public static Level val = null;
	public static void main(String[] args) throws SQLException {
		for(int i = 1; i <= 12; i++) {
			list.add(i);
		}
		boolean valy = true;
		int userID = 1, count = 0;
		Scanner scan = new Scanner(System.in);
		LocalDateTime date = LocalDateTime.now();    
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String dateDB = date.format(format);
		long time = System.currentTimeMillis();
		//start time
		while(count != 12) {
			long wood = System.currentTimeMillis();
			ArrayList<String> question = getQuestionData();
			String questionTxt = question.get(2);
			int answer = Integer.parseInt(question.get(3));
			System.out.println(questionTxt);
			int input = scan.nextInt();
			boolean correct = (input == answer);
			ArrayList<String> hint = selectHint();
			if(correct) {
				System.out.println("ur supposed to get questions wrong silly");
			}else {
				long iterationTime = System.currentTimeMillis() - wood;
				System.out.println("' "+hint.get(1)+" '");
				System.out.println("you like wha you see? Y/N");
				scan.nextLine();
				String rating = scan.nextLine();

				storeData(userID, input, correct, dateDB, iterationTime/1000, val, question.get(0), question.get(1), hint.get(0), rating);
				time = System.currentTimeMillis();
			}


			//reset time
			time = 0;
			count++;
		}

	}

	public static void storeData(int userID, int answer, boolean correct, String date, long timereal, Level val, String topic, String questionid, String hintID, String rating) throws SQLException {
		Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
		String SQLquery = "INSERT INTO results (idStudent, sAnswer, correct, date, time, difficulty, topic, questionid, hintID, Rating) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement studentpstmt = connection.prepareStatement(SQLquery);
		int hint = Integer.parseInt(hintID);
		studentpstmt.setInt(1, userID);
		studentpstmt.setInt(2, answer);	
		studentpstmt.setBoolean(3, correct);
		studentpstmt.setString(4, date);
		studentpstmt.setLong(5, timereal+12);
		studentpstmt.setString(6, val.toString());
		studentpstmt.setString(7, topic); // topic name
		studentpstmt.setString(8, questionid);
		studentpstmt.setInt(9, hint);
		studentpstmt.setString(10, rating);
		studentpstmt.executeUpdate();
	}



	private static ArrayList<String> selectHint() throws SQLException {
		Random rand = new Random();
		ArrayList<String> arr = new ArrayList<>();
		while(list.size() > 0) {
			int index = rand.nextInt(list.size());
			System.out.println("Selected: "+list.remove(index));
			String sqlquery = "SELECT * FROM hints WHERE idhints = "+ (index+1);
			Connection con = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
			Statement stmt = con.createStatement();	
			ResultSet rs = stmt.executeQuery(sqlquery);

			while(rs.next()) {
				for(int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
					arr.add(rs.getString(i));
				}
			}
			break;
		}
		return arr;
	}

	public static ArrayList<String> getQuestionData() throws SQLException {
		Connection con = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
		Random randomNum1 = new Random();Random randomNum2 = new Random();
		int number2 = randomNum1.nextInt(9) + 1; // SQL indexing starts from 1
		int e = randomNum2.nextInt(3);
		try {
			String diff = "";
			String topic = "";
			String topicid = "";
			switch (e){
			case 0:
				diff = "e";
				val = Level.EASY;
				break;
			case 1:
				diff = "m";
				val = Level.MEDIUM;
				break;
			case 2:
				diff = "h";
				val = Level.HARD;
				break;	
			}ArrayList<String> arr = new ArrayList<String>();
			Random randomNum = new Random();
			int ran = randomNum.nextInt(100);

			if (ran <= 25) {
				topic = "add";
			} else if (ran >= 26 && ran <= 50) {
				topic = "sub";
			}else if(ran <= 75 && ran >= 51) {
				topic = "div";
			}else {
				topic = "mul";
			}
			topic = "add";
			arr.add(topic);
			topic = topic +""+ diff;
			topicid = "id"+topic;	
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM "+ topic + " WHERE " +topicid + "= " + (number2+1) );


			while(rs.next()) {
				for(int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
					arr.add(rs.getString(i));
				}
			}
			System.out.println(arr);
			rs.close();
			//index of array, [topic, id, text. answer, difficulty, ]
			arr.add(diff);
			return arr;

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// TODO Auto-generated method stub
		return null;
	}



}
