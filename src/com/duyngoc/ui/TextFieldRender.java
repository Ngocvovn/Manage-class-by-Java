package com.duyngoc.ui;

import java.awt.Component;

import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class TextFieldRender extends JTextField  implements TableCellRenderer {

	JTextField tf = new JTextField();
	
	/*@Override
	public Object getCellEditorValue() {
		return tf.getText();
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		tf.setText((String) value);
		return tf;
	}*/

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// TODO Auto-generated method stub
		tf.setText(value.toString());
		
		return tf;
	}

	

	

}
