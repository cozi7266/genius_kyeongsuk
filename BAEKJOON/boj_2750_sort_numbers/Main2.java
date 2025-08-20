package boj_2750_sort_numbers;

import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] list = new int[N];
		
		for (int i = 0; i < list.length; i++) {
			list[i] = sc.nextInt();
		}
		
		for (int i = 0; i < N - 1; i++) {
			for (int j = i; j < N; j++) {
				if(list[i] > list[j]) {
					int bin = list[i];
					list[i] = list[j];
					list[j] = bin;
				}
			}
		}
		
		for (int element : list) {
			System.out.println(element);
		}
	}
}
