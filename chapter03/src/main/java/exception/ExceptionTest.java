package exception;

public class ExceptionTest {

	public static void main(String[] args) {
		int a = 10;
		int b = 10 - a;

		System.out.println("some code1....");
		try {
			System.out.println("some code2....");
			int result = ( 1 + 2 + 3) / b;
			System.out.println("some code3....");
			System.out.println("some code4....");
			
		}catch(ArithmeticException e) {
			/* 예외 처리 */
			// 1. 사과
			System.out.println("미안합니다.");
		
			// 2. 로깅
			System.out.println("error 에러내용 출력 : " + e);
			
			// 3. 정상종료
			return;
			
		} finally {
			// finally는 return 뒤에 있어서 실행이 안될 것 같지만
			// finally는 종료직전에 정상적으로 실행된다. ( return이 실행되도 실행됨 )
			// finally가 제일 마지막이기때문에 finally 밑에는 코드를 아무것도 안적어주는것이 좋다.
			System.out.println("자원정리");
		}
	}

}