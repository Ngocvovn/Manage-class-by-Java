package com.duyngoc.ui;

import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.ColorModel;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JWindow;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import com.duyngoc.service.AppService;
import com.duyngoc.service.AppServiceImpl;

public class Table extends JFrame {
	static final int MAX = 100;
	private static boolean debug = false;
	JTable table;
	JButton but;
	JCheckBox chinButton;
	AddStudentWindow w;
	ModelTable tableModel;
	JButton del;
	JButton update;
	AppService service;

	public Table(AppService service) {
		this.service = service;
		initUI();
		setLocationRelativeTo(null);
		setTitle("Table");
		setSize(1000, 500);

	}

	/*
	 * private List<Student> generateStudent() { List<Student> list = new
	 * ArrayList<Student>(); for (int i = 0; i < MAX; i++) {
	 * 
	 * int ran = (int) (Math.random() * 100 + 1); Student stu = new
	 * Student(ran); list.add(stu); } return list;
	 * 
	 * }
	 */

	public void gridBagLayout(Container pane) {
		pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		tableModel = new ModelTable(service.loadStudents());
		System.out.println(service.loadStudents().get(0));
		tableModel.addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				// System.out.println("changed");
				// service.updateStudent(tableModel.getStudents().get(table.getSelectedRow()));
				tableModel.addUpdateStudentListener(new UpdateStudentListener() {

					@Override
					public void updateStudent(Student student) {
						// TODO Auto-generated method stub
						Table.this.updateStudent(student);
						// service.updateStudent(tableModel.getStudents().get(table.getSelectedRow()));
					}
				});
			}
		});

		tableModel.setListener(new Listener() {

			@Override
			public void listener(String s) {
				System.out.println(s);
			}
		});
		CheckboxRenderer cb = new CheckboxRenderer();
		TextFieldRender tx = new TextFieldRender();

		table = new JTable(tableModel) {
			public TableCellRenderer getCellRenderer(int row, int column) {
				if (column == -1) {
					// return cb;
				}
				return super.getCellRenderer(row, column);
			}
		};

		/*
		 * JCheckBox ch = new JCheckBox(); TableColumn columnGood =
		 * table.getColumnModel().getColumn(5); columnGood.setCellEditor(new
		 * DefaultCellEditor(ch));
		 */
		JScrollPane scrollPane = new JScrollPane(table);
		table.setPreferredScrollableViewportSize(new Dimension(850, 150));

		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 3;
		c.gridwidth = 10;

		pane.add(scrollPane, c);

		del = new JButton("Remove");
		c.anchor = GridBagConstraints.EAST;
		c.insets = new Insets(15, 0, 0, 0);

		c.gridx = 9;
		c.gridy = 3;
		pane.add(del, c);
		del.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// tableModel.removeStudent(table.getSelectedRows());
				for (int rowNumber : table.getSelectedRows()) {
					service.deleteStudent(tableModel.getStudents().get(rowNumber));
				}
				tableModel.removeStudent(table.getSelectedRows());

			}
		});

		/*update = new JButton("Update");
		c.gridx = 5;
		c.gridy = 3;
		c.insets = new Insets(15, 100, 0, 0);
		pane.add(update, c);
		update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				service.updateStudent(tableModel.getStudents().get(table.getSelectedRow()));
			}
		});*/

		but = new JButton("Add");

		c.gridx = 7;
		c.gridy = 3;
		c.insets = new Insets(15, 100, 0, 0);
		pane.add(but, c);

		but.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (w == null) {
					w = new AddStudentWindow(tableModel, service);
					w.addAddStudentListener(new AddStudentListener() {

						@Override
						public void addStudent(Student student) {
							reloadTable(student);
						}

						@Override
						public void updateStudent(Student student) {
							// TODO Auto-generated method stub

						}

					});

					w.addAddStudentListener(new AddStudentListener() {

						@Override
						public void addStudent(Student student) {
							System.out.println("Do something else");
						}

						@Override
						public void updateStudent(Student student) {
							// TODO Auto-generated method stub
							// updateTable();
						}
					});
				}
				w.setVisible(true);

			}
		});

		but.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("click click clock");
			}
		});
	}

	private void reloadTable(Student student) {
		// tableModel.addStudent(student);

		tableModel.setStudents(service.loadStudents());
	}

	private void updateStudent(Student student) {
		service.updateStudent(tableModel.getStudents().get(table.getSelectedRow()));
		// tableModel.setStudents(service.loadStudents());
		service.updateStudentAddress(tableModel.getStudents().get(table.getSelectedRow()));
	}

	private void initUI() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		gridBagLayout(getContentPane());
		pack();
		setVisible(true);

	}

	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() {
	 * 
	 * @Override public void run() { // TODO Auto-generated method stub
	 * AppService service = new AppServiceImpl(); Table1 li = new
	 * Table1(service); } }); }
	 */

}
