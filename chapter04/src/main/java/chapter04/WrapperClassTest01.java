package chapter04;

public class WrapperClassTest01 {

	public static void main(String[] args) {
		Integer i = new Integer(10);
		Character c = new Character('c');
		Boolean b = new Boolean(true);
		
		// Auto Boxing
		Integer j1 = 10;
		Integer j2 = 10;
		
		System.out.println(j1 == j2);
		System.out.println(j1.equals(j2));
		
		
		// Auto Unboxing
		// j1 + 10 이라고하면안되고 intValue()를 이용하여 객체 값을 빼줘야함
		int m = j1.intValue() + 10;
		int m2 = j1 + 10;
		
		
	}

}
