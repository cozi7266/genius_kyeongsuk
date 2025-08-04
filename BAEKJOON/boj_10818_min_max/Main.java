package boj_10818_min_max;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			int input = sc.nextInt();
			max = Math.max(max, input);
			min = Math.min(min, input);
		}
		
		System.out.print(min+" "+max);
		
	}
}
