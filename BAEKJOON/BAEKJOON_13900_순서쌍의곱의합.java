package algo;

import java.util.Scanner;

public class BAEKJOON_13900_순서쌍의곱의합 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		
		int total = 0;
		int result = 0;
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			total += arr[i];
		}
		
		for (int i = 0; i < arr.length; i++) {
			total -= arr[i];
			result += arr[i] * total;
		}
		
		System.out.println(result);
			
	}
}
