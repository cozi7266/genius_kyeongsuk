package B11727_2xn_tiling2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		long[] dp = new long[n+1];
		
		dp[0] = 1;
		dp[1] = 1;
		
		if(n == 1) {
			System.out.println(1);
			sc.close();
			return;
		}
		
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i-1] + 2*dp[i-2] % 10007;
		}
		
		System.out.println(dp[n]);
		sc.close();

	}
}
