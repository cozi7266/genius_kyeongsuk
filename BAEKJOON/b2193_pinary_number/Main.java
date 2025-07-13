package b2193_pinary_number;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N  = sc.nextInt();
		
		System.out.println(getPinaryNumCounts(N));
		
		sc.close();
	}

	private static int getPinaryNumCounts(int n) {
		
		if (n == 0) return 0;
		
		else if (n == 1) return 1;
		
		int[][] dp = new int[n + 1][2];
		
		dp[1][0] = 0;
		dp[1][1] = 1;
		
		for (int i = 2; i <= n; i++) {
			
			dp[i][0] = dp[i-1][0] + dp[i-1][1];
			
			dp[i][1] = dp[i-1][0];
		}
		
		return dp[n][0] + dp[n][1];
		
	}
}
