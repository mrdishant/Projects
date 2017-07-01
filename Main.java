package com.nearur;
class element{
	int n;
	boolean value=false;
	
	
}
class push extends Thread{
	element e;
	int i=0;
	public push(element x) {
		e=x;
	}
	public void run() {
		while(i<10) {
			i++;
			synchronized(e){
				if(e.value) {
					try {
						e.wait();
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				e.n=i;
				System.out.println("Push:"+e.n);
				e.value=true;
				e.notify();
			}
		}
	}
}
class pop extends Thread{
	element e;
	int i=0;
	public pop(element x) {
		e=x;
	}
	public void run() {
		while(i<10) {
			i++;
			synchronized(e){
				if(!e.value) {
					try {
						e.wait();
					} catch (Exception e) {
						// TODO: handle exception
					}}
					System.out.println("Pop:"+e.n);
					e.value=false;
					e.notify();
			}
		}
	}
}
public class Main {
	public static void main(String[] nt) {
	element x=new element();
	new push(x).start();
	new pop(x).start();
}}
