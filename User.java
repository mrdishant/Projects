
public class User {
    int i;
	String name;
	long mobile;
	Group[] g=new Group[10];
	
	User(){   //Default Constructor
		i=0;
		name="No Name";
		mobile=0000000000;
	}
	
	User(String n,long m){   //Parameterized Constructor
		i=0;
		name=n;
		mobile=m;
	}
	
	void createGroup(String gn)
	{
	    g[i++]=new Group(gn,this);
	}
    
	void changeGname(String gn,int i)
	{
		g[i].Gname=gn;
	}
}
