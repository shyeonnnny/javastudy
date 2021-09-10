package chapter04;

public class StringTest01 {

	public static void main(String[] args) {
		// c:\temp : 이렇만 출력하면 \t가 명령어(?)로 인식되서 출력되지 않는다
		System.out.println("c:\teamp");
		// \\를 두개 해줘야 출력이됨
		System.out.println("c:\\temp");
		
		// "hello"
		System.out.println("\"hello\"");
		
		// \t : tab
		// \r : carrige return
		// \n : newline
		// \b : beep
		
		System.out.print("hello \t world\n");
		System.out.println("hello\t world");
		
		// ' 를 출력하고싶을 때
		
		char c = '\'';
		System.out.println(c);
	}

}
