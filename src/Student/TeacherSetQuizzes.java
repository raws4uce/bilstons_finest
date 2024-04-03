package Student;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import restart.MainSingleton;
import restart.ClManager;
import restart.Sql_bs;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TeacherSetQuizzes extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btn;
	private JLabel lbl;
	private ClManager lecard;
	private Sql_bs bs = new Sql_bs();
	boolean continuenow = false;
	public ArrayList<String> questionDataArr = new ArrayList<>();
	public ArrayList<String> quizDataArr = new ArrayList<>();

	/**
	 * Create the panel.
	 */
	public TeacherSetQuizzes(ClManager card) {
		lecard = card;
		setLayout(new GridBagLayout());
		//title row
		GridBagConstraints c = new GridBagConstraints();

		lbl = new JLabel("Select ya quiz mode");
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(10, 10, 10, 10);
		add(lbl, c);
		c.fill = GridBagConstraints.NONE;
		c.insets = new Insets(0,0,0,0);


		//new row
		btn = new JButton("normal");
		btn.addActionListener(new doquizListener());
		c.insets = new Insets(5,5,5,5);
		c.gridx=0;
		c.gridy++;
		c.gridwidth = 1;
		c.gridheight = 1; 
		c.fill = GridBagConstraints.BOTH;
		add(btn, c);

		lbl = new JLabel("<html>Ran<br>out of<br>time</html>", SwingConstants.CENTER);
		c.gridx++;
		c.gridwidth = 1; 
		c.fill = GridBagConstraints.HORIZONTAL;
		add(lbl,c);

		//new row



	}
	private class doquizListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			quizDataArr = MainSingleton.getInstance().getQuizData();
			Level difficulty = getDiff(quizDataArr.get(5));
			switch (quizDataArr.get(3)) {
			case "norm":
				MainSingleton.getInstance().setDifficulty(difficulty);
				questionDataArr = bs.selectQuestion(difficulty);
				System.out.println("this " + questionDataArr);
				MainSingleton.getInstance().setQuestion(questionDataArr);
				long questionStartTime = System.currentTimeMillis();
				MainSingleton.getInstance().setTimeTakenNorm(questionStartTime);
				String text =quizDataArr.get(4);
				int n0 = Integer.parseInt(text);
				MainSingleton.getInstance().setNumQuestions(n0);
				MODE_normal mode_normal = new MODE_normal(null);
				mode_normal.setLabel(questionDataArr.get(1));
				repaint();
				lecard.showPanel("teacher normal");
				revalidate();
				repaint();
				break;

			case "time":
				MainSingleton.getInstance().setDifficulty(difficulty);
				questionDataArr = bs.selectQuestion(difficulty);
				MainSingleton.getInstance().setQuestion(questionDataArr);
				//				MODEtime.setLbl(questionDataArr);
				long startTimer = System.currentTimeMillis();
				MainSingleton.getInstance().setTimeTaken(startTimer);
				long time = Long.parseLong(quizDataArr.get(5));
				MainSingleton.getInstance().setInputTime(time);
				MODE_time timeM = new MODE_time(null);
				timeM.setLabel(questionDataArr.get(1));
				lecard.showPanel("teacher time");
				revalidate();
				repaint();
				break;
			}

		}	
	}

	private Level getDiff(String dif) {
		switch (dif) {
		case "EASY":
			return Level.EASY;
		case "MEDIUM":
			return Level.MEDIUM;
		case "HARD":
			return Level.HARD;
		}
		return null;
	}
}
