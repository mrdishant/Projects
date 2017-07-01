package com.nearur;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class details implements ActionListener,FocusListener {
	
	JLabel title,title2,name,cno,uno,cls,email;
	TextField ename,ecno,euno,ecls,eemail;
	JPanel p1,p11,p2,p3,p4,p5,p6,p7,pAll;
	JFrame fr;
	JButton btn;
	
	details() {
		
		title =new JLabel("REGISTRATION FORM");
		title2 = new JLabel("Enter the following details - ");
		name =new JLabel("Name : ");
		cno =new JLabel("College Roll No (6 digits) : ");
		uno =new JLabel("University Roll No (7 digits) : ");
		cls =new JLabel("Class : ");
		email =new JLabel("Email id : ");
		
		ename = new TextField(15);
		ecno = new TextField(15);
		euno = new TextField(15);
		ecls = new TextField(15);
		eemail = new TextField(15);
		
		p1 = new JPanel();
		p11= new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p5 = new JPanel();
		p6 = new JPanel();
		p7 = new JPanel();
		pAll = new JPanel();
		
		fr=new JFrame("college registration form , bruh");
		
		btn = new JButton("SUBMIT");
	
	}
	
	void addDetails () {
		
		p1.add(title);
		
		p11.add(title2);
		
		p2.add(name);
		p2.add(ename);
		
		p3.add(cno);
		p3.add(ecno);
		
		p4.add(uno);
		p4.add(euno);
		
		p5.add(cls);
		p5.add(ecls);
		
		p6.add(email);
		p6.add(eemail);
		
		p7.add(btn);
		
		pAll.add(p1);
		pAll.add(p11);
		pAll.add(p2);
		pAll.add(p3);
		pAll.add(p4);
		pAll.add(p5);
		pAll.add(p6);
		pAll.add(p7);
		
		GridLayout layout = new GridLayout(10,1);
		pAll.setLayout(layout);
		
		fr.add(pAll);
		fr.pack();
		fr.setVisible(true);
		
	}

	
	public void focusGained(FocusEvent e) {
		System.out.println("Foucus GAINED");
		
	}

	
	public void focusLost(FocusEvent e) {
		System.out.println("Foucus Lost");
		
		if(e.getSource()==ecno) {
			String text1 = ecno.getText();
			if(text1.length()>6) {
				ecno.setText(" ");
				cno.setText("Enter valid college roll no");
			}
		}
		
		if(e.getSource()==euno) {
			String text2 = euno.getText();
			if(text2.length()>7) {
				euno.setText(" ");
				uno.setText("Enter valid university roll no");
			}
		}
 		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}

public class registrationForm {

	public static void main(String[] args) {
	
		details dRef = new details();
		dRef.addDetails();
		
		
	}

}