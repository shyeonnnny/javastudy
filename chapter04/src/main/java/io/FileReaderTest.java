package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class FileReaderTest {

	public static void main(String[] args) {
		Reader in = null;
		InputStream is = null;
		
		try {
			in = new FileReader("1234.txt");
			
			int count = 0;
			int data = -1;
			while((data = in.read()) != -1){
				System.out.print((char)data); // char로 캐스팅
				count++;
			}
			System.out.println("");
			System.out.println("count : " + count);
			System.out.println("=============================");
			
			count = 0;  // 다시 변수 초기화
			data = -1; // 다시 변수 초기화
			
			is = new FileInputStream("1234.txt"); // 파일 동시에 열기 가능
			while((data=is.read()) != -1) {
				System.out.print((char)data);
				count ++;
			}
			System.out.println("");
			System.out.println("count : " + count);
			
			
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found : " + e);
		} catch (IOException e) {
			System.out.println("error : " + e);
		}
		finally {
			try {
				if(in != null) {
					in.close();
				}
				if(is != null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
