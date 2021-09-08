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
				}
				else if(number_char == '6') {
					clap ++;
				}
				else if(number_char == '9') {
					clap ++;
				}		
			}
			if (clap == 0) {
				continue;
			}
			System.out.print(number + " ");
			for (int j=0; j<clap; j++) {
				System.out.print("짝");
			}
			System.out.println();
		}
	}
}
