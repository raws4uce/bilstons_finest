package registration;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import restart.ClManager;

public abstract class LoginParent extends JPanel implements Login{
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	DbManager db = new DbManager();
	private ClManager lecard = new ClManager();
	final protected JTextField usernametxt;
	final protected JTextField passwordtxt;
	final protected JLabel invalidlbl;
	private JLabel lbl;
	private JButton button;
	public LoginParent(final ClManager card) {
		lecard = card;
		GridBagLayout gridBagLayout = new GridBagLayout();
		setLayout(gridBagLayout);
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.NORTH;
		c.weightx = .5;
		c.gridx = 0;
		c.gridy = 0;
		c.fill = GridBagConstraints.HORIZONTAL;
		//title
		lbl = new JLabel("log in", SwingConstants.CENTER);
		c.gridwidth = 5;		
		add(lbl, c);
		//new row
		lbl = new JLabel("username", SwingConstants.LEFT);
		c.gridx =0;
		c.gridy++;
		add(lbl,c);

		usernametxt = new JTextField();
		c.gridx++;
		c.ipady = 20;
		c.insets = new Insets(5, 75, 5, 2);
		c.fill = GridBagConstraints.HORIZONTAL;
		add(usernametxt,c);
		c.insets = new Insets(0,0,0,0);
		//new row
		
		lbl = new JLabel("password", SwingConstants.LEFT);
		c.gridy++;
		c.gridx =0;
		add(lbl,c);
		//new row
		
		passwordtxt = new JTextField();
		c.gridx =0;
		c.ipady = 20;
		c.insets = new Insets(5, 75, 5, 2);
		c.fill = GridBagConstraints.HORIZONTAL;
		add(passwordtxt,c);
		c.insets = new Insets(0,0,0,0);
		c.ipady = 0;
		//new row
		button = new JButton("SUBMIT");
		button.addActionListener(new SubmitListener());
		c.gridx = 0;
		c.gridy++;
		c.insets = new Insets(5, 7, 5, 7);

		c.gridx++;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		add(button,c);
		//new row
		button = new JButton("new user?");
		button.addActionListener(new NewUserListener());
		c.gridx=0;
		c.gridy++;
		c.gridx++;
		add(button,c);
		//new row
		c.gridx=0;
		c.gridy++;
		invalidlbl = new JLabel("Invalid Password", SwingConstants.LEFT);
    	invalidlbl.setVisible(false);
		add(invalidlbl,c);
	}
	private class SubmitListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
        	invalidlbl.setVisible(false);
        	boolean next = nextPanel();
        	if(next) {
        		String n = accMeth();
        		lecard.showPanel(n);
        	}
            usernametxt.setText("");
            passwordtxt.setText("");
		}
	}
	private class NewUserListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String x = previousPanel();
			lecard.showPanel(x);
		}
	}
	public abstract boolean nextPanel();
	public abstract String previousPanel();
	public abstract String accMeth();
}

