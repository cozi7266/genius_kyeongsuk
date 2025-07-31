package boj_11053_Longest_Increasing_Subsequence;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int[] dp = new int[N];
		int maxLIS = 0;
		
		Arrays.fill(dp, 1);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if(arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			
			maxLIS = Math.max(maxLIS, dp[i]);
		}
		
		System.out.println(maxLIS);
		sc.close();
			
	}
}
