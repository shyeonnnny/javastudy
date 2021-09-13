package collection;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		Stack<String> s = new Stack<>();
		
		s.push("둘리");
		s.push("마이콜");
		s.push("도우너");
		System.out.println(s);
		
		while(!s.isEmpty()) {
			String str = s.pop();
			System.out.println(str);
		}
		
		// 비어있는 경우에는 예외 발생
		// s.pop();
		
		s.push("둘리");
		s.push("마이콜");
		s.push("도우너");
		
		System.out.println(s.pop());
		System.out.println(s.peek()); // 꺼내지않고 top이 누군지 알아보는 명령어
		System.out.println(s.pop());
	}

}
