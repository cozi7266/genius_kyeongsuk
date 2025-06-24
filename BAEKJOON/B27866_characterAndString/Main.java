package B27866_characterAndString;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String S = sc.nextLine();
		int i = sc.nextInt();
		
		char[] StoChars = S.toCharArray();
		
		System.out.println(StoChars[i - 1]);
	}
}
