package com.nearur;

import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MyTable extends JFrame{

	JTable t;
	DefaultTableModel m;
	public MyTable() {
		JFrame f=new JFrame();
		String column[]={"ID","NAME","SALARY"};
		m=new DefaultTableModel(column,0);
		String data[][]={ {"101","Amit","670000"},    
                {"102","Jai","780000"},    
                {"101","Sachin","700000"}};    
		m.addRow(data[0]);
		t=new JTable(m);
		//add(t);
		setLayout(new GridLayout(2,1));
		setVisible(true);
		add(new JScrollPane(t));
		t.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				
				
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				m=(DefaultTableModel)t.getModel();
				t.setModel(m);
				System.out.println(t.getModel().getValueAt(0,1));
			}
			
		});
	}
	
	public static void main(String[] args) {
		MyTable t=new MyTable();

	}

}
