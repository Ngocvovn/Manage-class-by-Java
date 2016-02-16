package com.duyngoc.ui;

import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.duyngoc.service.AppService;

public class AddStudentWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<AddStudentListener> addStudentListener = new ArrayList<AddStudentListener>();

	private ModelTable tm;

	public void addAddStudentListener(AddStudentListener listener) {
		addStudentListener.add(listener);
	}

	AppService service;

	public AddStudentWindow(ModelTable tm1, AppService service) {
		tm = tm1;
		this.service = service;
		setSize(400, 400);
		setLocationRelativeTo(null);
		setTitle("Add student");

		initUI();
		// pack();
	}

	JButton add;
	JButton cancel;
	JTextField first;
	JTextField last;
	JTextField I;
	JTextField ad;
	JTextField Good;
	JTextField emai;
	JLabel Name;
	JLabel lastName;
	JLabel ID;
	JLabel isGood;
	JLabel englishGrade;
	JLabel mathGrade;

	public void gridBagLayout(Container pane) {
		pane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		pane.setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();

		// c.fill=GridBagConstraints.HORIZONTAL;
		c.fill = GridBagConstraints.HORIZONTAL;
		Name = new JLabel();
		c.insets = new Insets(0, 15, 15, 15);
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0.5;
		Name.setText("Name");
		pane.add(Name, c);

		first = new JTextField();
		first.setMinimumSize(new Dimension(20, 100));
		// first.setMinimumSize(first.getPreferredSize());
		c.weightx = 1;
		// c.insets = new Insets(0, 0, 0, 15);
		c.gridx = 1;
		c.gridy = 0;
		pane.add(first, c);

		lastName = new JLabel();
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 1;
		lastName.setText("Street");
		pane.add(lastName, c);

		last = new JTextField();
		c.gridx = 1;
		c.gridy = 1;
		c.weightx = 1;
		pane.add(last, c);

		ID = new JLabel();
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 2;
		ID.setText("ID");
		pane.add(ID, c);

		I = new JTextField();
		c.weightx = 1;
		c.gridx = 1;
		c.gridy = 2;
		pane.add(I, c);

		mathGrade = new JLabel();
		c.gridx = 0;
		c.gridy = 3;
		c.weightx = 0.5;
		mathGrade.setText("Math grade");
		pane.add(mathGrade, c);

		ad = new JTextField();
		c.weightx = 1;
		c.gridx = 1;
		c.gridy = 3;
		pane.add(ad, c);

		englishGrade = new JLabel();
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 4;
		englishGrade.setText("English grade");
		pane.add(englishGrade, c);

		emai = new JTextField();
		c.weightx = 1;
		c.gridx = 1;
		c.gridy = 4;
		pane.add(emai, c);

		isGood = new JLabel();
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 5;
		isGood.setText("City");
		pane.add(isGood, c);

		Good = new JTextField();
		c.weightx = 1;
		c.gridx = 1;
		c.gridy = 5;
		pane.add(Good, c);

		add = new JButton("Add");
		c.weightx = 0.1;
		c.gridx = 1;
		c.gridy = 6;
		pane.add(add, c);

		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Student student = createNewStudent();
				service.addstudent(student);
				service.addAddress(student);
				//service.loadStudents();
				//for(Student s: service.loadStudents())
					//if 
				System.out.println(student.getID());
				/*
				 * tm.setStudents(service.loadStudents());
				 * tm.fireTableDataChanged();
				 */
				addStudent(student);

			}
		});

		cancel = new JButton("Cancel");
		c.weightx = 0.1;
		c.gridx = 0;
		c.gridy = 6;
		pane.add(cancel, c);

		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				AddStudentWindow.this.setVisible(false);
			}
		});
	}

	public Student createNewStudent() {
		Student stu = new Student();
		stu.setMath(Double.parseDouble(ad.getText()));
		stu.setEnglish(Double.parseDouble(emai.getText()));
		stu.setID(Integer.parseInt(I.getText()));
		stu.setName(first.getText());
		stu.setCity(Good.getText());
		stu.setStreet(last.getText());
		return stu;
	}

	protected void addStudent(Student s) {
		/*
		 * Student s = new Student();
		 * s.setMath(Double.parseDouble(ad.getText()));
		 * s.setEnglish(Double.parseDouble(emai.getText()));
		 * //s.setID(Integer.parseInt(I.getText())); s.setName(first.getText());
		 * //s.setLastName(Integer.parseInt(last.getText()));
		 */

		for (AddStudentListener listener : addStudentListener) {
			listener.addStudent(s);
			// listener.updateStudent(s);
		}
		// tm.addStudent(s);
		setVisible(false);
	}

	private void initUI() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		gridBagLayout(getContentPane());
		// pack();
		setVisible(true);
	}
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable(){
	// public void run(){
	// AddStudentWindow stu = new AddStudentWindow();
	// }
	// });
	// 
}
