package Student;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import restart.MainSingleton;
import restart.ClManager;
import restart.main;
import restart.Sql_bs;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class StudentAccount extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btn;
	private JLabel lbl;
	private ClManager lecard;
	private Sql_bs bs = new Sql_bs();
	/**
	 * Create the panel.
	 */
	public StudentAccount(ClManager card) {
		lecard = card;
		setLayout(new GridBagLayout());

		btn = new JButton();
		lbl = new JLabel();
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.NONE;

		c.gridx =0;
		c.gridy = 0;

		//title row
		lbl = new JLabel("Welcome Sir", SwingConstants.CENTER);
		c.insets = new Insets(10,10,10,10);
		add(lbl,c);
		c.insets = new Insets(0,0,0,0);

		//new row
		//the buggy one(ran out of time)
		c.insets = new Insets(25,25,25,25);
		btn = new JButton("check out the teachers quiz");
		btn.addActionListener(new Tquiz_Listener());
		c.gridx=0;
		c.gridy++;
		add(btn,c);
		c.gridx++;
		btn=new JButton("do your own quiz");
		btn.addActionListener(new Squiz_Listener());
		c.gridx++;
		add(btn,c);
		btn=new JButton("Sign out ruudboi");
		btn.addActionListener(new SignOutListener());
		c.gridx++;
		add(btn,c);

	}
	//	public void actionPerformed(ActionEvent e) {
	private class Tquiz_Listener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String user = MainSingleton.getInstance().getUsername();
			int id = bs.getUserID(user);
			ArrayList<String> complete = new ArrayList<>();
			complete = bs.getCompletedQuiz(id);
			String cls = MainSingleton.getInstance().getUclass();
			Boolean noMoreQuizzes = bs.getQuizData(cls, complete);
			//if teacher only (ever) set one quiz, Student will still
			//have access to teachers quizzes panel because of if statement
			if(noMoreQuizzes) {
				lecard.showPanel("teachers quizzes");
			}else {
				main frame = new main();
				JOptionPane.showMessageDialog(frame,
					    "You have no more quizzes buddy, be proud of yourself"
					    );
			}

		}

	}
	private class Squiz_Listener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			lecard.showPanel("students quizzes");
		}	
	}
	private class SignOutListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			lecard.showPanel("slogin");
		}
	}
}
