package algo;

import java.util.Iterator;
import java.util.Scanner;

public class BAEKJOON_2908 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String num1 = sc.next();
		String num2 = sc.next();
		
		char[] charNum1 = num1.toCharArray();
		char[] charNum2 = num2.toCharArray();
		
		int size = num1.length() - 1;
		
		
		for (int i = 0; i < num1.length()/2; i++) {
			char bin1 = charNum1[size - i]; 
			charNum1[size - i] = charNum1[i]; 
			charNum1[i] = bin1;
			
			char bin2 = charNum2[size - i]; 
			charNum2[size - i] = charNum2[i]; 
			charNum2[i] = bin2;			
		}
		
		num1 = String.copyValueOf(charNum1);
		num2 = String.copyValueOf(charNum2);
		
		int realNum1 = Integer.parseInt(num1);
		int realNum2 = Integer.parseInt(num2);
		
		if(realNum1 > realNum2) System.out.println(realNum1);
		else System.out.println(realNum2);
		
		
		
		
	}

}
