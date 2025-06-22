package B1357_revPlus;

import java.util.Scanner;

public class Main {
	
	public static int Rev(int n) {
		
		String s = String.valueOf(n);
		
		StringBuilder sb = new StringBuilder(s);
		String reversedString = sb.reverse().toString();
		
		return Integer.parseInt(reversedString);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int X = sc.nextInt();
		int Y = sc.nextInt();
		
		int revX = Rev(X);
		
		int revY = Rev(Y);
		
		int sumRev = revX + revY;
		
		int result = Rev(sumRev);
		
		System.out.println(result);
		
		
		
	}
}
