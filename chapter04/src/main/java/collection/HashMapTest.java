package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {
		Map<String, Integer> m = new HashMap<>();
		
		String ks1 = "one";
		// m.put("one", 1); // auto boxing ( 1에서 )
						    // m.put("one", new Integer(1));
		m.put(ks1, 1);
		m.put("two", 2);
		m.put("three", 3);
		
		int i = m.get("one"); // auto unboxing
		int j = m.get(new String("one"));
		System.out.println(i + ":" + j);
		
		m.put("three", 333333);
		System.out.println(m.get("three")); // 중복된 키 값을 쓰면 이전값에 덮어쓰기를 함
		
		
		// 순회
		Set<String> s = m.keySet();
		for (String key : s) {
			System.out.println(key + " : " + m.get(key));
		}
		
	}

}