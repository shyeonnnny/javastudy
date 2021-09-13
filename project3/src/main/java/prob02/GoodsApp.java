package prob02;

import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];

		// 상품 입력
		System.out.println("상품을 입력해주세요");


		int i = 0;
		while (i < COUNT_GOODS) {
			String insert_goods = scanner.nextLine();				
			goods[i] = new Goods();
			goods[i].setGoods_name(insert_goods.split(" ")[0]);
			goods[i].setPrice(Integer.parseInt(insert_goods.split(" ")[1]));
			goods[i].setCount(Integer.parseInt(insert_goods.split(" ")[2]));

			i++;

			continue;

		} 

		// 상품 출
		for (int j=0; j < COUNT_GOODS; j++) {
			System.out.println(goods[j].getGoods_name() + "( 가격 : " + 
					goods[j].getPrice() + "원 )이 " +
					goods[j].getCount() + "개 입고 되었습니다.");
		}

		// 자원정리
		scanner.close();
	}
}
