package B10809_findAlphabet;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String word = sc.nextLine();
		
		char[] wordAlphabets = word.toCharArray();
		
		int[] alphabetOrder = new int[26];
		
		Arrays.fill(alphabetOrder, -1);
		
		for (int i = 0; i < wordAlphabets.length; i++) {
			
			if(alphabetOrder[wordAlphabets[i] - 97] == -1) {
				alphabetOrder[wordAlphabets[i] - 97] = i;
			}
		}
		
		for (int i = 0; i < alphabetOrder.length; i++) {
			System.out.print(alphabetOrder[i] + " ");
		}
		
		
		
		
	}
}
