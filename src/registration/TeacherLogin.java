package registration;

import org.mindrot.jbcrypt.BCrypt;
import restart.ClManager;
import restart.MainSingleton;

/*
 * Singleton Class Key
 * Get
 * 
 * Set
 * Teachers Name
 */
public class TeacherLogin extends LoginParent {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
ClManager card = new ClManager();
private static final String SALT = "$2a$10$theSaltValue1234567890";

public TeacherLogin(ClManager card) {
		super(card);
		// TODO Auto-generated constructor stub
	}

	
	@Override	
	public boolean nextPanel(){
		String inputUsernameLI = usernametxt.getText();
		String inputPasswordLI = passwordtxt.getText();
		String hashed = BCrypt.hashpw(inputPasswordLI, SALT);
		MainSingleton.getInstance().setTeacherName(inputUsernameLI); 
		if(db.TeacherspwAuthentication(inputUsernameLI, hashed)) {
      	  return true;
		}else {
           invalidlbl.setVisible(true);

       }
		return false;
	}
	@Override
	public String previousPanel(){
		return "tsignup";
	}
	@Override
	public String accMeth(){
		return "taccess";
	}
}