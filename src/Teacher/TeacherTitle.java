package Teacher;

import javax.swing.JPanel;

import restart.ClManager;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;

public class TeacherTitle extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btn;
	public ClManager lecard;

	/**
	 * Create the panel.
	 */
	public TeacherTitle(ClManager card) {
		lecard = card;
		setLayout(new GridBagLayout());
		//1st row
		GridBagConstraints c = new GridBagConstraints();

		btn = new JButton("Set quiz?");
		btn.addActionListener(new SetQuizListener());
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth =1;
		c.fill = GridBagConstraints.HORIZONTAL;
		add(btn, c);
		//new row
		c.gridx++;
		c.gridy++;
		btn = new JButton("Set Class");//assign class to Students in same school as you
		btn.addActionListener(new SetClassListener());
		add(btn,c);
	}
	
	private class SetClassListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			lecard.showPanel("teacher setclass");
		}
	}
	private class SetQuizListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			lecard.showPanel("teacher setquiz");
		}
	}
	 
}
