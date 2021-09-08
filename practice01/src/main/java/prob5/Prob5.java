package prob5;

public class Prob5 {

	public static void main(String[] args) {
		for (int i=1; i<=99; i++) {
			String number = String.valueOf(i);

			int number_length = number.length();
			int clap = 0;

			for (int j=0; j<number_length; j++) {
				char number_char = number.charAt(j);
				if(number_char == '3') {
					clap ++;
					System.out.print(number + " ");
				}
				else if (number_char == '6') {
					clap ++;
					System.out.print(number + " ");
				}
				else if (number_char == '9') {
					clap ++;
					System.out.print(number + " ");
				}
				else {
					clap = 0;
				}

			}
			for (int j=0; j<clap; j++) {
				System.out.print("짝");
			}
			System.out.println();
		}
	}
}
