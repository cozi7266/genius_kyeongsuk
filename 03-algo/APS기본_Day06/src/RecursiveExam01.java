/*
2 5

2 * 2 * 2 * 2 * 2
 */
public class RecursiveExam01 {
	public static void main(String[] args) {
		int num = 2;
		int cnt = 5;
		// 반복
		solve1(num, cnt);
		
		// 재귀
		solve2(num, cnt);
		
		solve2(num, cnt, 0);
	}
	private static void solve2(int n, int m, int result) {
        if (m == 0) {
            System.out.println(result);
            return;
        }
        solve2(n, m - 1, result * n);
    }
	
	static int sum = 1;
	private static void solve2(int i, int j) {
	    if(j == 0) {
	        System.out.println(sum);
	        return;
	    }
	    sum *= i;
	    solve2(i, j - 1);
	}
	
	private static void solve1(int n, int count) {
	    int sum = 1;
	    for(int i = 1; i <= count; i++) {
	        sum *= n;
	    }
	    System.out.println(sum);
	}
	
	
}












