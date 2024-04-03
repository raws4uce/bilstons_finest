package Student;



public interface Quiz {
	void setDetails();
	String endPanel();
	boolean condition();
	void dataStore(int userID, int answer, boolean correct, String date, int time, Level val, String questionid,String topic, int dbanswer);


}
