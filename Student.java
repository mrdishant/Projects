package com.nearur;

public class Student {
	String name;
	String dep;
	int roll;
	long mobile;
	
	public Student(String name, String dep, int roll, long mobile) {
		this.name = name;
		this.dep = dep;
		this.roll = roll;
		this.mobile = mobile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDep() {
		return dep;
	}
	public void setDep(String dep) {
		this.dep = dep;
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", dep=" + dep + ", roll=" + roll + ", mobile=" + mobile + "]";
	}
	
}
