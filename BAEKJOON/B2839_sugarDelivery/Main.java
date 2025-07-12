package algo.B2839_sugarDelivery;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		int N = sc.nextInt();
		
		int bagCount = 0;
		
		while(N >= 0) {		
			if(N % 5 == 0) {
				bagCount += (N / 5);
				System.out.println(bagCount);
				sc.close();
				return;
			}
			
			N -= 3;
			bagCount++;
		}
		
		System.out.println(-1);
		sc.close();
		
	}
}
