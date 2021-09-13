package chapter04;

import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {
		// Calendar c = new Calendar(); -> 추상이라서 이렇게 정의 못함
		Calendar cal = Calendar.getInstance();
		
		cal.set(Calendar.YEAR, 2021); // 2022년 오늘 날짜의 요일이 나옴
		cal.set(Calendar.MONTH, 11); // 12월로 설정 (Month - 1)
		cal.set(Calendar.DATE, 25);
		printDate(cal);
		
		cal.set(2021, 8, 13);
		cal.add(Calendar.DATE, 100);
		printDate(cal); // 오늘 날짜부터 100일 뒤 날짜 출력
		
		
		cal.set(1997, 7, 7);
		cal.add(Calendar.DATE, 1000);
		printDate(cal); // 태어난 날짜로부터 1000일뒤 날짜
	}
	
	public static void printDate(Calendar cal) {
		final String[] DAYS = {"일", "월", "화", "수", "목", "금", "토"};
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH); // 0~11까지이기때문에 +1해줘야함
		int date = cal.get(Calendar.DATE);
		int day = cal.get(Calendar.DAY_OF_WEEK); //  1(일) ~ 7(토)
		int hours = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);

		System.out.println(
				year + "년 " +
				(month + 1) + "월 " +
				date + "일 " + 
				DAYS[day-1] + "요일 " +
				hours + "시 " +
				minute + "분 " +
				second + "초");
	}

}
