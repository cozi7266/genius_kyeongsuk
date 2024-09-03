import java.util.Arrays;
import java.util.Comparator;

class Idol {
	String name;
	int age;
	public Idol() {}
	public Idol(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Idol [name=" + name + ", age=" + age + "]";
	}
}

public class 람다연습 {
	static class IdolComp implements Comparator<Idol> {
		@Override
		public int compare(Idol o1, Idol o2) {
			return o1.age - o2.age;
		}
	}
	public static void main(String[] args) {
		Idol[] arrays = new Idol[3];
		arrays[0] = new Idol("코딩왕 윤지", 20);
		arrays[1] = new Idol("디버깅왕 반장", 22);
		arrays[2] = new Idol("디자인왕 연주", 21);
		
		Arrays.sort(arrays, new IdolComp());
		Arrays.sort(arrays, (o1, o2) -> {return o1.age - o2.age;});
		// 실행문장이 한문장일 경우 블럭을 생략할 수 있다.
		// 단, return 문을 사용하면 안된다.
//		Arrays.sort(arrays, (o1, o2) -> return o1.age - o2.age);  // error
		Arrays.sort(arrays, (o1, o2) -> o1.age - o2.age);
		
		System.out.println(Arrays.toString(arrays));
	}
}














