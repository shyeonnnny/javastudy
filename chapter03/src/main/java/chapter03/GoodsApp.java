package chapter03;

public class GoodsApp {

	public static void main(String[] args) {
		Goods goods = new Goods(); /* 클래스이름은 소문자로 하는것이 좋음 */
		goods.setName("Nicon");
		goods.setPrice(2000);
		goods.setCountStock(10);
		goods.setCountSold(20);
		
		System.out.println(goods);
	}

}