package boj_11652_card;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		
		if(N == 0) {
			return;
		}
		
		long[] cards = new long[N];
		
		for (int i = 0; i < N; i++) {
			cards[i] = sc.nextLong();
		}
		
		Arrays.sort(cards);
		
		long answer = cards[0];
		int maxCount = 1;
		int currentCount = 1;
		
		for (int i = 1; i < N; i++) {
			if(cards[i] == cards[i-1]) {
				currentCount++;
			}
			else {
				currentCount = 1;
			}
			
			if(currentCount > maxCount) {
				maxCount = currentCount;
				answer = cards[i];
			}
			
		}
		
		System.out.println(answer);
		
		sc.close();
	
		
		
		
	}
}
