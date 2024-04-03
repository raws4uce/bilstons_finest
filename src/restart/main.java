package restart;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.io.FileOutputStream; 
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.opencsv.CSVWriter;

import Student.MODE_normal;
import Student.MODE_time;
import Student.StudentAccount;
import Student.StudentSetQuizzes;
import Student.TeacherSetQuizzes;
import Student.End_quiz;
import Student.T_MODE_normal;
import Student.T_MODE_time;
import registration.StudentLogin;
import registration.StudentSignup;
import registration.TeacherLogin;
import registration.TeacherSignup;
import registration.Title;
import Teacher.TeacherTitle;
import Teacher.SetQuiz;
import Teacher.SetClass;
import weka.classifiers.trees.J48;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;
import weka.core.converters.ConverterUtils.DataSource;

/*
 * Singleton Class Key
 * Get
 * 
 * Set
 * hint array for all 4 topics
 */

public class main extends JFrame implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//card layout
	private ClManager card;
	private JPanel contentPane;
	//reg
	private JPanel Title, TeacherSignup, StudentSignup, StudentLogin, TeacherLogin;
	//student 
	private JPanel StudentAccount, StudentSetQuizzes, TeacherSetQuizzes;
	//quiz
	private JPanel MODE_normal, MODE_time, end_quiz, T_MODE_normal, T_MODE_time;
	//teacher
	private JPanel TeacherTitle, SetQuiz, SetClass;
	public main() {
		card = new ClManager();
		Title = new Title(card); 
		TeacherSignup = new TeacherSignup(card);
		StudentSignup = new StudentSignup(card);
		TeacherLogin = new TeacherLogin(card);
		StudentLogin = new StudentLogin(card);
		//Student
		StudentAccount = new StudentAccount(card);
		StudentSetQuizzes = new StudentSetQuizzes(card);
		TeacherSetQuizzes = new TeacherSetQuizzes(card);
		//quiz
		MODE_normal = new MODE_normal(card);
		MODE_time = new MODE_time(card);
		end_quiz = new End_quiz(card);
		T_MODE_normal = new T_MODE_normal(card);
		T_MODE_time = new T_MODE_time(card);
		//Teacher
		TeacherTitle = new TeacherTitle(card);
		SetQuiz = new SetQuiz(card);
		SetClass = new SetClass(card);
		
		card.addPanel("title", Title);
		card.addPanel("tsignup", TeacherSignup);
		card.addPanel("ssignup", StudentSignup);
		card.addPanel("slogin", StudentLogin);
		card.addPanel("tlogin", TeacherLogin);

		card.addPanel("student account", StudentAccount);
		card.addPanel("students quizzes", StudentSetQuizzes);
		card.addPanel("teachers quizzes", TeacherSetQuizzes);

		card.addPanel("quiz normal", MODE_normal);
		card.addPanel("quiz time", MODE_time);
		card.addPanel("end", end_quiz);
		card.addPanel("teacher normal", T_MODE_normal);
		card.addPanel("teacher time", T_MODE_time);
		
		card.addPanel("taccess", TeacherTitle);
		card.addPanel("teacher setquiz", SetQuiz);
		card.addPanel("teacher setclass", SetClass);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().setLayout(new CardLayout(0, 0));
		getContentPane().add(card, BorderLayout.CENTER);

		card.showPanel("title");
	}
	public void run() {
		ArrayList<String> ADDallHints = new ArrayList<>(), SUBallHints = new ArrayList<>(), MULallHints = new ArrayList<>(), DIVallHints = new ArrayList<>();
		//SQL query to CSV
		CSVWriter writer;
		try {
			writer = new CSVWriter(new FileWriter("test.csv"));
			Boolean includeHeaders = true;
			Connection con = Sql_bs.getCon();
			Statement stmt = con.createStatement();
			ResultSet myResultSet = stmt.executeQuery("SELECT correct, difficulty, topic, hintid, rating FROM results;");
			writer.writeAll(myResultSet, includeHeaders);
			writer.close();
		} catch (IOException e) {
			System.out.println("Maybe directory of Test CSV file");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQL query for (Query->->->CSV)");
			e.printStackTrace();
		}
		//CSV to ARFF
		CSVLoader loader = new CSVLoader();
		try {
			loader.setSource(new File("test.csv"));
			Instances data = loader.getDataSet();
			File file = new File("newTestingSet.arff");
			try (FileOutputStream fos = new FileOutputStream(file, false)) { //allows overwriting 
			    ArffSaver saver = new ArffSaver();
			    saver.setInstances(data);
			    saver.setDestination(fos);
			    saver.writeBatch();
			} catch (IOException e) {
			    System.out.println(e.getMessage());
			    e.printStackTrace();
			}
			J48 tree;
			try {
				tree = (J48) weka.core.SerializationHelper.read("J48.model"); //already trained model
				DataSource src1 = new DataSource("newTestingSet.arff");
				Instances test = src1.getDataSet();
				test.setClassIndex(test.numAttributes()-1);
				for(int i = 0; i < test.numInstances(); i++) {
					Instance newInst = test.instance(i);
					double prediction = tree.classifyInstance(newInst);
					String pred = test.classAttribute().value((int) prediction);
					System.out.println(/*real + */", "+ pred);
					String hintid = newInst.toString(newInst.attribute(3)); //hint id
					String topic = newInst.toString(newInst.attribute(2)); // topic
					System.out.println("                                       " + i);
					switch (topic) {
					case "add":
						if(pred.equals("Y")) { //Y value indicates that hint is appropriate for topic
							ADDallHints.add(hintid);//store in array
						}
						break;
					case "sub":
						if(pred.equals("Y")) {SUBallHints.add(hintid);}
						break;
					case "mul":
						if(pred.equals("Y")) {MULallHints.add(hintid);}
						break;
					case "div":
						if(pred.equals("Y")) {DIVallHints.add(hintid);}
						break;
					}
				}
				file.delete();
			} catch (Exception e) {
				System.out.println("likely Directory of ARFF file || Classifier model not saved in project (run FirstTest.java in weka_test package, this should either reset/update/create new binary file)");
				e.printStackTrace();
			}
			
		} catch (IOException e) {
			System.out.println("issue with directory of CSV file (loading) if you see me then you are all on your own pal.");
			e.printStackTrace();
		}

		MainSingleton.getInstance().setAddHints(ADDallHints);
		MainSingleton.getInstance().setSubHints(SUBallHints);
		MainSingleton.getInstance().setMulHints(MULallHints);
		MainSingleton.getInstance().setDivHints(DIVallHints);

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			main thread = new main();
			Thread t1 = new Thread(thread);
			public void run() {
				try {
					t1.start();
					main frame = new main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}	
}
