package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalHost {

	public static void main(String[] args) {
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
			
			String hostName = inetAddress.getHostName();
			String hostAddress = inetAddress.getHostAddress();
			
			System.out.println(hostName);
			System.out.println(hostAddress);
			
			byte[] addresses = inetAddress.getAddress();
			for(byte address : addresses ) { // for문 한번 더 공부하기
//				System.out.println(address);
//				System.out.println((int)address);
				System.out.print(address & 0x000000ff); // 16진수로 표현
				System.out.print('.');
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} 
	}

}
