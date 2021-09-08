package chapter03;

public class GoodsApp {

	public static void main(String[] args) {
		Goods goods = new Goods(); /* 클래스이름은 소문자로 하는것이 좋음 */
		goods.setName("Nicon");
		goods.setPrice(2000);
		goods.setCountStock(10);
		goods.setCountSold(20);		
		goods.showInfo(); /* 굿즈객체안에있는 데이터를 화면에 출력하라는 메소드 */
		int discountPrice = goods.calcDiscountPrice(50);
		System.out.println(discountPrice);
		
		System.out.println(Goods.countOfGoods);
		
		Goods goods2 = new Goods();
		Goods goods3 = new Goods();
		
		System.out.println(Goods.countOfGoods);
			
	}

}