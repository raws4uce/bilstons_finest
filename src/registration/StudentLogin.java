package registration;

import org.mindrot.jbcrypt.BCrypt;

import restart.ClManager;
import restart.MainSingleton;
import restart.Sql_bs;
/*
 * Singleton Class Key
 * Get
 * 
 * Set
 * 
 * Username
 */
public class StudentLogin extends LoginParent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ClManager card = new ClManager();

	private static final String SALT = "$2a$10$theSaltValue1234567890";
	Sql_bs bs = new Sql_bs();

	public StudentLogin(ClManager card) {
		super(card);
		// TODO Auto-generated constructor stub
	}

	@Override	
	public boolean nextPanel(){
		String inputUsernameLI = usernametxt.getText();
		String inputPasswordLI = passwordtxt.getText();
		System.out.println(inputPasswordLI);
		String hashed = BCrypt.hashpw(inputPasswordLI, SALT);
		if(db.StudentspwAuthentication(inputUsernameLI, hashed)) {
			MainSingleton.getInstance().setUsername(inputUsernameLI);
			String Class =  bs.getClass(inputUsernameLI);
			MainSingleton.getInstance().setUclass(Class);
			return true;

		}else {
			invalidlbl.setVisible(true);
		}
		return false;
	}
	@Override
	public String previousPanel(){
		String x = "ssignup";
		return x;
	}
	@Override
	public String accMeth(){
		String y = "student account";
		return y;
	}
}