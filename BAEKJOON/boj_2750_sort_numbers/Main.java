package boj_2750_sort_numbers;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] list = new int[N];
		
		for (int i = 0; i < N; i++) {
			list[i] = sc.nextInt();
		}
		
		Arrays.sort(list);
		
		for(int element : list) System.out.println(element);
		
		sc.close();
	}
}
