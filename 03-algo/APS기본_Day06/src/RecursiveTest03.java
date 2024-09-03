
public class RecursiveTest03 {
	// N 을 입력받아서 1 ~ N까지 출력하는 프로그램 작성
	public static void main(String[] args) throws InterruptedException {
		int N = 5;
		System.out.println("반복문 활용한 합 구하기");
		solve1(N);
		int result = solve5(N);
		System.out.println("합계 : " + result);

		System.out.println("재귀 활용한 합 구하기");
		solve2(N, 0);
		solve3(N);
		
		sum = 0;
		solve4(1, N);
		
		
		result = solve6(N);
		System.out.println("재귀 합계 : " + result);
	}
	
	// 1 + 2 + 3 + 4 + 5 ~ n : n까지의 합계는 n + n-1까지의 합계
	private static int solve6(int n) {
		if (n == 1) {
			return 1;
		}
		return n + solve6(n - 1);
	}

	private static int solve5(int n) {
		int result = 0;
		for (int i = 1; i <= n; i++) {
			result += i;
		}
		return result;
	}

	private static void solve4(int i, int n) {
		if (i > n) {
			System.out.println(sum);
			return;
		}
		
		sum += i;
		solve4(i + 1, n);
	}

	static int sum = 0;
	private static void solve3(int i) {
		if (i == 0) {
			System.out.println(sum);
			return;
		}
		sum += i;
		solve3(i - 1);
	}
	
	private static void solve2(int i, int sum) {
		if (i == 0) {
			System.out.println(sum);
			return;
		}
		// sum + i
		solve2(i - 1, sum + i);
		
	}
	private static void solve1(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += i;
		}
		System.out.println(sum);
	}
}








