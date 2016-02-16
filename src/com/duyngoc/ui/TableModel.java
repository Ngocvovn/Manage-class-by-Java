package com.duyngoc.ui;

import java.util.List;

import javax.swing.CellEditor;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicTreeUI.CellEditorHandler;
import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel{
	
	Listener sListener;
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		if ((columnIndex == 4) ||(columnIndex==5) ){
		return true;
		}
		return false;
	}
	
	
	public void addStudent(Student s){
		_students.add(s);
		fireTableDataChanged();
	}
	
	public void setShitListener(Listener s1){
		sListener = s1;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Student> _students;
	private String[] columnNames = { "Frist name", "Last name", "ID","Address", "Email", "Good Student" };
	
	
	public TableModel(List<Student> students) {
		_students = students;
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
		Student s = _students.get(row);
		if(col == 0){
			return s.getFirstName();
		}
		else if(col == 1){
			return s.getLastName();
		}
		else if(col == 2){
			return s.getID();
		}
		else if(col == 3){
			return s.getAddress();
		}
		else if(col == 4){
			return s.getEmail();
		}
		else if(col == 5){
			
			return s.isGoodStudent();
		}
		return null;
	}
	@Override
	public void setValueAt(Object aValue, int row, int col) {
		// TODO Auto-generated method stub
		Student s = _students.get(row);
		System.out.println(aValue.getClass());
		if(col ==4){
		s.setEmail((String) aValue) ;
        //fireTableCellUpdated(row, col);
		}
		else if (col ==5){
			s.setGoodStudent((Boolean.valueOf((aValue.toString()))));
			fireTableCellUpdated(row, col);
		}
		else if (col == 3){
			s.setAddress(aValue.toString());
		}
		else if (col ==2){
			s.setID((int) aValue);
		}
		else if (col ==1){
			s.setLastName((int) aValue);
		}
		else{
			s.setFirstName((int) aValue);
		}
	}
	
	public void removeStudent(int[] row){
		System.out.println(row);
		for( int ro : row){
		_students.remove(ro);
		}
		fireTableDataChanged();
	}
	
	

}
