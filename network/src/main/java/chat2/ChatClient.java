package chat2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ChatClient {
	private static final int SERVER_PORT = ChatServer.PORT;
	private static final String SERVER_IP = "192.168.56.1";

	public static void main(String[] args) {
		Socket socket = null;
		Scanner scanner = null;
		PrintWriter pw = null;
		BufferedReader br = null;

		try {
			// 1. 키보드 연결
			scanner = new Scanner(System.in);

			// 2. socket 생성
			socket = new Socket();

			// 3. 연결
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
			System.out.println("connected");

			// 4. reader/writer 생성
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);

			// 5. join 프로토콜
			// System.out.println(">> 닉네임을 입력하세요");
			// String nickname = scanner.nextLine();
			// pw.println("join:" + nickname);
			// pw.flush();

			String nickname = "";

			while (true) {
				System.out.print(">> 닉네임을 입력하세요 : ");
				nickname = scanner.nextLine();
				if ("".equals(nickname) == false) {
					break;
				}
			}

			pw.println("join:" + nickname);

			// 6.ChatClientThread 시작
			new ChatClientThread(socket).start();

			// 7. 키보드 입력 처리
			while (true) {
				System.out.print(">> ");
				String input = scanner.nextLine();

				if (input == null) {
					continue;
				}
				if ("quit".equals(input) == true) {
					// 8. quit 프로토콜 처리
					pw.println("quit:" + input);
					break;
				} else {
					// 9. 메시지 처리
					pw.println("message:" + input);
					// ChatServerThread.log(nickname + input);
				}
			}

		} catch (Exception e) {
			System.out.println("error : " + e);
		} finally {
			// 10. 자원정리
			try {
				if (socket != null && socket.isClosed() == false) {
					socket.close();
				}
				if (scanner != null) {
					scanner.close();
				}
			} catch (IOException ex) {
				System.out.println("error : " + ex);
			}
		}

	}

}
