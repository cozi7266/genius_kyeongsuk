package algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BAEKJOON_9506_약수들의합 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		
		
		while(true) {
			int n = sc.nextInt();
			if(n == -1) {
				break;
			}
			int sum = 1;
			String line = n + " = 1";
			
			for (int i = 2; i < n; i++) {
				if(n % i == 0) {
					sum += i;
					line += " + " + i;
				}
			}
			
			if(sum == n) System.out.println(line);
			else System.out.println(n + " is NOT perfect.");
		}
	}
}
