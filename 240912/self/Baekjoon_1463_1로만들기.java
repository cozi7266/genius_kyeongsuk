package com.ssafy.self;

import java.util.Scanner;

public class Baekjoon_1463_1로만들기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] dp = new int[N+1];
		
		dp[1] = 0;
		
		for (int i = 2; i <= N; i++) {
			int minCnt = Integer.MAX_VALUE;
			
			minCnt = Math.min(dp[i-1]+1, minCnt);
			
			if(i % 3 == 0) minCnt = Math.min(dp[i/3]+1, minCnt);
			if(i % 2 == 0) minCnt = Math.min(dp[i/2]+1, minCnt);
			dp[i] = minCnt;	
		}
		System.out.println(dp[N]);
	}
}
