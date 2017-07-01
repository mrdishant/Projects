package com.nearur;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Customers implements Serializable{
    
	long mobile;
	String name;
	String email;
	String Address;
	String password;
	char g;
	
	 /*Customers(long m,String n,String e,String a,String p,char g) {
		 mobile=m;
		 name=n;
		 email=e;
		 Address=a;
		 password=p;
		 this.g=g;
	}*/

	
	public long getMobile() {
		return mobile;
	}


	public void setMobile(long mobile) {
		this.mobile = mobile;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		Address = address;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public char getG() {
		return g;
	}


	public void setG(char g) {
		this.g = g;
	}


	public String toString() {
		return "Customers [mobile=" + mobile + ", name=" + name + ", email=" + email + ", Address=" + Address
				+ ", password=" + password + ", g=" + g + "]";
	}
	 
	 void reado() {
		 Customers c;
			File f=new File("C:/Users/mrdis/Desktop","Customers.txt");
			FileInputStream r;
			ObjectInputStream ois;
			try {
				r=new FileInputStream(f);
				ois=new ObjectInputStream(r);
				c=(Customers)ois.readObject();
				System.out.println(c);
				r.close();
				ois.close();
				} catch (Exception e) {
				System.out.println("Error: "+e);
			}
			
	 }
	public static void main(String[] nt) {
		
		new Customers().reado();
	}
}
