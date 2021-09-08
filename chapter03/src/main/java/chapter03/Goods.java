package chapter03;

public class Goods {
	public static int countOfGoods = 0;
	// public static final int countOfGoods = 0;
	// final : 뒤에서 새로 정의하거나 값 대입 불가
	
	private String name; /* private : 외부에서 접근 불가 */
	private int price;
	private int countStock;
	private int countSold;
	
	public Goods() {
		Goods.countOfGoods = Goods.countOfGoods + 1;
		// 같은 클래스이기 때문에 Goods를 생략하여도되지만
		// 적어주는것이 원칙
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCountStock() {
		return countStock;
	}
	public void setCountStock(int countStock) {
		this.countStock = countStock;
	}
	public int getCountSold() {
		return countSold;
	}
	public void setCountSold(int countSold) {
		this.countSold = countSold;
	}
	public void showInfo() {
		System.out.println(
				"name:" + name + 
				", price:" + price + 
				", countStock:" + countStock + 
				", countSold:" + countSold);
	}
	
	public int calcDiscountPrice(int percentage) {
		return price * percentage / 100;
	}
	
}