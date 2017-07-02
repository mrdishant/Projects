package com.nearur;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

		
public class wlcome extends JFrame implements ActionListener {
		DefaultTableModel m =new DefaultTableModel ();	
		JTable table;
		JScrollPane scrollpane;
		JButton purchase,edit,ok;
		JPanel n,tpanel,bpanel,allpanel;
		JTextField a,no;
		int count=0;
			String [] colmn={"Code","Item","Price","Number","Amount"};

		public wlcome(){
			no=new JTextField(10);
			a=new JTextField(5);
			tpanel = new JPanel();
			n = new JPanel();
			bpanel = new JPanel();
			allpanel = new JPanel();
			table = new JTable(m);
			scrollpane = new JScrollPane(table);
			
			purchase = new JButton("Purchase");
			edit = new JButton("Edit");
			ok = new JButton("Add");
			
			n.add(a);
			n.add(no);
			n.add(ok);
			tpanel.add(scrollpane);
			bpanel.add(purchase);
			bpanel.add(edit);
			allpanel.add(n);
			allpanel.add(tpanel);
			allpanel.add(bpanel);
			
			purchase.addActionListener(this);
			edit.addActionListener(this);
			ok.addActionListener(this);
			
			GridLayout layout = new GridLayout(3,1);
			allpanel.setLayout(layout);
			this.add(allpanel);
			this.setVisible(true);
			this.setSize(300,300);
			this.setTitle("Welcome to Globus");
			for(String g:colmn)
			{			m.addColumn(g);
			}
			
		}
			public static void main(String[] args) {
				new wlcome();
				
			}
			
			public void actionPerformed(ActionEvent ar) {
				if(ar.getSource()==ok) {
					int num=Integer.parseInt(no.getText());
					use u=new use();
					u.connect();
					Item i=u.search(Integer.parseInt(a.getText()));
					m.addRow(new Object[]{i.c,i.n,i.pr,num,num*i.pr});
					count++;
					u.close();
					}
				
				if(ar.getSource()==purchase) {
					int total=0;
					for(int x=0;x<count;x++) {
						total +=Integer.parseInt(table.getModel().getValueAt(x,4).toString());
					}
					JOptionPane.showMessageDialog(null,"Toatl:"+total);
					
				}
			

			}}
