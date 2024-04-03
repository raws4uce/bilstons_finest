package Student;

import java.sql.SQLException;

import restart.ClManager;
import restart.MainSingleton;
import restart.Sql_bs;
/*
 * Singleton Class Key
 * Get
 * Num of questions
 * Set
 */
public class MODE_normal extends QuizParent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Sql_bs bs = new Sql_bs();
	public MODE_normal(ClManager card) {
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
		userID = bs.getUserID(username);
		try {
			bs.storeData(userID, answer, correct, date, time, val, questionid, topic);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		int num = MainSingleton.getInstance().getNumQuestions();
		if (counter == num) {
			System.out.println("Switching to 'end' panel");       
			return true;
		}
		return false;
	}

	public void setLabel(String questionDataArr)  {
		Qlbl.setText(questionDataArr);
		repaint();
		revalidate();

	}

}
