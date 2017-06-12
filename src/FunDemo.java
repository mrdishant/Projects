
public class FunDemo {
	
	
	// T1 : static
	
	static void printTableS(int number) {
		for(int i=1;i<=10;i++)
			System.out.println(number+" "+i+"'s are "+(number*i));
	}
	
	// T2 : non static
	
	void printTable(int number) {
		for(int i=1;i<=10;i++)
			System.out.println(number+" "+i+"'s are "+(number*i));
	}

	
	/*void calculateAreaOfRect(int l, int b){
		int a = l*b;
		System.out.println("Area is: "+a);
	}*/
	
	int calculateAreaOfRect(int l, int b){
		//int a = l*b;
		return (l*b);
	}
	
	int[] processArray(){
		
		int[] arr = {10,20,30,40,50};
		
		return arr;
	}
	
	//error
	//int,float wowFun(){
		
//	}
	
	int hello(int x){
		x = 20;
		
		return x;
	}
	
	public static void main(String[] args) {
		
		//int num = 5;
		
		printTableS(5); // Execution of Method | Call or Invoke
		FunDemo.printTableS(7); // Execution of Method | Call or Invoke
		
		//printTable(9); error
		//FunDemo.printTable(11); error 
		
		// Accessing or execution of non static method
		FunDemo fdRef = new FunDemo();
		System.out.println("fdRef is: "+fdRef);

		fdRef.printTable(11);
		fdRef.printTableS(13);
		
		int result = fdRef.calculateAreaOfRect(10, 4);
		if(result%2==0){
			System.out.println("What a beautiful Geometry");
		}else{
			System.out.println("Not a great Geometry");			
		}
		
		int x = 10;
		
		
		x = fdRef.hello(x);
	}

}
