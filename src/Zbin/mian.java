package Zbin;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import restart.ClManager;

public class mian extends JFrame {

	private JPanel contentPane, test;
	private ClManager card;


	/**
	 * Create the frame.
	 */
	public mian() {
	card = new ClManager();
	//panel = new panel();
	test  = new test(card);
	//card.addPanel("name", panel);
	card.addPanel("title", test);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 740, 500);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	getContentPane().setLayout(new CardLayout(0, 0));
	getContentPane().add(card, BorderLayout.CENTER);

	card.showPanel("title");
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mian frame = new mian();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
