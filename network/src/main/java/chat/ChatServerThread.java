package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ChatServerThread extends Thread {
	private String nickname;  // 연결된 클라이언트의 닉네임을 저장하고 있어야한다.
	private Socket socket;  // 통신을 위한 스트림을 얻어오기 위해 Socket 객체를 저장해야함


	List<Writer> listWriters = new ArrayList<Writer>();


	public ChatServerThread(Socket socket) {
		this.socket = socket;
	}


	// Runnable 작업 스레드가 실행할 수 있는 코드를 가지고 있는 객체
	// 구현 클래스는 ren()을 재정의해서 작업 스레드가 실행할 코드를 작성해야함
	@Override
	public void run() {
		List<Writer> listWriters = null;
		new ChatServerThread(socket, listWriters).start();

		// getRemoteSocketAddres : 연결된 시스템에 대한 IP 주소를 반환
		InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
		String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
		int remoteHostPort = inetRemoteSocketAddress.getPort();
		ChatServer.log("connected by client[" + remoteHostAddress + ":" + remoteHostPort + "]");

		try {
			// 입력스트림과 출력스트림 얻기
			//  - br : 입력스트림
			//  - pw : 출력스트림
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);

			while(true) {
				String request = br.readLine();
				if ( request == null) {
					ChatServer.log("클라이언트로부터 연결 끊김");
					break;
				}

				String[] tokens = request.split(":");
				if("join".equals(tokens[0])) {
					doJoin(tokens[1], pw);
				} else if ("message".equals(tokens[0])) {
					doMessage(tokens[1]);
				} else if ("quit".equals(tokens[0])) {
					doQuit(pw);
				} else {
					ChatServer.log("에러:알수 없는 요청 (" + tokens[0] + ")");
				}

			}
		} catch (IOException e) {

		}

	}

	private void doJoin(String nickName, PrintWriter writer) {
		this.nickname = nickName;

		String data = nickName + "님이 참여하였습니다.";
		broadcast(data);

		addWriter (writer);

		PrintWriter printWriter = (PrintWriter)writer;
		printWriter.println("join:ok");
		printWriter.flush();

	}

	private void addWriter(PrintWriter writer) {
		synchronized (listWriters) {
			listWriters.add(writer);
		}
	}



	private void broadcast (String data) {
		synchronized (listWriters) {
			for (Writer writer : listWriters) {
				PrintWriter printWriter = (PrintWriter)writer;
				printWriter.println(data);
				printWriter.flush();
			}
		}
	}

	private void doMessage(String string) {

	}

	private void doQuit(Writer writer) {
		removeWriter(writer);

		String data = nickname + "님이 퇴장 하였습니다.";
		broadcast (data);
	}

	private void removeWriter(Writer writer) {
		// TODO Auto-generated method stub

	}

	public ChatServerThread(Socket socket, List<Writer> listWriters) {
		this.socket = socket;
		this.listWriters = listWriters;
	}





}
