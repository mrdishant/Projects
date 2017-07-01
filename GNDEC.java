package com.nearur;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GNDEC {
	
	JFrame fr,fadd;
	JButton btnadd,add,update,btnsch,btnupt,btndel;
	JLabel lnam,lmob,lroll,ldep;
	JTextField tnam,tmob,troll,tdep;
	JPanel pnam,pmob,proll,pdep,pall;
	
	GNDEC(){
		fr=new JFrame("GNDEC");
		fadd=new JFrame("Adding");
		btnadd=new JButton("New");
		btnsch=new JButton("Search");
		btndel=new JButton("Delete");
		btnupt=new JButton("Update");
		
		fr.add(btnadd);
		fr.add(btnsch);
		fr.add(btndel);
		fr.add(btnupt);
		
		fr.setLayout(new GridLayout(2,2));
		btnadd.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent arg0) {
				
				add();
				fr.dispose();
				
			}
			
		});
		
		btnsch.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent arg0) {
				
				search();
				fr.dispose();
				
			}
			
		});
		
		btnupt.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent arg0) {
				
				update();
				fr.dispose();
				
			}
			
		});
		
		btndel.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent arg0) {
				
				delete();
				fr.dispose();
				
			}
			
		});
		
		fr.setSize(300,300);
		fr.setVisible(true);
	}
	void add() {
		lnam=new JLabel("Name:");
		lmob=new JLabel("Mobile:");
		ldep=new JLabel("Department:");
		lroll=new JLabel("RollNo:");
		
		tnam=new JTextField(15);
		tmob=new JTextField(10);
		tdep=new JTextField(10);
		troll=new JTextField(10);
		
		pnam=new JPanel();
		pdep=new JPanel();
		proll=new JPanel();
		pmob=new JPanel();
		pall=new JPanel();
		
		add=new JButton("Add");
		
		pnam.add(lnam);
		pnam.add(tnam);
		proll.add(lroll);
		proll.add(troll);
		pdep.add(ldep);
		pdep.add(tdep);
		pmob.add(lmob);
		pmob.add(tmob);
		
		pall.add(pnam);
		pall.add(proll);
		pall.add(pdep);
		pall.add(pmob);
		pall.add(add);
		pall.setLayout(new GridLayout(5,1));
		
		fadd.add(pall);
		
		fadd.pack();
		fadd.setSize(500,500);
		fadd.setVisible(true);
		
		add.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent arg0) {
				
				int r=Integer.parseInt(troll.getText());
				long m=Long.parseLong(tmob.getText());
				Student s=new Student(tnam.getText(),tdep.getText(),r,m);
				
				JDBCUSE use=new JDBCUSE();
				use.connect();
				use.add(s);
				use.close();
				
				fadd.dispose();
				fr.setVisible(true);
			}
			
		});
	
	}
	
	void search() {
		lnam=new JLabel("Name:");
		lmob=new JLabel("Mobile:");
		ldep=new JLabel("Department:");
		lroll=new JLabel("RollNo:");
		
		tnam=new JTextField(15);
		tmob=new JTextField(10);
		tdep=new JTextField(10);
		troll=new JTextField(10);
		
		tnam.setEditable(false);
		tmob.setEditable(false);
		tdep.setEditable(false);
		
		pnam=new JPanel();
		pdep=new JPanel();
		proll=new JPanel();
		pmob=new JPanel();
		pall=new JPanel();
		
		add=new JButton("Search");
		
		pnam.add(lnam);
		pnam.add(tnam);
		proll.add(lroll);
		proll.add(troll);
		pdep.add(ldep);
		pdep.add(tdep);
		pmob.add(lmob);
		pmob.add(tmob);
		
		pall.add(proll);
		pall.add(pnam);
		pall.add(pdep);
		pall.add(pmob);
		pall.add(add);
		pall.setLayout(new GridLayout(5,1));
		
		fadd.add(pall);
		
		fadd.pack();
		fadd.setSize(500,500);
		fadd.setVisible(true);
		
		add.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent arg0) {
				
				int r=Integer.parseInt(troll.getText());
				
				JDBCUSE use=new JDBCUSE();
				use.connect();
				Student s=use.search(r);
				use.close();
				
				if(s!=null) {
				tnam.setText(s.getName());
				tmob.setText(String.valueOf(s.getMobile()));
				tdep.setText(s.getDep());
				}
				else
				{
					JOptionPane.showMessageDialog(fadd,"Not Found");
				}
				
				add.setText("Return");
				add.addActionListener(new ActionListener() {

					
					public void actionPerformed(ActionEvent e) {

						fadd.dispose();
						fr.setVisible(true);
						
					}
				
				});
			}
			
		});

	}
	
	void update() {
	
		lnam=new JLabel("Name:");
		lmob=new JLabel("Mobile:");
		ldep=new JLabel("Department:");
		lroll=new JLabel("RollNo:");
		
		tnam=new JTextField(15);
		tmob=new JTextField(10);
		tdep=new JTextField(10);
		troll=new JTextField(10);
		
		tnam.setEditable(false);
		tmob.setEditable(false);
		tdep.setEditable(false);
		
		pnam=new JPanel();
		pdep=new JPanel();
		proll=new JPanel();
		pmob=new JPanel();
		pall=new JPanel();
		
		add=new JButton("Search");
		update=new JButton("Update");
		
		pnam.add(lnam);
		pnam.add(tnam);
		proll.add(lroll);
		proll.add(troll);
		pdep.add(ldep);
		pdep.add(tdep);
		pmob.add(lmob);
		pmob.add(tmob);
		
		pall.add(proll);
		pall.add(pnam);
		pall.add(pdep);
		pall.add(pmob);
		pall.add(add);
		pall.setLayout(new GridLayout(5,1));
		
		fadd.add(pall);
		
		fadd.pack();
		fadd.setSize(500,500);
		fadd.setVisible(true);
		
		add.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent arg0) {
				int r=Integer.parseInt(troll.getText());
				
				JDBCUSE use=new JDBCUSE();
				use.connect();
				Student s=use.search(r);
				use.close();
				
				if(s!=null) {
				tnam.setText(s.getName());
				tmob.setText(String.valueOf(s.getMobile()));
				tdep.setText(s.getDep());
				
				tnam.setEditable(true);
				tmob.setEditable(true);
				tdep.setEditable(true);
				pall.remove(add);
				pall.add(update);
				}
				else
				{
					JOptionPane.showMessageDialog(fadd,"Not Found");
					tnam=null;
					tmob=null;
					tdep=null;
					troll=null;
					add=null;
					fadd.dispose();
					fr.setVisible(true);
				}

			}
		});
				
		update.addActionListener(new ActionListener() {

					
				public void actionPerformed(ActionEvent arg0) {
				int r=Integer.parseInt(troll.getText());
				long m=Long.parseLong(tmob.getText());
				Student s=new Student(tnam.getText(),tdep.getText(),r,m);
				
				JDBCUSE use=new JDBCUSE();
				use.connect();
				use.update(s);
				use.close();
				
				JOptionPane.showMessageDialog(fadd,"Updated");
				
				fadd.dispose();
				fr.setVisible(true);
				}
		
		});
				
	}
								
				
	void delete() {
		lroll=new JLabel("RollNo:");
		
		troll=new JTextField(10);
		
		proll=new JPanel();
		pall=new JPanel();
		
		add=new JButton("Delete");
		
		proll.add(lroll);
		proll.add(troll);
		pall.add(proll);
		pall.add(add);
		pall.setLayout(new GridLayout(2,1));
		
		fadd.add(pall);
		fadd.setSize(300, 300);
		fadd.setVisible(true);
		
		add.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent arg0) {
				int r=Integer.parseInt(troll.getText());
				JDBCUSE use=new JDBCUSE();
				use.connect();
				int j=JOptionPane.showConfirmDialog(fadd,"Are U Sure??");
				if(j==JOptionPane.YES_OPTION) {
				use.del(r);
				use.close();
				}
				else {
					use.close();
					
				}
				fadd.dispose();
				fr.setVisible(true);
				
			}
			
		});
	}
		
	

	public static void main(String[] args) {
		new GNDEC();
	}

}
