package com.duyngoc.ui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PopupDIalog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PopupDIalog(JFrame parent){
		super(parent);
		JPanel messagePane = new JPanel();
	    messagePane.add(new JLabel("Fuck"));
	    getContentPane().add(messagePane);
	    JPanel buttonPane = new JPanel();
	    JButton button = new JButton("OK"); 
	    buttonPane.add(button); 
	    getContentPane().add(buttonPane, BorderLayout.SOUTH);
	    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    pack(); 
	}

}
