package B2475_provenNumber;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int squres = 0;
		
		for (int i = 0; i < 5; i++) {
			int input = sc.nextInt();
			squres += input * input;
		}
		
		int proven = squres % 10;
		
		System.out.println(proven);
	}
}
