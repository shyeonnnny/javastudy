package util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NSLoopup {

	public static void main(String[] args) {
		String line = "www.douzone.com";
		
		
		try {
			InetAddress[] inetAdresses =  InetAddress.getAllByName(line); // 이름으로 IP를 모두가져옴
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
