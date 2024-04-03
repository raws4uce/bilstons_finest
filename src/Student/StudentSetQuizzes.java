package Student;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import restart.MainSingleton;
import restart.ClManager;
import restart.main;
import restart.Sql_bs;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StudentSetQuizzes extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btn;
	private JLabel lbl;
	private JCheckBox EZbx, MDbx, HDbx;
	private JTextField normtxt, timetxt;
	private ClManager lecard;
	private Sql_bs bs = new Sql_bs();
	boolean continuenow = false;
	public static ArrayList<String> questionDataArr = new ArrayList<>();
	/**
	 * Create the panel.
	 */
	public StudentSetQuizzes(ClManager card) {
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
		btn.addActionListener(new NormalQuizListener());
		c.insets = new Insets(5,5,5,5);
		c.gridx=0;
		c.gridy++;
		c.gridwidth = 1;
		c.gridheight = 1; 
		c.fill = GridBagConstraints.BOTH;
		add(btn, c);

		lbl = new JLabel("<html>the amount of questions<br> you want to answer (int only)</html>", SwingConstants.CENTER);
		c.gridx++;
		c.gridwidth = 1; 
		c.fill = GridBagConstraints.HORIZONTAL;
		add(lbl,c);
		normtxt = new JTextField();
		c.gridx++;
		c.insets = new Insets(15,15,15,15);
		c.gridwidth = 1; 
		c.ipadx = 40;
		c.fill = GridBagConstraints.HORIZONTAL;
		add(normtxt,c);
		//new row
		btn = new JButton("timed");
		btn.addActionListener(new TimeQuizListener());
		c.gridy++;
		c.gridx=0;
		c.gridwidth = 1;
		c.gridheight = 1;  
		c.ipady = 10;
		c.ipadx= 60;
		c.fill = GridBagConstraints.BOTH;
		add(btn,c);
		lbl = new JLabel("(how long the quiz would last)", SwingConstants.CENTER);
		c.gridx++;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		add(lbl, c);
		timetxt = new JTextField();
		c.gridx++;
		c.insets = new Insets(15,15,15,15);
		c.gridwidth = 1; 
		c.ipadx = 40;
		c.fill = GridBagConstraints.HORIZONTAL;
		add(timetxt,c);

		//new row
		EZbx = new JCheckBox("EASY");
		c.gridx=0;
		c.gridy++;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		add(EZbx, c);
		MDbx = new JCheckBox("MEDIUM");
		c.gridx++;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		add(MDbx, c);
		HDbx = new JCheckBox("HARD");
		c.gridx++;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		add(HDbx, c);		

		//last row
		btn = new JButton("Home sweet home?");
		btn.addActionListener(new HSHListener());
		c.gridy++;
		c.gridx =0;
		c.gridwidth = 3;
		c.fill = GridBagConstraints.HORIZONTAL;
		add(btn,c);


	}
	private class HSHListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			lecard.showPanel("student account");

		}

	}
	private class NormalQuizListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try {
				Level dif = difficulty();
				MainSingleton.getInstance().setDifficulty(dif);
				questionDataArr = bs.selectQuestion(dif);
				System.out.println("this " + questionDataArr);
				MainSingleton.getInstance().setQuestion(questionDataArr);
				long questionStartTime = System.currentTimeMillis();
				MainSingleton.getInstance().setTimeTakenNorm(questionStartTime);
				//				MODEnormal.setLbl(questionDataArr);
				if(continuenow) {
					String text = normtxt.getText();
					if(!text.isEmpty()) {
						int n0 = Integer.parseInt(text);
						MainSingleton.getInstance().setNumQuestions(n0);
						MODE_normal mode_normal = new MODE_normal(null);
						mode_normal.setLabel(questionDataArr.get(1));
						repaint();
						lecard.showPanel("quiz normal");
						revalidate();
						repaint();
						normtxt.setText("");
					} else {
						System.out.println("textField needs numba");
					}
				}	
			} catch (Exception e2) {
				main frame = new main();
				JOptionPane.showMessageDialog(frame,
					    "Please ensure that all Textfields have been filled with Integers",
					    "no strings",
					    JOptionPane.ERROR_MESSAGE);
			}

		}
	}
	private class TimeQuizListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Level dif = difficulty();
			MainSingleton.getInstance().setDifficulty(dif);
			questionDataArr = bs.selectQuestion(dif);
			MainSingleton.getInstance().setQuestion(questionDataArr);
			//				MODEtime.setLbl(questionDataArr);
			if(!(timetxt.getText()).isEmpty()) {
				long startTimer = System.currentTimeMillis();
				MainSingleton.getInstance().setTimeTaken(startTimer);
				long time = Long.parseLong(timetxt.getText());
				MainSingleton.getInstance().setInputTime(time);
				MODE_time timeM = new MODE_time(null);
				timeM.setLabel(questionDataArr.get(1));
				lecard.showPanel("quiz time");
				revalidate();
				repaint();
				timetxt.setText("");
			}else {
				System.out.println("textField needs numba");
			}
		}	
	}

	public Level difficulty() {
		boolean easy = EZbx.isSelected();
		boolean mid = MDbx.isSelected();
		boolean hard = HDbx.isSelected();
		Level myVar = null;
		if(easy && hard && mid) {
			continuenow = false;
		}else{
			if(easy) {
				myVar = Level.EASY;

			}else if(mid) {
				myVar = Level.MEDIUM;

			}else if(hard) {
				myVar = Level.HARD;

			}
			continuenow = true;		
			return myVar;

		}
		return null;
	}
}
