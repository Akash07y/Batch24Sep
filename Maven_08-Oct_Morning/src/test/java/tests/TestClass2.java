package tests;
                    //  Generic 
public class TestClass2 <H, K>{

	int a ;
	
	H b ; 
	
	H test(K c) {
		
		return b ;
	}
	
	public static void main(String[] args) {
		
		
		TestClass2<String, Integer> y = new TestClass2<String, Integer>(); // y.a, y.b
		y.a = 87 ;
		y.b = "velocity";
		System.out.println( y.test(56) );
		
		
	}
}
