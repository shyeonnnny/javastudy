package chat2;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	static Socket socket = null;
	static Scanner scanner = null;
	static PrintStream printWriter;
	
	public static void main(String[] args) {
		
		try {
			scanner = new Scanner(System.in);
			
			System.out.println(">> 닉네임을 입력하세요");
			String nickname = scanner.nextLine();
			printWriter.println("join:" + nickname);
			printWriter.flush();
			
			//3. socket 생성
			socket = new Socket();
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//1. 키보드 연결
		
		
		//2. join 프로토콜
		//3. socket 생성
		//4. 연결
		//5. reader,writer 
		//6. chatClienReceiveThread 시작
		//7. 키보드 입력 처리
		//8. quit 프로토콜 처리
		//9. 메시지 처리
		
	}

}
