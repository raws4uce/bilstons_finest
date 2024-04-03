package registration;

import org.mindrot.jbcrypt.BCrypt;
import restart.ClManager;
import restart.MainSingleton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Singleton Class Key
 * Get
 * 
 * password, mail, School, Username
 * 
 * Set
 */

//Signup Implementation
public abstract class SignupParent extends JPanel implements Signup {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private static final String SALT = "$2a$10$theSaltValue1234567890";

	private final DbManager db = new DbManager();
	private final JTextField SCH_txtbox_SU;
	private final JTextField UN_txtbox_SU;
	private final JTextField PW_txtbox_SU;
	private final JTextField MAIL_txtbox_SU;
	private final JLabel CheckLength_lbl_SU;
	private final JLabel PW_numCheck_lbl_SU;
	private final JLabel PW_lowerCaseCheck_lbl_SU;
	private final JLabel PW_upperCaseCheck_lbl_SU;
	private final JLabel PW_specialCharCheck_lbl_SU;
	private final JLabel PW_blanksCheck_lbl_SU;
	private final JLabel PW_sizeCheck_lbl_SU;
	private final JLabel checker_MAIL_lbl_SU;
	private final JLabel UN_lbl_check;
	private final ClManager theCard;


	public SignupParent(final ClManager card) {
		theCard = card;
		setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.NONE;

		// TITLE ROW
		JLabel SignUp_title = new JLabel("sign up", SwingConstants.CENTER);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 5;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10, 10, 10, 10);
		add(SignUp_title, gbc);


		// FIRST ROW
		++gbc.gridy;
		gbc.insets = new Insets(2, 5, 2, 5);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 1;

		JLabel UN_lbl_SU = new JLabel("username", SwingConstants.RIGHT);
		gbc.gridx = 0;
		add(UN_lbl_SU, gbc);
		UN_txtbox_SU = new JTextField();
		UN_txtbox_SU.setColumns(10);
		++gbc.gridx;
		add(UN_txtbox_SU, gbc);

		++gbc.gridx;

		JLabel PW_lbl_SU = new JLabel("password", SwingConstants.RIGHT);
		++gbc.gridx;
		add(PW_lbl_SU, gbc);
		PW_txtbox_SU = new JTextField();
		PW_txtbox_SU.setColumns(10);
		++gbc.gridx;
		add(PW_txtbox_SU, gbc);


		// SECOND ROW
		++gbc.gridy;

		JLabel SCH_lbl_SU = new JLabel("school", SwingConstants.RIGHT);
		gbc.gridx = 0;
		add(SCH_lbl_SU, gbc);
		SCH_txtbox_SU = new JTextField();
		SCH_txtbox_SU.setColumns(10);
		++gbc.gridx;
		add(SCH_txtbox_SU, gbc);

		++gbc.gridx;
		JLabel MAIL_lbl_SU = new JLabel("email", SwingConstants.RIGHT);
		++gbc.gridx;
		add(MAIL_lbl_SU, gbc);
		MAIL_txtbox_SU = new JTextField();
		MAIL_txtbox_SU.setColumns(10);
		++gbc.gridx;
		add(MAIL_txtbox_SU, gbc);

		// THIRD ROW
		++gbc.gridy;
		gbc.gridx = 2;

		JButton SU_btn = new JButton("submit");
		add(SU_btn, gbc);


		// Next, error rows!
		//This pops up when stuff went wrong
		++gbc.gridy;
		gbc.gridx = 0;
		gbc.gridwidth = 5;

		CheckLength_lbl_SU = new JLabel("one of the stuff youve typed either exceeds 50 characters, or theres nothing there");
		add(CheckLength_lbl_SU, gbc);
		CheckLength_lbl_SU.setVisible(false);

		PW_numCheck_lbl_SU = new JLabel("passwords needs a at least one number");
		//PW_numCheck_lbl_SU.setBounds(206, 258, 568, 14);
		++gbc.gridy;
		add(PW_numCheck_lbl_SU, gbc);
		PW_numCheck_lbl_SU.setVisible(false);

		PW_lowerCaseCheck_lbl_SU = new JLabel("passwords needs a at least one LowerCase letter");
		//PW_lowerCaseCheck_lbl_SU.setBounds(206, 281, 568, 14);
		++gbc.gridy;
		add(PW_lowerCaseCheck_lbl_SU, gbc);
		PW_lowerCaseCheck_lbl_SU.setVisible(false);


		PW_upperCaseCheck_lbl_SU = new JLabel("passwords needs a at least one UpperCase letter");
		//PW_upperCaseCheck_lbl_SU.setBounds(206, 306, 568, 14);
		++gbc.gridy;
		add(PW_upperCaseCheck_lbl_SU, gbc);
		PW_upperCaseCheck_lbl_SU.setVisible(false);


