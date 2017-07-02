package com.nearur;

public class Item {
	int c;
	String n;
	int pr;
	@Override
	public String toString() {
		return "Item [c=" + c + ", n=" + n + ", pr=" + pr + "]";
	}
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}
	public String getN() {
		return n;
	}
	public void setN(String n) {
		this.n = n;
	}
	public int getPr() {
		return pr;
	}
	public void setPr(int pr) {
		this.pr = pr;
	}
	public Item(int c, String n, int pr) {
		this.c = c;
		this.n = n;
		this.pr = pr;
	}
	
}
