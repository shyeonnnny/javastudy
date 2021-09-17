package chat;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
	private static final int PORT = 8000;

	public static void main(String[] args) {
		ServerSocket serverSocket = null;

		try {
			// 1. 서버 소켓 생성
			//    - 특정 컴퓨터에서 TCP포트를 열어 그곳으로 요청을 받았을 때 사용하는 클래스
			//    - 서버컴퓨터에서 포트번호를 열어놔야 클라이언트 컴퓨터가 접속하여 통신 가능
			//    - 서버컴퓨터의 포트번호를 열 때 사용하는 클래스
			//    - 이미 사용중인 포트번호는 IOException 발생
			serverSocket = new ServerSocket();

			// 2. 바인딩
			//    - InetAddress : 로컬컴퓨터의 IP 주소를 가져오는 기능
			//    - .getLocalHost() : 로컬 컴퓨터의 IP주소를 반환
			//    - .getHostAddress() : 호스트의 IP주소를 반환
			String hostAddress = InetAddress.getLocalHost().getHostAddress();

			//    - bind() API에 사용되는 인자는 소켓과 포트번호(또는 IP주소+포트번호)
			//    - 소켓과 포트 번호를 결합한다는 뜻
			serverSocket.bind(new InetSocketAddress(hostAddress, PORT));
			log("연결 기다림" + hostAddress + " : " + PORT);

			// 3. 요청 대기
			while (true) {
				//    - 클라이언트로부터 연결 요청을 기다린다 (accept)
				Socket socket = serverSocket.accept();


				// 4. 처리 요청 전달
				//    - 클라이언트와 연결되면 직접 처리하지않고 ChatServerThread에게 맡긴다.
				new ChatServerThread(socket).start();

			}

		} catch (IOException e){
			log("error:" + e);
		} finally {
			// 5. 자원정리
			try {
				if (serverSocket != null && serverSocket.isClosed() == false) {
					serverSocket.close();
				}
			} catch (IOException ex) {
				log("error:" + ex);
			}
		}
	}

	public static void log(String string) {
		System.out.println("[HttpServer#" + Thread.currentThread().getId() + "]" + string);
	}

}