		PW_specialCharCheck_lbl_SU = new JLabel("passwords needs a at least one Symbol, one of these, @,#,$,%,^,&,+,=");
		//PW_specialCharCheck_lbl_SU.setBounds(206, 329, 568, 14);
		++gbc.gridy;
		add(PW_specialCharCheck_lbl_SU, gbc);
		PW_specialCharCheck_lbl_SU.setVisible(false);


		PW_blanksCheck_lbl_SU = new JLabel("password must not have any blank spaces in them");
		//PW_blanksCheck_lbl_SU.setBounds(206, 354, 568, 14);
		++gbc.gridy;
		add(PW_blanksCheck_lbl_SU, gbc);
		PW_blanksCheck_lbl_SU.setVisible(false);

		PW_sizeCheck_lbl_SU = new JLabel("passwords must be bigger than 8 characters");
		//PW_sizeCheck_lbl_SU.setBounds(206, 379, 568, 14);
		++gbc.gridy;
		add(PW_sizeCheck_lbl_SU, gbc);
		PW_sizeCheck_lbl_SU.setVisible(false);

		checker_MAIL_lbl_SU = new JLabel("email needs @ symbol");
		checker_MAIL_lbl_SU.setBounds(207, 404, 138, 14);
		++gbc.gridy;
		add(checker_MAIL_lbl_SU, gbc);
		checker_MAIL_lbl_SU.setVisible(false);

		UN_lbl_check = new JLabel("the username already exists man");
		//UN_lbl_check.setBounds(207, 429, 310, 14);
		++gbc.gridy;
		add(UN_lbl_check, gbc);
		UN_lbl_check.setVisible(false);

		SU_btn.addActionListener(new SubmitListener());
	}

	protected static boolean checkLen(String i) {
		return i.length()>0 && i.length()<50;
	}


	@Override
	public abstract void registerUser();


	@Override
	public abstract String nextPanel();


	private class SubmitListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			//gets text from textboxes, stored in variable
			String inputUN_SU = UN_txtbox_SU.getText();
			String inputPW_SU = PW_txtbox_SU.getText();
			String inputSCH_SU = SCH_txtbox_SU.getText();
			String inputMAIL_SU = MAIL_txtbox_SU.getText();

			// Check if the username already exists
			boolean lengthsOK = true; //there's something inputted in all boxes, and they're not over char
			boolean mailHasAt; //checks mail has @ symbol
			boolean passwordLooksGood = false; //checks password
			boolean usernameExists = false; //checks if same username is in the db

			String[] inputs = {inputUN_SU, inputPW_SU, inputSCH_SU, inputMAIL_SU};

			for (String i : inputs) {
				lengthsOK &= checkLen(i);
			}
			CheckLength_lbl_SU.setVisible(!lengthsOK);

			//password checks
			boolean patternNO = inputPW_SU.matches(".*[0-9].*");
			boolean patternLC = inputPW_SU.matches(".*[a-z].*");
			boolean patternUC = inputPW_SU.matches(".*[A-Z].*");
			boolean patternSC = inputPW_SU.matches(".*[@#$%^&+=].*");
			boolean patternWS = !inputPW_SU.contains(" ");
			boolean isLengthValid = inputPW_SU.length() > 7;
			passwordLooksGood = patternNO && patternLC && patternUC && patternSC && patternWS && isLengthValid;

			PW_numCheck_lbl_SU.setVisible(!patternNO);
			PW_lowerCaseCheck_lbl_SU.setVisible(!patternLC);
			PW_upperCaseCheck_lbl_SU.setVisible(!patternUC);
			PW_specialCharCheck_lbl_SU.setVisible(!patternSC);
			PW_blanksCheck_lbl_SU.setVisible(!patternWS);
			PW_sizeCheck_lbl_SU.setVisible(!isLengthValid);

			//email checks
			mailHasAt = inputMAIL_SU.contains("@");
			checker_MAIL_lbl_SU.setVisible(!mailHasAt);

			usernameExists = db.studentExistence(inputUN_SU);
			UN_lbl_check.setVisible(usernameExists);

			if (lengthsOK && mailHasAt && passwordLooksGood && !usernameExists) {
				String hashed = BCrypt.hashpw(inputPW_SU, SALT);
				System.out.println(hashed);

				MainSingleton.getInstance().setPassword(hashed);
				MainSingleton.getInstance().setMail(inputMAIL_SU);
				MainSingleton.getInstance().setSchool(inputSCH_SU);
				MainSingleton.getInstance().setUsername(inputUN_SU);
				registerUser();
				String x = nextPanel();
				theCard.showPanel(x);
			}
		}
	}
}