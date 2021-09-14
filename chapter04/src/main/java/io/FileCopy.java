package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy {

	public static void main(String[] args) {
		InputStream is = null; // 로컬변수 초기화
		OutputStream os = null;
		try {
			is = new FileInputStream("chunsik.jpg");
			os = new FileOutputStream("chunsil.copy.jpg");

			int data = -1;
			while((data = is.read()) != -1){ // -1이 아니라는것은 데이터를 제대로 읽은것
				os.write(data);
			}

		} catch (FileNotFoundException e) {
			System.out.println("file not found : " + e);
		} catch (IOException e) {
			System.out.println("error : " + e);
		} finally {
			try {
				if(is !=null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
