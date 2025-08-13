package boj_15988_1_2_3;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		long[] dp = new long[1000001];
		long mod = 10000000009L;
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for (int i = 4; i < dp.length; i++) {
			dp[i] = (dp[i-3] + dp[i-2] + dp[i-1]) % mod;
		}
		
		for (int i = 0; i < T; i++) {
			int index = sc.nextInt();
			System.out.println(dp[index]);
		}
	}
}
