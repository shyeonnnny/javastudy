package prob3;

import java.util.Scanner;

public class Prob3 {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);


		while (true) {

			int sum = 0;

			System.out.print("숫자를 입력하세요 : ");
			int number = scanner.nextInt();

			if ((number % 2) == 0) {
				for (int i = 0; i <= number; i += 2) {
					sum = sum + i;
				}
				System.out.println(sum);
			} else {
				for (int i = 1; i <= number; i += 2) {
					sum = sum + i;
				}
				System.out.println(sum);
			}

			//			scanner.close();
		}
	}
}
