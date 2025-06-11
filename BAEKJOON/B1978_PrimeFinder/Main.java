package algo.B1978_PrimeFinder;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			int target = sc.nextInt();
			int check = 0;
			for (int j = 1; j <= target; j++) {
				if(target % j == 0) check++;
			}
			
			if(check == 2) count++;
		}
		
		System.out.println(count);
	}
}
