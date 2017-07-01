package com.nearur;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Client {

	void writeObject(){
		File file = new File("C:/Users/mrdis/Desktop/newnote.txt");
		FileOutputStream fos =null;
		FileInputStream fin= null;
		ObjectOutputStream oos=null;
		ObjectOutputStream oos1=null;
		//ObjectInputStream ois= null;
		try {
			Customers c=new Customers();
	
			fos= new FileOutputStream(file,true);
			oos= new ObjectOutputStream(fos);
			//oos1= new ObjectOutputStream(fos);
			oos.writeObject(c);
			oos.writeObject(c);
			
			System.out.println("Object attributes written!!");
			System.out.println("serialization done!!");
		} catch (Exception e) {
			System.out.println("some problem occured"+e);
		}
		finally{
			try {
				oos.close();
				fos.close();
			} catch (Exception e2) {
				System.out.println("some problem occured"+e2);
			}
		}
	}
	
	
	
	void readObject(){
		File file = new File("C:/Users/mrdis/Desktop/Customers.txt");
		FileOutputStream fos =null;
		FileInputStream fin= null;
		ObjectOutputStream oos=null;
		ObjectInputStream ois= null;
		ObjectInputStream ois1= null;
		try {
			//employ emp = new employ();
			fin= new FileInputStream(file);
			ois= new ObjectInputStream(fin);
			//ois1= new ObjectInputStream(fin);
			
			//employ e; 
			Customers c;
			while((c=(Customers)ois.readObject())!=null){
				System.out.println(c);
			}
		//	employ f =(employ)ois.readObject();
			System.out.println("Object attributes read!!");
			System.out.println("deserialization done!!");
		//	System.out.println(e + " "+ f);
			//System.out.println();
		} catch (Exception e) {
			System.out.println("some problem occured"+e);
		}
		finally{
			try {
				//ois1.close();
				fin.close();
			} catch (Exception e2) {
				System.out.println("some problem occured"+e2);
			}
		} }
		
		
	public static void main(String[] args) {
	Client ref = new Client();
			//ref.writeObject();
			ref.readObject();
	}

}