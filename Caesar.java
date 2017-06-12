import java.util.Scanner;
public class Caesar 
{
    
	public static void main(String[] nt) 
	{
		Scanner in =new Scanner(System.in);
		System.out.print("Enter Plain Text: ");
		String s=in.nextLine();
		char[] a=new char[s.length()];
		char[] b={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		s=s.toUpperCase();
		for(int i=0;i<s.length();i++)
		{
			a[i]=s.charAt(i);
		}
		for(int j=0;j<a.length;j++)
		{  if(a[j]!=' ')
			{for(int i=0;i<b.length;i++)
			{
				if(a[j]==b[i])
				{
					a[j]=b[(i+3)%26];
					break;
				}
			}}
		}
		System.out.print("     Cipher Text: ");
		for(char d: a)
		System.out.print(d);
		System.out.println();
		
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<b.length;j++)
			{
				if(a[i]==b[j])
				{
					if(j>=3)
					{
						a[i]=b[(j-3)%26];
					}
					else
					{
						a[i]=b[(23+j)%26];
					}
					break;
				}
			}
		}
		System.out.print("     Plain  Text:");
		for(char j:a){
			System.out.print(j);
		}
		System.out.println();
	}

}
