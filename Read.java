package com.nearur;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Read {

	public static void main(String[] nt) {
		
		File f=new File("C:/Users/mrdis/Desktop","Customers.txt");
		
		try {
			FileInputStream fin=new FileInputStream(f);
			ObjectInputStream oin=new ObjectInputStream(fin);
			
			Customers c=null;
			while((c=(Customers)oin.readObject())!=null)
		    {	
				System.out.println(c);
		    
		    }
			oin.close();
			fin.close();
		} catch (Exception e) {
			System.out.println("Error:"+e);
		}
		
	}
	
}
