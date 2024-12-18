package com.ssafy.self;

import java.util.Scanner;

public class Baekjoon_11726_2xn타일링 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[n+1];
		dp[0] = 1; // 그냥 편의를 위해서 1를 대입함
		dp[1] = 1;
		
		if(n == 1) System.out.println(dp[1] % 10007);
		
		
		else {
//		dp[3] = 3;
//		dp[4] = 5;
//		dp[5]=  8;
		for (int i = 2; i <= n; i++) {
			dp[i] = (dp[i-1] + dp[i-2])% 10007;
		}
		
		System.out.println(dp[n] );
		}
	}
}
