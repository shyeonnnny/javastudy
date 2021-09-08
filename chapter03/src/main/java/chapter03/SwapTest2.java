package chapter03;

public class SwapTest2 {

	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		
		System.out.println(a + ":" + b);
		
		
		swap(a, b);
		
		System.out.println(a + ":" + b);
		// 숫자가 안바뀌는 이유 : swap함수 호출이 끝나면 스택에서 pop되서
		// 전부사라지기때문에 a,b는 그대로임
	}
	
	public static void swap(int p, int q) {
		int temp = p;
		p = q;
		q = temp;
	}

}
