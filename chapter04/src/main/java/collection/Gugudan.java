package collection;

import java.util.Objects;

public class Gugudan {
	private int left;
	private int right;

	public Gugudan(int left, int right) {
		this.left = left;
		this.right = right;
	}


	@Override
	public int hashCode() {
		return Objects.hash(left * right);
	}

	
	// (2,3) (3,2)가 들어오면 값은 6으로 같지만 left끼리 비교하고 right끼리 비교하면 다르다고나옴
	// 그래서 left * right로 비교를 해줘야 같은 값은 제외시켜줌
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gugudan other = (Gugudan) obj;
		return left * right == other.left * other.right;
	}


	@Override
	public String toString() {
		return "Gugudan [left=" + left + ", right=" + right + "]";
	}


}
