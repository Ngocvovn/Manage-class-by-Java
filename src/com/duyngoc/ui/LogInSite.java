package com.duyngoc.ui;

import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.duyngoc.service.AppService;
import com.duyngoc.service.AppServiceImpl;

public class LogInSite extends JFrame {
	private static final boolean RIGHT_TO_LEFT = false;
	private static final boolean SHOULD_WEIGHTX = true;
	private static final boolean SHOULD_FILL = true;

	private AppService _service;

	public LogInSite(AppService service) {
		_service = service;
		initUI();
		setLocationRelativeTo(null);
		setTitle("Log in");
		setSize(300, 200);
		setResizable(true);

	}

	JButton button;
	JButton button1;
	JTextField userName;
	JPasswordField passWord;
	JCheckBox check;
	JLabel pass;
	JLabel use;
	JMenuBar menuBar;
	JMenu menu;
	JMenuItem menuItem;
	JTable table;

	Connection con;
	ResultSet result;

	java.sql.Statement statement;
	PreparedStatement preparedStatement;

	private void gridBagLayout(Container pane1) {
		menuBar = new JMenuBar();
		menu = new JMenu("Menu");
		this.setJMenuBar(menuBar);
		menuItem = new JMenuItem("Exit");
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});

		menu.add(menuItem);

		menuBar.add(menu);
		if (RIGHT_TO_LEFT) {
			pane1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		}
		pane1.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		if (SHOULD_FILL) {
			c.fill = GridBagConstraints.HORIZONTAL;
		}
		button = new JButton("Log in");
		// c.fill = GridBagConstraints.HORIZONTAL;
		c.gridy = 2;
		c.gridx = 2;
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame frame = new JFrame();
				char[] passwo = passWord.getPassword();
				String password = new String(passwo);
				String user = new String(userName.getText());
				if (_service.login(user, password)) {
					Table table1 = new Table(_service);
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(frame, "Wrong", "Insane error", JOptionPane.ERROR_MESSAGE);
				}

				/*
				 * if(user.equals("ngocvodoi")){
				 * if(password.equals("ngocvodoi")){
				 * JOptionPane.showMessageDialog(frame, "Ok", "Success",
				 * JOptionPane.PLAIN_MESSAGE); System.out.println("asda"); } }
				 * else{ System.out.println("fdsfsf");
				 * 
				 * JOptionPane.showMessageDialog(frame, "Wrong", "Insane error",
				 * JOptionPane.ERROR_MESSAGE);
				 * 
				 * }
				 * 
				 * }
				 */

			}
		});
		pane1.add(button, c);

		button1 = new JButton("Cancel");
		// c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0, 0, 0, 10);
		c.gridx = 1;
		c.gridy = 2;
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();
				Object[] options = { "Yes", "No" };
				int n = JOptionPane.showOptionDialog(frame, "Quit", "Question", JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				if (n == 0) {
					System.exit(0);
				} else {

				}

			}
		});
		pane1.add(button1, c);

		userName = new JTextField();
		// c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0, 0, 15, 0);
		c.gridx = 2;
		c.gridy = 0;

		userName.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		pane1.add(userName, c);

		pass = new JLabel();
		c.gridx = 0;
		c.gridy = 1;
		pass.setText("Password");
		pane1.add(pass, c);

		pass = new JLabel();
		c.gridx = 0;
		c.insets = new Insets(0, 0, 15, 0);
		c.gridy = 0;
		pass.setText("Username");
		pane1.add(pass, c);

		passWord = new JPasswordField();
		c.gridx = 2;
		c.gridy = 1;

		// passWord.addActionListener(this);
		pane1.add(passWord, c);

	}

	private void initUI() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		gridBagLayout(getContentPane());
		pack();
		setVisible(true);

	}

/*	public void close() {
		try {
			if (result != null) {
				result.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (con != null) {
				con.close();
			}
		} catch (Exception e) {

		}
	}*/

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				AppService appService = new AppServiceImpl();
				LogInSite lo = new LogInSite(appService);

			}
		});
	}

	/*
	 * @Override if(e.getSource().equals(button)){ login(); } public void
	 * actionPerformed(ActionEvent e) {
	 * 
	 * }
	 */

}
