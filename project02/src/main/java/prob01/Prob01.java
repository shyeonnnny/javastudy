package prob01;

import java.util.Scanner;

public class Prob01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in  );

		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };

		System.out.print("금액 : ");
		int money = scanner.nextInt();

		int one = 0 , two = 0, three = 0, four = 0;
		int five = 0, six = 0, seven = 0, eight = 0, nine = 0, ten = 0;

		if (money >= 50000) {
			one = money / 50000;
			money = money - MONEYS[0] * one;	
		}
		if (money >= 10000) {
			two = money / 10000;
			money = money - MONEYS[1] * two;
		}
		if (money >= 5000) {
			three = money / 5000;
			money = money - MONEYS[2] * three;
		}
		if (money >= 1000) {
			four = money / 1000;
			money = money - MONEYS[3] * four;
		}
		if (money >= 500) {
			five = money / 500;
			money = money - MONEYS[4] * five;
		}
		if (money >= 100) {
			six = money / 100;
			money = money - MONEYS[5] * six;
		}
		if (money >= 50) {
			seven = money / 50;
			money = money - MONEYS[6] * seven;
		}
		if (money >= 10) {
			eight = money / 10;
			money = money - MONEYS[7] * eight;
		}
		if (money >= 5) {
			nine = money / 5;
			money = money - MONEYS[8] * nine;
		}
		if (money >= 1) {
			ten = money / 1;
			money = money - MONEYS[9] * ten;
		}
		System.out.println("50000원 : " + one + "개");
		System.out.println("10000원 : " + two + "개");
		System.out.println("5000원 : " + three + "개");
		System.out.println("1000원 : " + four + "개");
		System.out.println("500원 : " + five + "개");
		System.out.println("100원 : " + six + "개");
		System.out.println("50원 : " + seven + "개");
		System.out.println("10원 : " + eight + "개");
		System.out.println("5원 : " + nine + "개");
		System.out.println("1원 : " + ten + "개");
		scanner.close();
	}
}