package thread;

public class ThreadEx01 {

	public static void main(String[] args) {
		// 싱글 스레드
//		for(int i=0; i<10; i++) {
//			System.out.print(i);
//		}
		new DigitThread().start();
		for(char c='a'; c<'z'; c++) {
			System.out.print(c);
			try {
				Thread.sleep(100);  // 1000 = 1초
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
