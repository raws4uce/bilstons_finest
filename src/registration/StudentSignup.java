package registration;

import java.sql.SQLException;
import restart.ClManager;
import restart.MainSingleton;

/*
 * Singleton Class Key
 * Get
 * Username, Password, Mail, School
 * Set
 */

//StudentSignup subclass
public class StudentSignup extends SignupParent {
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
DbManager db = new DbManager();
public StudentSignup(ClManager card) {	
   super(card);
}

@Override
public void registerUser() {
   System.out.println("Student registration logic");
   String un = MainSingleton.getInstance().getUsername();
   String pw  = MainSingleton.getInstance().getPassword();
   String mail = MainSingleton.getInstance().getMail();
   String sch = MainSingleton.getInstance().getSchool();

   ClManager card = new ClManager();
       try {
		db.studentCreation(un, pw, sch, mail);
		card.showPanel("slogin");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
@Override
public String nextPanel() {
	String p = "slogin";
	return p;
}

}