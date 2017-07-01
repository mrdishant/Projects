package com.nearur;

//POJO or BEAN or MODEL
public class Bank {
	String name;
	String address;
	long mobile;
	long account;
	int bal;
	double pt;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public long getAccount() {
		return account;
	}
	public void setAccount(long account) {
		this.account = account;
	}
	public int getBal() {
		return bal;
	}
	public void setBal(int bal) {
		this.bal = bal;
	}
	public double getPt() {
		return pt;
	}
	public void setPt(double pt) {
		this.pt = pt;
	}
	@Override
	public String toString() {
		return "Bank [name=" + name + ", address=" + address + ", mobile=" + mobile + ", account=" + account + ", bal="
				+ bal + ", pt=" + pt + "]";
	}
	public Bank(String name, String address, long mobile, long account, int bal) {
		this.name = name;
		this.address = address;
		this.mobile = mobile;
		this.account = account;
		this.bal = bal;
		this.pt = 0;
	}
	
	
}
