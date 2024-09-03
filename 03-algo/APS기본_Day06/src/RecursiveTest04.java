
public class RecursiveTest04 {
	// N 을 입력받아서 1 ~ N까지 출력하는 프로그램 작성
	public static void main(String[] args) {
		solve1(13489);
//		solve2(13489);
		solve1Recur(13489);
	}
	
	private static void solve1Recur(int i) {
		
	}

	// 25
	private static void solve1(int num) {
		int sum = 0;
		while (true) {
			sum += num % 10;
			if (num < 10) break;
			num /= 10;
		}
		System.out.println(sum);
	}

	/*
	private static void solve2(int num) {
		// 숫자를 문자열로 변환
		String str1 = num + "";
		String str2 = String.valueOf(num);
		// ['1', '3', '6', '8', '9']
		char[] arr = str2.toCharArray();
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i] - '0';
		}
		System.out.println(sum);
	}
	 */
	
	
	
}









