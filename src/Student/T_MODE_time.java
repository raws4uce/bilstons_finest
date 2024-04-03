package Student;

import java.util.ArrayList;

import restart.ClManager;
import restart.MainSingleton;
import restart.Sql_bs;

/*
 * Singleton Class Key
 * Get
 * username, topic, time needed, time taken
 * Set
 */
public class T_MODE_time extends QuizParent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Sql_bs bs = new Sql_bs();
	long endtime; 
	public T_MODE_time(ClManager card) {
		super(card);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void setDetails() {
		userType = "Student";
	}
	@Override
	public void dataStore(int userID, int answer, boolean correct,String date, int time, Level val,String questionid, String topic, int dbanswer) {
		String username = MainSingleton.getInstance().getUsername();
		ArrayList<String> quiz = new ArrayList<>();
		userID = bs.getUserID(username);
		quiz = MainSingleton.getInstance().getQuizData();
		bs.storedataTeacher(userID, quiz.get(1), dbanswer, correct, date, time, val,  topic, questionid, quiz.get(0));
	}
	@Override
	public String endPanel() {
		String x = "end";
		return x;	
	}
	@Override
	public boolean condition() {
		long inputTime = MainSingleton.getInstance().getInputTime();
		long timeTaken = MainSingleton.getInstance().getTimeTaken();
		endtime = System.currentTimeMillis() - timeTaken;
		System.out.println("                                      "+ endtime);
		if (inputTime <= endtime/1000 ) {
	        System.out.println("Switching to 'end' panel");       
	        return true;
	    }
		endtime = 0;
		return false;
	}

	public void setLabel(String questionDataArr)  {
		Qlbl.setText(questionDataArr);
		repaint();
		revalidate();
		
	}
	public long returnTime() {
		return this.endtime;
	}
	
}
