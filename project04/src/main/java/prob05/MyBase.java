package prob05;

public class MyBase extends Base {
	
	public void service(String string){
		if (string == "낮") {
			System.out.println("낮에는 열심히 일하자!");
		}else if (string == "밤") {
			System.out.println("night");
		}else if (string == "오후") {
			System.out.println("오후도 낮과 마찬가지로 일해야 합니다.");
		}
	}

}
