package exception;

import java.io.IOException;

public class MyClassTest {

	public static void main(String[] args) {
		MyClass myclass = new MyClass();
		try {
			myclass.danger();
		} catch (Exception e) {
			System.out.println("error : " + e);
		}
		
	}

}
