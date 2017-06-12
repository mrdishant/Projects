
public class Group {
	int i;
	String Gname;
	User[] u=new User[10];
	
	Group(String n,User u1) {
		i=0;
		Gname=n;
		u[0]=u1;
	}
	void addUsers(User[] u1) {
		for(User x:u1) {
			u[++i]=x;
			x.g[(x.i)++]=this;
	    }
	}
	
	void showGname() {
		System.out.println(Gname);
	}
	
	void showUsers() {
		System.out.println("Users:");
		for(int j=0;j<=i;j++) {
			System.out.println(u[j].mobile);
		}
	}
}
