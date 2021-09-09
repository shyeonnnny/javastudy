package paint;

public class ColorPoint extends Point {
	private String color; // 캡슐화때문에 private

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public void show() {
		System.out.println("점[x=" + getX() + ", y=" + getY() + ", color=" + color +"]을 그렸습니다.");
	}
}
