
public class RecursiveTest01 {
	// 재귀 호출시 주의할 점
	// 베이스 조건이 없을 경우 무한 반복 될 수 있다.
	public static void main(String[] args) throws InterruptedException {
		System.out.println("main call");
		Thread.sleep(2000);
		main(null);
	}

}
