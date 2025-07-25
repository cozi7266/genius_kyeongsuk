package boj_9095_1_2_3_plus;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long[] dp = new long[12];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for (int i = 4; i <= 11; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		
		int T = sc.nextInt();
		
		for (int t = 0; t < T; t++) {
			int n = sc.nextInt();
			System.out.println(dp[n]);
		}
		
	}
}
