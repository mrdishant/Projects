
public class Main {

	public static void main(String[] nt) {
		
		User u1=new User("Dishant",9023074222l);
		User u2=new User("Garvit",8284010455l);
		User u3=new User("Piyush",9815445194l);
		User u4=new User("Nikhil",9815215752l);
		User u5=new User("Navneet",9888321686l);
		
		u1.createGroup("Brothers");
		User[] x={u2,u3,u4,u5};
		u1.g[0].addUsers(x);
		
		u4.g[0].showGname();
		u1.changeGname("For", 0);
		u2.g[0].showGname();
		u2.changeGname("Life", 0);
		u5.g[0].showGname();
		u3.changeGname("Yeahhh", 0);
		u1.g[0].showGname();
		
		
		System.out.println("------------------");
		u3.g[0].showUsers();
		
		
	}

}
