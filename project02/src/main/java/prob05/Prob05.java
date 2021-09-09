package prob05;

import java.util.Random;
import java.util.Scanner;

public class Prob05 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in );

		while( true ) {

			/* 게임 작성 */

			// 정답 램덤하게 만들기
			int count = 0;
			Random random = new Random();
			int correctNumber = random.nextInt( 100 ) + 1;
			
			System.out.println("수를 결정하였습니다. 맞추어 보세요");
			System.out.println("1-100");

			while ( true ) {
				
				count++;

				System.out.println(count + ">>");
				int select_number = scanner.nextInt();
				
				if (select_number > 100 || select_number < 0) {
					System.out.println("1-100사이 숫자를 선택하세요.");
					
				}

				if (select_number > correctNumber) {
					System.out.println("더 낮게");
					continue;
				}else if ( select_number < correctNumber){
					System.out.println("더 높게");
					continue;
				}else if (select_number == correctNumber) {
					System.out.println("맞았습니다.");
					break;

				}
				

			}


			//새 게임 여부 확인하기
			System.out.print( "다시하시겠습니까(y/n)>>" );
			String answer = scanner.next();
			if( "y".equals( answer ) == false ) {
				break;
			}
		}

		scanner.close();
	}

}