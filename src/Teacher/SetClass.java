package Teacher;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import restart.ClManager;
import restart.main;
import restart.MainSingleton;
import restart.Sql_bs;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

/*
 * Singleton Class Key
 * Get
 * TeacherName
 * Set
 */
//Very buggy do what you want to the list, when your happy, and only when your happy with the class, you can input a name for the class in the textfield, else freeze;
public class SetClass extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btn;
	private JLabel lbl;
	private JTextField Stxt, Ctxt;
	private JList<String> list;
	
	Sql_bs bs = new Sql_bs();
	
	private DefaultListModel<String> Class = new DefaultListModel<>();
	/**
	 * Create the panel.
	 */
	public SetClass(ClManager card) {
		setLayout(new GridBagLayout());
		//1st row
		GridBagConstraints c = new GridBagConstraints();

		lbl = new JLabel("Search For Students:", SwingConstants.LEFT);
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth =1;
		c.ipadx = 10;
		c.fill = GridBagConstraints.HORIZONTAL;
		add(lbl, c);
		c.ipadx =0;
		Stxt = new JTextField();
		c.gridx++;
		c.ipadx = 40;
		c.gridwidth =1;
		c.insets = new Insets(0,0,0,15);
		c.fill = GridBagConstraints.HORIZONTAL;
		add(Stxt,c);
		c.ipadx = 5;
		lbl = new JLabel("Class Name: ");
		c.gridx++;
		c.gridwidth =1;
		c.fill = GridBagConstraints.HORIZONTAL;
		add(lbl,c);
		Ctxt = new JTextField();
		c.gridx++;
		c.ipadx=45;
		c.gridwidth =1;
		c.fill = GridBagConstraints.HORIZONTAL;
		add(Ctxt,c);
		c.insets = new Insets(5,20,5,20);
		//jlist 7 down
		btn = new JButton("Search");
		btn.addActionListener(new SearchListener());
		c.gridy++;
		c.gridx=1;
		c.gridwidth = 1;
		add(btn,c);
		//jlist 7 down
		btn = new JButton("add");
		btn.addActionListener(new AddStudentListener());
		c.gridy++;
		c.gridx=1;
		c.gridwidth = 1;
		add(btn,c);
		//jlist 7 down
		btn = new JButton("remove");
		btn.addActionListener(new RemoveStudentListener());
		c.gridy++;
		c.gridx=1;
		c.gridwidth = 1;
		add(btn,c);
		//jlist 7 down
		btn = new JButton("view class");
		btn.addActionListener(new ViewClassListener());
		c.gridy++;
		c.gridx=1;
		c.gridwidth = 1;
		add(btn,c);
		//jlist 7 down
		btn = new JButton("create class");
		btn.addActionListener(new ClassCreationListener());
		c.gridy++;
		c.gridx=1;
		c.gridwidth = 1;
		add(btn,c);
		//list
//        DefaultListModel<String> mod = new DefaultListModel<>();
//        listModel.addElement("Item 1");
//        listModel.addElement("Item 2");
//        listModel.addElement("");
		list = new JList<String>(Class);
		c.gridx=0;
		c.gridy =1;
		c.gridheight=7;//Potential future issue-> too many students (add scroll bar and such)
		c.gridwidth =1;
		c.fill = GridBagConstraints.HORIZONTAL;
		add(list,c);
	}
	private class SearchListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String TeacherName = MainSingleton.getInstance().getTeacherName();
			String School = bs.getSchool(TeacherName);
			String studentsName = Stxt.getText();
			if(Stxt.getText().isEmpty()) {
				studentsName = "ALL";
			}
			DefaultListModel<String> searchStudents = bs.searchStudents(School, studentsName);
			if (searchStudents == null || searchStudents.getSize() == 0) {
				list.setModel(searchStudents);
				//setlbl which says no bueno  
			} else {
				list.setModel(searchStudents);
			}
			list.repaint();
		}
	}
	private class AddStudentListener  implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			DefaultListModel<String> model = (DefaultListModel<String>) list.getModel();
			for (int i = 0; i < model.getSize(); i++) {
				Class.add(i, model.getElementAt(i));
			}

		}
	}
	private class RemoveStudentListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			//remove all students in JList in class array
			DefaultListModel<String> model = (DefaultListModel<String>) list.getModel();
			String value = Stxt.getText();
			for(int k = 0; k<model.getSize(); k++) {
				if(model.elementAt(k).equals(value)) {
					model.remove(k);
				}
			}
		}
	}
	private class ClassCreationListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			//inserts appropriate data in database
			String className = Ctxt.getText();
			System.out.println(className);
			bs.createClass(Class, className);
			main frame = new main();
			JOptionPane.showMessageDialog(frame,
				    "<html>The students class column has been updated<br>it has been stored</html>");
		}
	}
	private class ViewClassListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			//class array displayed in JList
			list.setModel(Class);
		}
	}
}
