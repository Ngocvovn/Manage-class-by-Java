package com.duyngoc.ui;

import java.awt.Component;

import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellRenderer;

public class CheckboxRenderer extends JCheckBox
implements TableCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Component getTableCellRendererComponent(JTable table,
            Object value,
            boolean isSelected,
            boolean hasFocus,
            int row,
            int column) {
		JCheckBox checkBox = new JCheckBox();
		checkBox.setSelected((boolean) value);
		return checkBox;
	}
	
	
}