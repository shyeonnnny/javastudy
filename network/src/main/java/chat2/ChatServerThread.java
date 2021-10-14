package chat2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;
import echo.EchoServer;

public class ChatServerThread extends Thread {

	private String nickname;
	private Socket socket;
	private BufferedReader bufferedreader = null;
	private PrintWriter printWriter = null;
	List<PrintWriter> listWriters = null;

	public ChatServerThread(Socket socket, List<PrintWriter> listWriters) {
		this.socket = socket;
		this.listWriters = listWriters;
	}

	@Override
	public void run() {

		try {
			bufferedreader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);

			while (true) {
				String request = bufferedreader.readLine();
				if (request == null) {
					break;
				}

				String[] tokens = request.split(":");
				if ("join".equals(tokens[0])) {
					doJoin(tokens[1], printWriter);
				} else if ("message".equals(tokens[0])) {
					if (tokens.length < 2) {
						continue;
					}

					doMessage(tokens[1]);
				} else if ("quit".equals(tokens[0])) {
					doQuit(printWriter);
				} else {
					log("에러:알수 없는 요청 (" + tokens[0] + ")");
				}
			}

		} catch (IOException e) {
			EchoServer.log("error:" + e);
		} finally {
			try {
				if (socket != null && socket.isClosed() == false) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void doQuit(Writer writer) {
		removeWriter(writer);
		String data = nickname + "님이 퇴장 하였습니다.";
		broadcast(data);

		log(nickname + "님으로부터 연결이 종료되었습니다.");
	}

	private void removeWriter(Writer writer) {
		// 잘 구현해보기
		synchronized (listWriters) {
			listWriters.remove(writer);
		}
	}

	private void doMessage(String string) {
		// 잘 구현해보기
		broadcast(this.nickname + " : " + string);
	}

	private void doJoin(String nickName, PrintWriter writer) {
		this.nickname = nickName;

		String data = nickName + "님이 참여하였습니다.";
		broadcast(data);

		addWriter(writer);
		log(nickname + "님이 참여하였습니다.");
//		System.out.println(nickname + "님이 참여하였습니다.");
		printWriter.flush();

	}

	private void addWriter(PrintWriter writer) {
		synchronized (listWriters) {
			listWriters.add(writer);
		}
	}

	static void log(String string) {
		System.out.println("[ChatServer] " + string);

	}

	private void broadcast(String data) {
		synchronized (listWriters) {
			for (PrintWriter writer : listWriters) {
				writer.println(data);
				writer.flush();
			}
		}
	}

}
