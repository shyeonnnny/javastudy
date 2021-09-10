package chapter04;

public class ObjectTest01 {

	public static void main(String[] args) {
		Point p = new Point(10, 20);
		
		// Class c =  p.getClass();

		System.out.println(p.getClass()); // reflection : 객체가 만들어졌을 때 참고했던 클래스 정보 출력
		System.out.println(p.hashCode()); // address(주소) 기반의 해싱값 출력 ( 정수값 )
										  // address 아님
										  // reference 아님
		System.out.println(p.toString()); // getClass() + "@" + hashCode()
		System.out.println(p); // toString 없이 p만 적어도 똑같은 내용 출력 가능
		
	}

}
