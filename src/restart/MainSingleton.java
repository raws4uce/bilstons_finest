package restart;

import java.util.ArrayList;

import Student.Level;

public class MainSingleton {
	private static MainSingleton instance;

	private String inputUN_SU, inputPW_SU,inputSCH_SU, inputMAIL_SU, inputUsernameLI, hashed, topic, quizType, valtxtbx, Uclass, duedate, teacherName;
	private ArrayList<String> Question= new ArrayList<>(), addHint= new ArrayList<>(), subHint = new ArrayList<>(), divHint= new ArrayList<>(), mulHint= new ArrayList<>(), quizData= new ArrayList<>();
	private int numQuestions, userID, correct, incorrect, questionid;
	private long inputTime, timeTaken, timeTakenNorm;
	private Level diff;
	// Private constructor to prevent external instantiation
	private MainSingleton() {
// initialise variables
	//student
		//Signup
		this.inputMAIL_SU = "";
		this.inputPW_SU = "";
		this.inputSCH_SU = "";
		this.inputUN_SU = "";
		this.inputUsernameLI = "";
		this.hashed = "";
		//quiz
		this.Question = new  ArrayList<>();
		this.diff = null;
		this.timeTakenNorm = 0;
		this.userID = 0;
		this.correct = 0;
		this.incorrect = 0;
		this.topic = "";
		this.questionid = 0;
		this.addHint = null;
		this.subHint = null;
		this.divHint = null;
		this.mulHint = null;
		//teachersetquizzes
		this.quizData = null;
		//MODE normal
		this.numQuestions = 0;
		//MODE time
		this.inputTime = 0;
		this.timeTaken = 0;
		
	//teacher
		this.teacherName = "";
		this.quizType = "";
		this.valtxtbx = "";
		this.Uclass = "";
		this.duedate = "";
	}

	//get the singleton instance
	public static synchronized MainSingleton getInstance() {
		if (instance == null) {
			instance = new MainSingleton();
		}
		return instance;
	}

	//getters and setters for user-related data
	public String getMail() {
		return this.inputMAIL_SU;
	}
	public String getSchool() {
		return this.inputSCH_SU;
	}
	public String getPassword() {
		return this.inputPW_SU;
	}
	public String getUsername() {
		return this.inputUN_SU;
	}
	public String getUsernameLI() {
		return this.inputUsernameLI;
	}
	public String gethashed() {
		return this.hashed;
	}
	public ArrayList<String> getQuestion(){
		return this.Question;
	}
	public long getInputTime() {
		return this.inputTime;
	}
	public long getTimeTaken() {
		return this.timeTaken;
	}
	public int getNumQuestions() {
		return this.numQuestions;
	}
	public Level getDifficulty() {
		return this.diff;
	}
	public long getTimeTakenNorm() {
		return this.timeTakenNorm;
	}
	public int getUserID() {
		return this.userID;
	}
	public int getCorrect() {
		return this.correct;
	}
	public int getInCorrect() {
		return this.incorrect;
	}
	public String getTopic() {
		return this.topic;
	}
	public int getQuestionID() {
		return this.questionid;
	}
	public ArrayList<String> getAddHint(){
		return this.addHint;
	}
	public ArrayList<String> getSubHint(){
		return this.subHint;
	}
	public ArrayList<String> getMulHint(){
		return this.mulHint;
	}
	public ArrayList<String> getDivHint(){
		return this.divHint;
	}
	public String getTeacherName() {
		return this.teacherName;
	}
	public String getQuizType() {
		return this.quizType;
	}
	public String getValTbx() {
		return this.valtxtbx;
	}
	public String getUclass() {
		return this.Uclass;
	}
	public String getDue() {
		return this.duedate;
	}
	public ArrayList<String> getQuizData(){
		return this.quizData;
	}
/*
 ****************************************************
 */
	public void setMail(String mail) {
		this.inputMAIL_SU = mail;
	}
	public void setSchool(String school) {
		this.inputSCH_SU = school;
	}
	public void setUsername(String name) {
		this.inputUN_SU = name;
	}
	public void setPassword(String word) {
		this.inputPW_SU = word;
	}
	public void setUsernameLI(String name) {
		this.inputUsernameLI = name;
	}
	public void setHashed(String hash) {
		this.hashed = hash;
	}
	public void setQuestion(ArrayList<String> question) {
		this.Question = question;
	}
	public void setInputTime(long inTime){
		this.inputTime = inTime;
	}
	public void setTimeTaken(long TTaken) {
		this.timeTaken = TTaken;
	}
	public void setNumQuestions(int num) {
		this.numQuestions = num;
	}
	public void setDifficulty(Level val) {
		this.diff = val;
	}
	public void setTimeTakenNorm(long wood) {
		this.timeTakenNorm = wood;
	}
	public void setUserID(int id) {
		this.userID = id;
	}
	public void setcorrectcount(int count) {
		this.correct = count;
	}
	public void setincorrectcount(int count) {
		this.incorrect = count;
	}
	public void setTopic(String top) {
		this.topic = top;
	}
	public void setQuestion(int num) {
		this.questionid = num;
	}
	public void setAddHints(ArrayList<String> AddAllHints) {
		this.addHint =AddAllHints;
	}
	public void setSubHints(ArrayList<String> SubAllHints) {
		this.subHint = SubAllHints;
	}
	public void setMulHints(ArrayList<String> MulAllHints) {
		this.mulHint = MulAllHints;
	}
	public void setDivHints(ArrayList<String> DivAllHints) {
		this.divHint = DivAllHints;
	}
	public void setTeacherName(String name) {
		this.teacherName = name;
	}
	public void setQuizType(String type) {
		this.quizType = type;
	}
	public void setValTbx(String val) {
		this.valtxtbx = val;
	}
	public void setUclass(String cls) {
		this.Uclass = cls;
	}
	public void setDue(String date) {
		this.duedate = date;
	}
	public void setQuizData(ArrayList<String> quizData) {
		this.quizData = quizData;
	}
}