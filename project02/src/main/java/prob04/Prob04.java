package prob04;
public class Prob04 {

	public static void main(String[] args) {
		char[] c1 = reverse( "Hello World" );
		printCharArray( c1 );
		
		char[] c2 = reverse( "Java Programming!" );
		printCharArray( c2 );
	}
	
	public static char[] reverse(String str) {
		char[] str_Array = str.toCharArray();
		// c1, c2를 한 문자씩 뜯어서 str_Array 배열에 한 글자씩 저장
		
		int count = str_Array.length / 2;
		// 문자열이 6글자인 경우 3번만 바꿔도 문자열이 거꾸로 바뀌기 때문에
		// 배열 길이 / 2 를 count 변수에 저장
		
		for (int i=0; i<count; i++) {
		// count 만큼 문자열 바꾸기 반복
		char temp = str_Array[i];
		// 예를 들어 0번째 자리의 한글자를 temp 변수에 저장
		str_Array[i] = str_Array[str_Array.length - 1 - i];
		str_Array[str_Array.length - 1 - i] = temp;
		}
		/* 코드를 완성합니다 */
		return str_Array;
	}

	public static void printCharArray(char[] array){
		/* 코드를 완성합니다 */
		System.out.println( array );
	}
}