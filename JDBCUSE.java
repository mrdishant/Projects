package com.nearur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUSE {
	
	Connection c;
	PreparedStatement pm;
	ResultSet res;
	
	JDBCUSE(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("Error:"+e);
		}
	}
	
	void connect() {
		try {
			String url,User,pass; 
			url="jdbc:mysql://localhost/nearur";
			User="root";
			pass="naina";
			c=DriverManager.getConnection(url,User,pass);
			//System.out.println("--Connected--");
		} catch (Exception e) {
			System.out.println("Error:"+e);
		}
	}
	
	void add(Bank b){
		try {
			String sql="insert into bank values(?,?,?,?,?,?)";
			
			pm=c.prepareStatement(sql);	
			pm.setLong(1,b.getAccount());
			pm.setString(2,b.getName());
			pm.setString(3,b.getAddress());
			pm.setLong(4,b.getMobile());
			pm.setInt(5,b.getBal());
			pm.setDouble(6,b.getPt());
			
			pm.executeUpdate();
			
			//System.out.println(i+" Student(s)added");
			
		} catch (Exception e) {
			System.out.println("Error:"+e);
		}
	}
	
	Bank search(long r){
		Bank b=null;
		try {
			String sql="select * from bank where account=?";
			pm=c.prepareStatement(sql);	
			pm.setLong(1,r);
			res=pm.executeQuery();
			
			
			if(res.next()) {
				String n=res.getString(2);
				String ad=res.getString(3);
				long m=res.getLong(4);
				int bal=res.getInt(5);
				int ly=res.getInt(6);
				b=new Bank(n,ad,m,r,bal);
				b.setPt(ly);
			}
			
		} catch (Exception e) {
			System.out.println("Error:"+e);
		}
		return b;
	}
	
	
	void update(Bank b) {
		try {
			String sql="update bank set bal=?,loyality=? where account=?";
			pm=c.prepareStatement(sql);
			pm.setInt(1,b.getBal());
			pm.setDouble(2,b.getPt());
			pm.setLong(3,b.getAccount());
			pm.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error:"+e);
		}
	}
	
	void del(int r){
		try {
			String sql="delete from record where RollNumber=?";
			pm=c.prepareStatement(sql);	
			pm.setInt(1,r);
			
			pm.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error:"+e);
		}

	}
	
	void close() {
		try {
			c.close();
			//System.out.println("--Connection Closed--");
		} catch (Exception e) {
			System.out.println("Error:"+e);
		}
	}
	
}
