class User{
	
	// Attributes
	private String name;
	String phone;
	String email;
	char gender;
	byte age;
	
	
}


public class OOPSDemo {

	public static void main(String[] args) {
		
		// Object Construction Instruction
		User u1 = new User();
		User u2 = new User();
		
		System.out.println("u1 is: "+u1);
		System.out.println("u2 is: "+u2);
		
		// Write the data into Object
		//u1.name = "John";
		u1.phone = "+91 99999 99999";
		u1.email = "john@example.com";
		u1.gender = 'M';
		u1.age = 20;
		
		//u2.name = "Jennie";
		
		// Read the data from Object
		//System.out.println(u1.name +" - "+u1.gender+" - "+u1.age);
		//System.out.println(u2.name +" - "+u2.gender+" - "+u2.age);

	}

}
