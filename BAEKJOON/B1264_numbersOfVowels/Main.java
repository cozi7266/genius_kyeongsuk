package B1264_numbersOfVowels;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			String input = sc.nextLine();
			if(input.equals("#")) break;
			
			char[] arr = input.toLowerCase().toCharArray();
			int vowels = 0;
			
			for (char c : arr) {
				if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
					vowels++;
				}
			}			
			System.out.println(vowels);
		}
	}
}
