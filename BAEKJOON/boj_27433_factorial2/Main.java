package boj_27433_factorial2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int result = 1;
		
		while(N != 0) {
			result *= N;
			N--;		
		}
		
		System.out.println(result);
	}
}
