package registration;

import restart.ClManager;
import restart.MainSingleton;

import java.sql.SQLException;
/*
 * Singleton Class Key
 * Get
 * username, password, mail, school
 * Set
 */

//TeacherSignup subclass
public class TeacherSignup extends SignupParent {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    DbManager db = new DbManager();

    public TeacherSignup(ClManager card) {
        super(card);
    }

    @Override
    public void registerUser() {
        System.out.println("teacher registration logic");
        String un = MainSingleton.getInstance().getUsername();
        String pw = MainSingleton.getInstance().getPassword();
        String mail = MainSingleton.getInstance().getMail();
        String sch = MainSingleton.getInstance().getSchool();

        ClManager card = new ClManager();
        try {
            db.teacherCreation(un, pw, sch, mail);
            card.showPanel("tlogin");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public String nextPanel() {
        String p = "tlogin";
        return p;
    }
}