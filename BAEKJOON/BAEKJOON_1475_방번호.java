package algo;

import java.util.Scanner;

public class BAEKJOON_1475_방번호 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input = sc.next();
		
		char[] inputArr = input.toCharArray();
		
		
		int[] countArr = new int[9];
		
		for (int i = 0; i < inputArr.length; i++) {
			if(inputArr[i] - '0' == 9) countArr[6]++; 
			else countArr[inputArr[i] - '0']++;
		}
		
		countArr[6] = (countArr[6]+1) / 2;
		
		int set = 0;
		
		for (int i = 0; i < countArr.length; i++) {
			set = Math.max(set, countArr[i]);
		}
		
		System.out.println(set);
		
	}
}
