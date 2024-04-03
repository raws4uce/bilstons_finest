package Zbin;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import restart.MainSingleton;
import restart.ClManager;
import restart.Sql_bs;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class test extends JPanel {
	private JCheckBox normbx,timebx,ezbx,mdbx,hdbx;
	private JButton btn;
	private JLabel lbl;
	private JTextField clstxt, spectxt, datetxt;
	private JList<String> list;
	private ClManager lecard;
	private Sql_bs bs = new Sql_bs();
	/**
	 * Create the panel.
	 */
	public test(ClManager card) {
		lecard = card;
		setLayout(new GridBagLayout());
		//1st row
		GridBagConstraints c = new GridBagConstraints();

		lbl = new JLabel("Select the class");
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth =1;
		c.fill = GridBagConstraints.HORIZONTAL;
		add(lbl, c);
		//new row
		clstxt = new JTextField();
		c.gridx=0;
		c.gridy++;
		c.gridwidth=1;
		c.fill = GridBagConstraints.HORIZONTAL;
		add(clstxt,c);
		btn = new JButton("enter");
		btn.addActionListener(new SelectClassListener());
		c.gridx++;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth =1;
		c.insets = new Insets(5,15,05,15);
		add(btn,c);
		lbl = new JLabel("Select quiz mode", SwingConstants.RIGHT);
		c.gridx++;
		add(lbl,c);
		//new row
		list = new JList<String>();
		c.gridy++;
		c.gridx=0;
		c.gridwidth=2;
		c.gridheight=8;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 20;
		add(list,c);
		normbx = new JCheckBox("normal");
		c.gridx=2;
		c.gridheight=1;
		c.gridwidth=1;
		add(normbx,c);
		spectxt = new JTextField();
		c.insets = new Insets(0,15,0,0);
		c.ipadx = 35;
		c.gridx++;
		add(spectxt,c);
		//new eow
		timebx = new JCheckBox("time");
		c.gridx = 2;
		c.gridy++;
		c.fill = GridBagConstraints.HORIZONTAL;
		add(timebx,c);
		//new row
		lbl = new JLabel(" Select difficulty ", SwingConstants.RIGHT);
		c.gridy++;
		c.ipadx =35;
		add(lbl,c);
		//box rows
		ezbx = new JCheckBox("Easy");
		c.gridy++;
		add(ezbx,c);
		mdbx = new JCheckBox("Medium");
		c.gridy++;
		add(mdbx,c);
		hdbx = new JCheckBox("Hard");
		c.gridy++;
		add(hdbx,c);
		//new row
		lbl = new JLabel("format(yyyy-MM-dd) Due Date:", SwingConstants.RIGHT);
		c.gridy++;
		add(lbl,c);
		datetxt = new JTextField();
		c.gridx++;
		c.ipadx = 75;
		add(datetxt,c);
		//last row
		btn = new JButton("Home?");
		btn.addActionListener(new HomeListener());
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(10,0,0,0);
		c.gridy++;
		c.gridx = 0;
		c.gridwidth =5;
		add(btn,c);
	}
	private class HomeListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			lecard.showPanel("taccess");
		}
		
	}
	private class SelectClassListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String searchText = clstxt.getText();
			DefaultListModel allStudents = bs.getAllstudents(searchText);
			list.setModel(allStudents);
			repaint();			
		}
	}
	private class SetQuizListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String inputText = spectxt.getText();
			String searchText = clstxt.getText();
			String dueDate = datetxt.getText();
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				sdf.setLenient(false);
				sdf.parse(dueDate);
				int c = Integer.parseInt(inputText);
				String spec = ""+c+""; //looks stupid but i needed to make sure it is an integer
				String quizType = "";
//				if(!((normalCheckBox.isSelected() && timedCheckBox.isSelected()) || (!normalCheckBox.isSelected() && !timedCheckBox.isSelected()))) {
//				} else {
					if(normbx.isSelected() && !(timebx.isSelected())) {quizType = "norm";} 
					if(timebx.isSelected() && !(normbx.isSelected())) {quizType = "time";}
//				}
				String diff = "";
				if(ezbx.isSelected() && !(hdbx.isSelected() || mdbx.isSelected())) {diff= "EASY";}
				if(mdbx.isSelected() && !(hdbx.isSelected() || ezbx.isSelected())) {diff = "MEDIUM";}
				if(hdbx.isSelected() && !(ezbx.isSelected() || mdbx.isSelected())) {diff = "HARD";}

				String teacher = MainSingleton.getInstance().getTeacherName();
				bs.storeQuiz(teacher, searchText, quizType, spec, diff, dueDate);
				System.out.println("you did it");
				//setLbl true quiz is set
				spectxt.setText("");
				normbx.setSelected(false);	
				timebx.setSelected(false);
				ezbx.setSelected(false);
				mdbx.setSelected(false);
				hdbx.setSelected(false);
			} catch (ParseException e5) {
				e5.printStackTrace();
			}
		}
	}
}
