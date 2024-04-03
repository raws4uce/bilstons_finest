package Student;

import java.sql.SQLException;
import restart.ClManager;
import restart.MainSingleton;
import restart.Sql_bs;

/*
 * Singleton Class Key
 * Get
 * username, topic, time needed, time taken
 * Set
 */
public class MODE_time extends QuizParent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Sql_bs bs = new Sql_bs();
	long endtime;
	public MODE_time(ClManager card) {
		super(card);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void setDetails() {
		userType = "Student";
	}
	@Override
	public void dataStore(int userID, int answer, boolean correct,String date, int time, Level val,String questionid, String topic, int dbanswer ) {
		String username = MainSingleton.getInstance().getUsername();
		userID = bs.getUserID(username);
		try {
			topic = MainSingleton.getInstance().getTopic();
			bs.storeData(userID, answer, correct, date, time, val, questionid, topic );
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
