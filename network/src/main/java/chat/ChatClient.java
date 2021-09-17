package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	private static final int PORT = 8000;

	public static void main(String[] args) {
		Scanner scanner = null;
		Socket socket = null;

		
		try {
			scanner = new Scanner(System.in);
			System.out.println(">> 닉네임을 입력하세요");
			String nickname = scanner.nextLine();
			
			socket = new Socket();
			
			socket.connect(new InetSocketAddress("0.0.0.0", PORT));
			log("connected");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			
			System.out.println(">> 닉네임을 입력하세요");
			String nickname = scanner.nextLine();
			pw.println("join:" + nickname);
			pw.flush();
			
			new ChatClientThread(socket).start();
			
			while (true) {
				System.out.print(">>");
				String input = scanner.nextLine();
				
				if ("quit".equals(input) == true ) {
					System.out.println();
					break;
				} else {
					pw.println("JOIN" + nickname);
					br.readLine();
				}
			}
		} catch (IOException e){
			log("error:" + e);
		} finally {
			// 5. 자원정리
			try {
				if (socket != null && socket.isClosed() == false) {
					socket.close();
				}
			} catch (IOException ex) {
				log("error:" + ex);
			}
		}
		
	}

	private static void log(String string) {
		// TODO Auto-generated method stub
		
	}

}
