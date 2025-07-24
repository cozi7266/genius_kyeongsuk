package boj_2748_pibonacci_sequence;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		long[] pibo = new long[n+1];
		
		pibo[0] = 0;
		pibo[1] = 1;
		
		for (int i = 2; i <= n; i++) {
			pibo[i] = pibo[i-1] + pibo[i-2];
		}
		
		System.out.println(pibo[n]);
		
	}
}
