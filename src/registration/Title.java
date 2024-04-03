package registration;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import restart.ClManager;

public class Title extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final private ClManager lecard;
	/**
	 * Create the panel.
	 */
	public Title(final ClManager card) {
		setLayout(new GridBagLayout());
		lecard = card;
		JButton button;
		GridBagConstraints c = new GridBagConstraints();
		
		button = new JButton("Student log in?");
		button.addActionListener(new StudentLI_Listener());
		c.gridx=0;
		c.gridy=0;
		add(button,c);

		button = new JButton("Teacher log in?");
		button.addActionListener(new TeacherLI_Listener());
		c.gridx++;
		c.gridy++;
		add(button,c);

		button = new JButton("Student sign up?");
		button.addActionListener(new StudentSU_Listener());
		c.gridx++;
		c.gridy++;
		add(button,c);

		button = new JButton("Teacher sign up?");
		button.addActionListener(new TeacherSU_Listener());
		c.gridx++;
		c.gridy++;
		add(button,c);

	}
	private class StudentLI_Listener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			lecard.showPanel("slogin");
		}
	}
	private class TeacherLI_Listener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			lecard.showPanel("tlogin");
		}
	}
	private class StudentSU_Listener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			lecard.showPanel("ssignup");
		}
	}
	private class TeacherSU_Listener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			lecard.showPanel("tsignup");
		}
	}

}
