package algo.B4673_SelfNumber;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		boolean[] isGenerated = new boolean[10001];
		
		for (int i = 1; i <= 10000; i++) {
			int generatedNumber = d(i);
			
			if(generatedNumber <= 10000) {
				isGenerated[generatedNumber] = true;
			}				
		}
		
		for (int i = 1; i <= 10000; i++) {
			if(!isGenerated[i]) System.out.println(i);
		}
	}

	private static int d(int n) {
		int sum = n;
		int number = n;
		
		while(number != 0) {
			sum += number % 10;
			number /= 10;
		}
		
		return sum;
	}
}
