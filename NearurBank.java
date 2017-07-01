package com.nearur;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class NearurBank {
	Image i;
	JFrame fr;
	JPanel ptil,pnew,pret;
	JButton newc,ret;
	JLabel ltil;
	protected boolean t;
	
	public NearurBank() {
		
		i=new Image();
		fr=new JFrame("Bank");
		
		ltil=new JLabel("Welcome To Nearur Bank");
		ltil.setFont(new Font(Font.DIALOG,Font.BOLD,50));
		ptil=new JPanel();
		pnew=new JPanel();
		pret=new JPanel();
		
		newc=new JButton("New Customer");
		ret=new JButton("Returning Customer");
		
		newc.setFont(new Font(Font.DIALOG,Font.LAYOUT_LEFT_TO_RIGHT,25));
		ret.setFont(new Font(Font.DIALOG,Font.PLAIN,25));
		ptil.add(i.getPicLabel());
		ptil.add(ltil);
		
		pnew.add(newc);
		pnew.add(ret);
		
		
		fr.add(ptil);
		fr.add(pnew);
		
		
		newc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				newCustomer();
				fr.dispose();
			}
			
		});
		
		ret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				validate();
				fr.dispose();
			}
			
		});
		
		fr.setLayout(new GridLayout(2,2));
		fr.pack();
		fr.setVisible(true);
	}
	
	void newCustomer() {
		JFrame f=new JFrame("Registration");
		
		JLabel ltil=new JLabel("Enter Details");
		JLabel lnam=new JLabel("Name:");
		JLabel lmob=new JLabel("Mobile:");
		JLabel lacc=new JLabel("Account Number:");
		JLabel ladd=new JLabel("Address:");
		JLabel lbal=new JLabel("Balance:");
		
		JButton add=new JButton("Register");
		
		JPanel ptil=new JPanel();
		JPanel pnam=new JPanel();
		JPanel pmob=new JPanel();
		JPanel pacc=new JPanel();
		JPanel padd=new JPanel();
		JPanel pbal=new JPanel();
		
		
		JTextField tnam=new JTextField(20);
		tnam.setFont(new Font(Font.DIALOG,Font.PLAIN,15));
		JTextField tmob=new JTextField(10);
		JTextField tacc=new JTextField(11);
		JTextArea tadd=new JTextArea(3,20);
		tadd.setAutoscrolls(true);
		JTextField tbal=new JTextField(10);
		
		ptil.add(ltil);
		pnam.add(lnam);
		pnam.add(tnam);
		pmob.add(lmob);
		pmob.add(tmob);
		pacc.add(lacc);
		pacc.add(tacc);
		padd.add(ladd);
		padd.add(tadd);
		pbal.add(lbal);
		pbal.add(tbal);
		pbal.add(add);
		
		
		f.add(ptil);
		f.add(pnam);
		f.add(pmob);
		f.add(pacc);
		f.add(padd);
		f.add(pbal);
		
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Bank b=new Bank(tnam.getText(),tadd.getText(),Long.parseLong(tmob.getText()),Long.parseLong(tacc.getText()),Integer.parseInt(tbal.getText()));;
				b.setPt(b.getBal()*0.005);
				JDBCUSE u=new JDBCUSE();
				u.connect();
				u.add(b);
				u.close();
				
				f.dispose();
				fr.setVisible(true);
				
			}
		});
		
		f.setLayout(new GridLayout(6, 1));
		f.pack();
		f.setVisible(true);
	}
	
	void validate() {
		
		JFrame f=new JFrame("Account ");
		
		JLabel lacc=new JLabel("Account Number:");
		JPanel pacc=new JPanel();
		JTextField tacc=new JTextField(11);
		JButton sch=new JButton("Search");
		
		pacc.add(lacc);
		pacc.add(tacc);
		pacc.add(sch);
		
		f.add(pacc);
		
		sch.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				JDBCUSE u=new JDBCUSE();
				u.connect();
				Long a=Long.parseLong(tacc.getText());
				Bank b=u.search(a);
				if(b==null) {
					JOptionPane.showMessageDialog(f,"Wrong Account Number");
					f.dispose();
					u.close();
					fr.setVisible(true);
				}
				else {
					u.close();
					old(b);
					f.dispose();
				}		
			}
			
		});
		f.pack();
		f.setVisible(true);
	}
	
	void old(Bank b) {
		
		JFrame f=new JFrame("Transaction");
		
		JLabel ltil=new JLabel("Customer Details");
		JLabel lnam=new JLabel("Name:");
		JLabel lmob=new JLabel("Mobile:");
		JLabel lacc=new JLabel("Account Number:");
		JLabel ladd=new JLabel("Address:");
		JLabel lbal=new JLabel("Balance:");
		JLabel ldep=new JLabel("Enter Amount:");
		
		JButton add=new JButton("Deposit");
		JButton draw=new JButton("Withdraw");
		JButton ok=new JButton("Ok");
		
		JPanel ptil=new JPanel();
		JPanel pnam=new JPanel();
		JPanel pmob=new JPanel();
		JPanel pacc=new JPanel();
		JPanel padd=new JPanel();
		JPanel pbal=new JPanel();
		JPanel pbut=new JPanel();
		JPanel pdep=new JPanel();
		
		
		JLabel tnam=new JLabel(b.getName());
		JTextField tdep=new JTextField(5);
		JLabel tmob=new JLabel(String.valueOf(b.getMobile()));
		JLabel tacc=new JLabel(String.valueOf(b.getAccount()));
		JLabel tadd=new JLabel(String.valueOf(b.getAddress()));
		JLabel tbal=new JLabel(String.valueOf(b.getBal()));
		
		ptil.add(ltil);
		pnam.add(lnam);
		pnam.add(tnam);
		pmob.add(lmob);
		pmob.add(tmob);
		pacc.add(lacc);
		pacc.add(tacc);
		padd.add(ladd);
		padd.add(tadd);
		pbal.add(lbal);
		pbal.add(tbal);
		pbut.add(add);
		pbut.add(draw);
		pdep.add(ldep);
		pdep.add(tdep);
		pdep.add(ok);
		f.add(ptil);
		f.add(pnam);
		f.add(pmob);
		f.add(pacc);
		f.add(padd);
		f.add(pbal);
		f.add(pbut);
		
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				f.add(pdep);
				t=true;
				f.pack();
		   }
		});
		
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int bal=Integer.parseInt(tdep.getText());
				if(t) {b.setBal(b.getBal()+bal);
					   b.setPt(b.getPt()+bal*0.005);
				}
				else {
					b.setBal(b.getBal()-bal);
					b.setPt(b.getPt()+bal*0.01);
				}
				JDBCUSE u=new JDBCUSE();
				u.connect();
				u.update(b);
				u.close();
				f.setVisible(false);
				old(b);
		   }
		});
		
		draw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				f.add(pdep);
				t=false;
				f.pack();
			}
			
		});
		
		f.setLayout(new GridLayout(8,1));
		f.pack();
		f.setVisible(true);	
		
	}
	public static void main(String[] args) {
		new NearurBank();	
	}

}
