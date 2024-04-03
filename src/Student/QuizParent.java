package Student;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import restart.ClManager;
import restart.main;
import restart.MainSingleton;
import restart.Sql_bs;
/*
 * Singleton Class Key
 * Get
 * question data
 * topic
 * time taken
 * difficulty
 * userid
 * hintArr
 * 
 * Set
 * question Data
 * Correct count
 * incorrect count
 * Time Taken
 */
public abstract class QuizParent extends JPanel implements Quiz{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btn;
	private JLabel Hlbl;
	protected JLabel Qlbl;
	private JLabel Clbl;
	private JLabel inClbl;
	private JTextField txt;
	Sql_bs bs = new Sql_bs();
	ClManager lecard = new ClManager();
	public String userType, topic;
	public static JLabel correct_lbl, incorrect_lbl;
	int counter = 0, ii = 0;
	public int correctcount, incorrectcount;

	public QuizParent(ClManager card) {
		lecard = card;
		setLayout(new GridBagLayout());
		//title row
		GridBagConstraints c = new GridBagConstraints();

		Qlbl = new JLabel("questionlbl", SwingConstants.LEFT);
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth =1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(10, 10, 10, 10);
		add(Qlbl, c);
		c.fill = GridBagConstraints.NONE;
		c.insets = new Insets(0,0,0,0);
		Hlbl = new JLabel("Hlbl", SwingConstants.RIGHT);
		c.gridx++;
		c.gridwidth=1;
		c.fill = GridBagConstraints.HORIZONTAL;
		add(Hlbl,c);
		//new row
		Clbl = new JLabel("corr", SwingConstants.RIGHT);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridy++;
		c.gridx=2;
		c.gridwidth = 1;
		add(Clbl,c);
		//new row
		txt = new JTextField();
		c.ipadx = 35;
		//		c.insets = new Insets(0,100,0,0);
		c.gridy++;
		c.gridx=0;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		add(txt,c);
		//		c.ipadx = 0;
		inClbl = new JLabel("incorr", SwingConstants.RIGHT);
		c.gridx=2;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth =1;
		add(inClbl,c);
		//new row
		btn = new JButton("Submit");
		btn.addActionListener(new SubmitListener());
		c.gridy++;
		c.gridx=2;
		c.gridwidth=1;
		c.fill = GridBagConstraints.HORIZONTAL;
		add(btn,c);
	}
	private class SubmitListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				ArrayList<String> questionDataArr = new ArrayList<String>();
				questionDataArr =  MainSingleton.getInstance().getQuestion();
				topic = MainSingleton.getInstance().getTopic();
				LocalDateTime date = LocalDateTime.now();    
				DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				String dateDB = date.format(format);

				long questionStartTime = MainSingleton.getInstance().getTimeTakenNorm();
				long timetaken = System.currentTimeMillis() - questionStartTime;
				int time = (int) (timetaken / 1000);
				int answer = Integer.parseInt(txt.getText());
				System.out.println(questionDataArr);
				int answerDB = Integer.parseInt(questionDataArr.get(2));

				boolean correct = false;
				Clbl.setVisible(false);
				inClbl.setVisible(false);
				try {
					boolean value = false;
					setDetails();
					Level diff = MainSingleton.getInstance().getDifficulty();
					int UserID = MainSingleton.getInstance().getUserID();
					// whatever is in txt box should be an integer or at least a float		
					// make a function that validates the answer from txt box
					String id = questionDataArr.get(0);
					if (answer == answerDB){
						correct = true;	
						Clbl.setVisible(!Clbl.isVisible());
						System.out.println("correct");
						correctcount++;

						dataStore(UserID, answer, correct, dateDB, time, diff, id, topic, answerDB);

						Level diffy = MainSingleton.getInstance().getDifficulty();
						questionDataArr = bs.selectQuestion(diffy);
						System.out.println("question text: " + questionDataArr.get(0));
						MainSingleton.getInstance().setQuestion(questionDataArr);
						setLabel(questionDataArr.get(1));
						value = false;
						Hlbl.setVisible(false);
					}else {
						correct = false;
						inClbl.setVisible(!inClbl.isVisible());
						System.out.println("incorrect");
						incorrectcount++;
						System.out.println(ii + ", "+ correct + ", " + condition());
						if(!(ii>=3 || correct || condition())) {dataStore(UserID, answer, correct, dateDB, time, diff, id, topic, answerDB);
						ii++;
						System.out.println(ii);
						if(ii == 3) {value = true;}
						}
						if (value) {
							Level diffy = MainSingleton.getInstance().getDifficulty();
							questionDataArr = bs.selectQuestion(diffy);
							System.out.println("question text: " + questionDataArr.get(0));
							MainSingleton.getInstance().setQuestion(questionDataArr);
							setLabel(questionDataArr.get(1));
							ii=0;
						}
						//Hint selection
						ArrayList<String> hintidarr = new ArrayList<>();
						Random random = new Random();
						switch (topic) {
						case "add": hintidarr = MainSingleton.getInstance().getAddHint();
						break;
						case "mul": hintidarr = MainSingleton.getInstance().getMulHint();
						break;
						case "sub": hintidarr = MainSingleton.getInstance().getSubHint();
						break;
						case "div": hintidarr = MainSingleton.getInstance().getDivHint();
						break;
						}
						int randomnum = random.nextInt(hintidarr.size());
						int hintid = Integer.parseInt(hintidarr.get(randomnum));
						String hint = bs.getHint(hintid);
						Hlbl.setText(hint);
						Hlbl.setVisible(true);
					}
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println("input an integer");
					e2.printStackTrace();
				}
				String nextPanel = endPanel();
				counter++;
				//				condition();
				if (condition()) {
					MainSingleton.getInstance().setcorrectcount(correctcount);
					MainSingleton.getInstance().setincorrectcount(incorrectcount);
					lecard.showPanel(nextPanel);
					counter = 0;
				}
				txt.setText("");

				repaint();
				MainSingleton.getInstance().setTimeTakenNorm(System.currentTimeMillis());
		} catch (Exception e2) {
			main frame = new main();
			JOptionPane.showMessageDialog(frame,
				    "Please ensure THIS Textfield have been filled with AN Integer",
				    "silly error",
				    JOptionPane.ERROR_MESSAGE);
		}

	}
	}

	@Override
	public abstract void setDetails();
	@Override
	public abstract void dataStore(int userID, int answer, boolean correct,String date, int time, Level val,String questionid, String topic, int answerDB);
	@Override
	public abstract String endPanel();
	@Override
	public abstract boolean condition();


	public void setLabel(String questionDataArr)  {
		Qlbl.setText(questionDataArr);
		repaint();
	}
}
