package restart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import Student.Level;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.DefaultListModel;

/*
 * Singleton Class Key
 * Get
 * 
 * Set
 * Topic
 */

public class Sql_bs {
	public static final String JDBC_URL = "jdbc:mysql://localhost:3306/csmathapp";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "1M@Y0URb17144473";

	public static Connection getCon() {
		try {
			Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
			return connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//randomly selects maths question
	public ArrayList<String> selectQuestion(Level e) {
		Connection con = getCon();
		Random randomNum1 = new Random();
		int number2 = randomNum1.nextInt(9) + 1; // SQL indexing starts from 1
		try {
			String diff = "";
			String topic = "";
			String topicid = "";
			switch (e){
			case EASY:
				diff = "e";
				break;
			case MEDIUM:
				diff = "m";
				break;
			case HARD:
				diff = "h";
				break;	
			}

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
			MainSingleton.getInstance().setTopic(topic);

			topic = topic +""+ diff;
			topicid = "id"+topic;


			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM "+ topic + " WHERE " + topicid + "= " + number2 );

			ArrayList<String> arr = new ArrayList<String>();
			while(rs.next()) {
				for(int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
					arr.add(rs.getString(i));
				}
			}
			System.out.println(arr);
			return arr;

		} catch (SQLException e1) {
		}

		// TODO Auto-generated method stub
		return null;
	}

	//stores performance
	public void storeData(int userID, int answer, boolean correct, String date, long timereal, Level val, String questionid, String topic) throws SQLException {
		Connection connection = getCon();
		//		int performance = getPerformance(correct, val, timereal);
		String SQLquery = "INSERT INTO results (idStudent, sAnswer, correct, date, time, difficulty, topic, questionid ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement studentpstmt = connection.prepareStatement(SQLquery);
		System.out.println(userID +" "+ answer +" "+ correct +" "+ date +"  "+ val);
		studentpstmt.setInt(1, userID);
		studentpstmt.setInt(2, answer);	
		studentpstmt.setBoolean(3, correct);
		studentpstmt.setString(4, date);
		studentpstmt.setLong(5, timereal);
		studentpstmt.setString(6, val.toString());
		studentpstmt.setString(7, topic); // topic name
		studentpstmt.setString(8, questionid);
		studentpstmt.executeUpdate();
	}
	//stores performance for Teacher set quizzes
	public void storedataTeacher(int userID, String name, int answer, boolean correct, String date, int timereal, Level val, String topic, String questionid, String quizid) {
		try {
			Connection connection = getCon();
			int qID = Integer.parseInt(quizid);
			String SQLquery = "INSERT INTO teacherresults(idStudent, idTeacher, SAnswers, correct, date, time, difficulty, topic, questionid, quizid) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";	
			PreparedStatement teacherpstmt = connection.prepareStatement(SQLquery);
			System.out.println(userID +" "+ answer +" "+ correct +" "+ date +"  "+ val);
			String dif = val.toString();
			teacherpstmt.setInt(1, userID);
			teacherpstmt.setString(2, name);
			teacherpstmt.setInt(3, answer);
			teacherpstmt.setBoolean(4, correct);
			teacherpstmt.setString(5, date);
			teacherpstmt.setLong(6, timereal);
			teacherpstmt.setString(7, dif);
			teacherpstmt.setString(8, topic);
			teacherpstmt.setString(9, questionid);
			teacherpstmt.setInt(10, qID);
			teacherpstmt.executeUpdate();	
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	//returns students id
	public int getUserID(String Username) {
		try {
			Connection connection = getCon();
			PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM Students WHERE username = ?");
			pstmt.setString(1, Username);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String usernameDB = rs.getString("username");
				if(Username.equals(usernameDB) ) {
					return rs.getInt("idstudents");
				}
			}
			System.out.println("username not found in db");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	//returns specific hint
	public String getHint(int hintID) throws SQLException {
		Connection con = getCon();
		PreparedStatement pstmt = con.prepareStatement("SELECT hint FROM hints WHERE idhints = ?");
		pstmt.setInt(1, hintID);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			String hint = rs.getString("hint");
			return hint;
		}
		return null;

	}
	//returns a data structure of a certain class
	public DefaultListModel<String> getAllstudents(String Class) {
		DefaultListModel<String> students = new DefaultListModel<>();
		try{Connection connection = getCon();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM students WHERE class = '" + Class + "'");
		int i=0;
		while (resultSet.next()) {
			String username = resultSet.getString("username");
			students.add(i, username);
			i++;
		}
		return students;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//returns the school associated with name
	public String getSchool(String teacherName) {
		String query = "SELECT school FROM teachers WHERE username = "+ teacherName+";";
		try {
			Connection con = getCon();
			Statement stmt = con.createStatement();
			ResultSet rs  = stmt.executeQuery(query);
			while(rs.next()) {
				String School = rs.getString("school");
				return School;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	//returns data structure of student/students of the same school
	public DefaultListModel<String> searchStudents(String school, String name) {
		DefaultListModel<String> students = new DefaultListModel<>();

		String query = "SELECT * FROM students WHERE school = ?";
		if (!name.equals("ALL")) {
			query += " AND username = ?";
		}
		try {
			Connection connection = getCon();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, school);
			if (!name.equals("ALL")) {
				preparedStatement.setString(2, name);
			}
			ResultSet resultSet = preparedStatement.executeQuery();
			int i=0;
			while (resultSet.next()) {
				String username = resultSet.getString("username");
				students.add(i, username);
				i++;
			}
			return students;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; 
	}

	//updates existing users classes
	public void createClass(DefaultListModel<String> class1, String className) {
		for(int i=0; i<class1.size();i++) {
			String query = "UPDATE Students SET class = ? WHERE username = ?";
			try {
				Connection con = getCon();
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, className);
				System.out.println(className);
				pstmt.setString(2, class1.get(i));
				int rowAff = pstmt.executeUpdate();

				if(rowAff > 0) {
					System.out.println("Class updated successfully for user: " + class1.get(i));
				} else {
					System.out.println("Class update failed for user: " + class1.get(i));
				}
				pstmt.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		}
	}


	//stores a quizzes specification in table
	public void storeQuiz(String teacher, String searchText, String quizType, String spec, String diff, String dueDate) {
		String sql = "INSERT INTO teachersetquiz (teacher, class, quiztype, spec, difficulty, duedate) VALUES (?, ?, ?, ?, ?, ?)";
		try (Connection conn = getCon();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, teacher);
			pstmt.setString(2, searchText);
			pstmt.setString(3, quizType);
			pstmt.setString(4, spec);
			pstmt.setString(5, diff);  
			pstmt.setString(6, dueDate);

			int rowsInserted = pstmt.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Quiz stored successfully!");
			} else {
				System.out.println("Failed to store quiz.");
			}
		} catch (SQLException e) {
			System.err.println("SQL error occurred: " + e.getMessage());
		}
	}
	//returns students class
	public String getClass(String username) {
		String query = "SELECT class FROM students WHERE username = ?;";
		try {
			String clsname = "";
			Connection con = getCon();
			PreparedStatement  pstmt = con.prepareStatement(query);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				clsname = rs.getString("class");
			}

			return clsname;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	//returns an array of completed quizID's
	public ArrayList<String> getCompletedQuiz(int studentID){
		Set<String> uniqueQuizIDs = new LinkedHashSet<>();
		String query = "SELECT quizID FROM teacherresults WHERE idStudent = ?;";
		try {
			Connection con = getCon();
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, studentID);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				uniqueQuizIDs.add(rs.getString(1));
			}
			ArrayList<String> completedQuizID = new ArrayList<>(uniqueQuizIDs);
			return completedQuizID;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	//returns boolean value (shows that there are/aren't any quizzes left), stores an array of quizzes to be done
	public Boolean getQuizData(String cls, ArrayList<String> complete){
		Boolean val = true;
		ArrayList<String> quizData = new ArrayList<>();
		String query = "SELECT * FROM teachersetquiz WHERE class = ?";
		try {
			Connection con = getCon();
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, cls);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int intid = rs.getInt(1);
				String id = Integer.toString(intid);
				if(complete.isEmpty()) {
					for(int j = 1; j <= rs.getMetaData().getColumnCount(); j++) {
						quizData.add(rs.getString(j));
					}
				}else {
					for(String completeId : complete) {
						if(!(id.equals(completeId))) {
							for(int j = 1; j <= rs.getMetaData().getColumnCount(); j++) {
								quizData.add(rs.getString(j));

							}
						}
						//for some reason if all quizzes are done, every quiz would get dashed in quizData
						if(quizData.size() >=8) {
							val=false;
						}
					}
				}

			}
			MainSingleton.getInstance().setQuizData(quizData);
			return val;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
