package com.nearur;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class form {
	JFrame fr;
	JPanel ptitle,pnam,peml,pmob,ppas,pgen,padr,psub,pall;
	JButton btn;
	JLabel ltitle,lnam,leml,lmob,lpas,lgen,ladr;
	JTextField tnam,teml,tmob;
	JTextArea tadr;
	JPasswordField tpas;
	JRadioButton male,fem;
	ButtonGroup bg;
	JDialog d;
	Customers c=new Customers();
	
	form(){
		fr=new JFrame("Nearur Registration");
		
		ptitle=new JPanel();
		pnam=new JPanel();
		peml=new JPanel();
		pmob=new JPanel();
		ppas=new JPanel();
		pgen=new JPanel();
		padr=new JPanel();
		psub=new JPanel();
		pall=new JPanel();
		
		ltitle =new JLabel("Registration Form");
		lnam =new JLabel("Enter Your Full Name:");
		leml =new JLabel("Enter Your Email:");
		lmob =new JLabel("Enter Your Mobile Number:");
		lpas =new JLabel("Enter Your Password:");
		lgen =new JLabel("Gender:");
		ladr =new JLabel("Enter Your Address:");
		
		tnam=new JTextField(16);
		teml=new JTextField(16);
		tmob=new JTextField(10);
		tadr=new JTextArea(3,20);
		tpas=new JPasswordField(16);
		
		btn =new JButton("Submit");
		
		male=new JRadioButton("Male");
		fem=new JRadioButton("Female");
		bg=new ButtonGroup();
		
		
		d=new JDialog();
	}
	
	void generate() {
		
		ptitle.add(ltitle);
		
		pnam.add(lnam);
		pnam.add(tnam);
		
		peml.add(leml);
		peml.add(teml);
		
		pmob.add(lmob);
		pmob.add(tmob);
		
		ppas.add(lpas);
		ppas.add(tpas);
		
		pgen.add(lgen);
		bg.add(male);
		bg.add(fem);
		pgen.add(male);
		pgen.add(fem);
		
		padr.add(ladr);
		padr.add(tadr);
		
		psub.add(btn);
		
		pall.add(ptitle);
		pall.add(pnam);
		pall.add(peml);
		pall.add(pmob);
		pall.add(ppas);
		pall.add(pgen);
		pall.add(padr);
		pall.add(psub);
		
		GridLayout layout = new GridLayout(8, 1);
		pall.setLayout(layout);
		
		fr.add(pall);
		
		fr.pack();
		fr.setVisible(true);
		
		btn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				save();
			}
			
		});
		
	}
	void save() {
		c.name=tnam.getText();
		c.mobile=Long.parseLong(tmob.getText());
		c.password=tpas.getText();
		c.Address=tadr.getText();
		c.email=teml.getText();
		if(male.isSelected()) {
			c.g='M';
		}
		else {
			c.g='F';
		}
		File f=new File("C:/Users/mrdis/Desktop","Customers.txt");
		FileOutputStream w=null;
		ObjectOutputStream oos=null;
		try {
			w = new FileOutputStream(f,true);
			oos=new ObjectOutputStream(w);
			oos.writeObject(c);
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			try {
				w.close();
				oos.close();
			}catch(Exception e) {
				
				
			}
		}
		
		
		JOptionPane.showMessageDialog(fr,"Successful");
		tnam.setText("");
		tpas.setText("");
		teml.setText("");
		tadr.setText("");
		tmob.setText("");
		bg.clearSelection();
	}
}
public class NearurRegistration {

	public static void main(String[] args) {
		new form().generate();
        
	}

}
