package Student;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import restart.MainSingleton;
import restart.ClManager;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class End_quiz extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btn;
	private JLabel lbl, Correctlbl, inCorrectlbl;
	private ClManager lecard;
	boolean continuenow = false;
	public static ArrayList<String> questionDataArr = new ArrayList<>();
	/**
	 * Create the panel.
	 */
	public End_quiz(ClManager card) {
		lecard = card;
		setLayout(new GridBagLayout());
		//title row
		GridBagConstraints c = new GridBagConstraints();

		lbl = new JLabel("quiz results", SwingConstants.CENTER);
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(10, 10, 10, 10);
		add(lbl, c);
		c.fill = GridBagConstraints.NONE;
		c.insets = new Insets(0,0,0,0);

		//new row
		btn = new JButton("Would you like to see your results");
		btn.addActionListener(new SeePerformanceListener());
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridy++;
		c.gridx=0;
		c.gridwidth = 2;
		add(btn,c);
		//new row
		Correctlbl = new JLabel("corre");
		c.gridy++;
		c.gridx=0;
		c.ipadx = 75;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		add(Correctlbl,c);
		inCorrectlbl = new JLabel("incorr");
		c.gridx++;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth =1;
		add(inCorrectlbl,c);
		//new row
		btn = new JButton("main home");
		btn.addActionListener(new MainHomeListener());
		c.gridy++;
		c.gridx=0;
		c.gridwidth=2;
		c.fill = GridBagConstraints.HORIZONTAL;
		add(btn,c);
	}

	private class SeePerformanceListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int correct = MainSingleton.getInstance().getCorrect();
			int incorrect = MainSingleton.getInstance().getInCorrect();
			Correctlbl.setText("this is the correct value, " + String.valueOf(correct));
			inCorrectlbl.setText("this is the incorrect value, " + String.valueOf(incorrect));
			MainSingleton.getInstance().setcorrectcount(0);
			MainSingleton.getInstance().setincorrectcount(0);
			incorrect = 0;
			correct = 0;
			revalidate();
			repaint();

		}

	}
	private class MainHomeListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			lecard.showPanel("student account");
		}
	}
}
