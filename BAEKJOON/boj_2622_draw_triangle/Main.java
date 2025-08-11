package boj_2622_draw_triangle;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();		
		
		int cnt = 0;
		
		for (int i = 1; i < num; i++) {
			for (int j = i; j < num; j++) {
				
				int k = num - i - j;
				
				if(k < j) break;
				
				if(k < i + j) cnt++;
					
				
			}
		}
		
		System.out.println(cnt);
	}
}
