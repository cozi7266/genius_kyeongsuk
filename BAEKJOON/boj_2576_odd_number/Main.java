package boj_2576_odd_number;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int oddSum = 0;
		int minOdd = Integer.MAX_VALUE;
		
		for (int i = 0; i < 7; i++) {
			int input = sc.nextInt();
			if(input % 2 == 1) {
				minOdd = Math.min(minOdd, input);
				oddSum += input;
			}			
		}
		
		
		if(oddSum == 0) {
			System.out.println(-1);
			return;
		}
		
		System.out.println(oddSum);
		System.out.println(minOdd);
			
	}
}
