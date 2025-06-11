package algo.B1316_GroupWordChecker;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int counts = 0;
		
		for (int i = 0; i < N; i++) {
			String word = sc.next();
			char[] arr = word.toCharArray();
			Set<Character> set = new HashSet<>();
			boolean isGroupWord = true;
			
			for (int j = 0; j < arr.length; j++) {
				if(j > 0 && arr[j] == arr[j-1]) continue;
				
				if (set.contains(arr[j])) {
				    isGroupWord = false;
				}
				
				set.add(arr[j]);
				
			}
			
			if(isGroupWord == true) counts++;
		}
		
		System.out.println(counts);
	}
}
