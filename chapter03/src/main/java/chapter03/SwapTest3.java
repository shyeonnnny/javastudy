package chapter03;

public class SwapTest3 {

	public static void main(String[] args) {
			Value a = new Value(10);
			Value b = new Value(20);
			
			System.out.println(a.val + ":" + b.val);
			
			
			swap(a, b);
			
			System.out.println(a.val + ":" + b.val);
			// 숫자가 안바뀌는 이유 : swap함수 호출이 끝나면 스택에서 pop되서
			// 전부사라지기때문에 a,b는 그대로임
		}
		
		public static void swap(Value p, Value q) {
			int temp = p.val;
			p.val = q.val;
			q.val = temp;
		}

	}
