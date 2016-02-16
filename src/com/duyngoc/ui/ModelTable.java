package com.duyngoc.ui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.CellEditor;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicTreeUI.CellEditorHandler;
import javax.swing.table.AbstractTableModel;

import com.duyngoc.service.AppService;
import com.mysql.jdbc.Statement;

public class ModelTable extends AbstractTableModel {
	Listener sListener;

	List<UpdateStudentListener> updateStudentListener = new ArrayList<UpdateStudentListener>();

	public void addUpdateStudentListener(UpdateStudentListener listener) {
		updateStudentListener.add(listener);
	}

	public void update(Student s) {
		for (UpdateStudentListener listener : updateStudentListener) {
			listener.updateStudent(s);
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		if (columnIndex != -1) {
			return true;
		}
		return false;
	}

	public List<Student> getStudents() {
		return _students;
	}

	public void addStudent(Student s) {
		_students.add(s);
		fireTableDataChanged();
	}

	public void setListener(Listener s1) {
		sListener = s1;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Student> _students;
	private String[] columnNames = { "id", "name", "math grade", "english grade", "street", "city" };

	public ModelTable(List<Student> student) {
		_students = student;
	}

	public void setStudents(List<Student> students) {
		_students = students;
		fireTableDataChanged();
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return _students.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		/*
		 * Student s = _students.get(row); if (col == 0) { return
		 * s.getFirstName(); } else if (col == 1) { return s.getLastName(); }
		 * else if (col == 2) { return s.getID(); } else if (col == 3) { return
		 * s.getAddress(); } else if (col == 4) { return s.getEmail(); } else if
		 * (col == 5) {
		 * 
		 * return s.isGoodStudent(); }
		 */
		Student s = _students.get(row);
		if (col == 0) {
			return s.getID();
		} else if (col == 1) {
			return s.getName();
		} else if (col == 2) {
			return s.getMath();
		} else if (col == 3) {
			return s.getEnglish();
		} else if (col == 4) {
			return s.getStreet();
		} else if (col == 5) {
			return s.getCity();

		}

		return null;
	}

	@Override
	public void setValueAt(Object aValue, int row, int col) {
		// TODO Auto-generated method stub
		/*
		 * Student s = _students.get(row);
		 * System.out.println(aValue.getClass()); if (col == 4) {
		 * s.setEmail((String) aValue); // fireTableCellUpdated(row, col); }
		 * else if (col == 5) {
		 * s.setGoodStudent((Boolean.valueOf((aValue.toString()))));
		 * fireTableCellUpdated(row, col); } else if (col == 3) {
		 * s.setAddress(aValue.toString()); } else if (col == 2) { s.setID((int)
		 * aValue); } else if (col == 1) { s.setLastName((int) aValue); } else {
		 * s.setFirstName((int) aValue); }
		 */

		Student s = _students.get(row);
		System.out.println(aValue.getClass());
		if (col == 2) {
			s.setMath(Double.valueOf(aValue.toString()));
			fireTableCellUpdated(row, col);
		} else if (col == 3) {
			s.setEnglish((Double.valueOf((aValue.toString()))));
			fireTableCellUpdated(row, col);
		} else if (col == 0) {
			s.setID((Integer.valueOf((aValue.toString()))));
			fireTableCellUpdated(row, col);

		}
		else if ( col ==1){
			s.setName(aValue.toString());
			fireTableCellUpdated(row, col);
		}
		else if ( col == 4){
			s.setStreet(aValue.toString());
			fireTableCellUpdated(row, col);
		}
		else if ( col ==5){
			s.setCity(aValue.toString());
			fireTableCellUpdated(row, col);
		}

		update(s);
	}

	public void removeStudent(int[] row) {
		System.out.println(row);
		/*
		 * int i = 0; for (int ro : row){ if ( i ==0){ _students.remove(ro);
		 * i=1; } else{ _students.remove(ro-1); } } fireTableDataChanged();
		 */

		Map<Integer, Student> map = new HashMap<Integer, Student>();
		int i = 0;
		for (Student student : _students) {
			map.put(i++, student);

		}

		for (int ro : row) {
			map.remove(ro);
		}
		if (map.values() instanceof List) {
			_students = (List) map.values();
		} else {
			_students = new ArrayList<Student>(map.values());
		}
		fireTableDataChanged();
	}

}
