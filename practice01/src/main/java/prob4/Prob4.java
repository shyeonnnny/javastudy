package prob4;

import java.util.Scanner;

public class Prob4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("문자열을 입력하세요 : ");
		String text = scanner.nextLine();
		
		String[] text_array;
		
		text_array = text.split("");
		
		for(int i=0; i<text_array.length; i++) {
			for(int j = 0; j < i+1; j++) {
				System.out.print(text_array[j]);
			}
			System.out.println();
		}
		
		scanner.close();
	}

}
