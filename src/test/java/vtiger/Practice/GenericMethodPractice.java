package vtiger.Practice;

public class GenericMethodPractice {

	public static void main(String[] args) {   //Caller Method
		
		int c=add(80,50);
		System.out.println(c);

	}

	public static int add(int a,int b) {   //Called Method-The Generic method
		int c=a+b;
		return c;
		
	}

}
