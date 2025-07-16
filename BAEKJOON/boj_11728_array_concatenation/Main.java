package boj_11728_array_concatenation;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		List<Integer> combinedList = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			combinedList.add(sc.nextInt());
		}
		
		for (int j = 0; j < M; j++) {
			combinedList.add(sc.nextInt());
		}
		
		Collections.sort(combinedList);
		
		StringBuilder sb = new StringBuilder(); 
		for (Integer element : combinedList) {
		    sb.append(element).append(" "); 
		}
		System.out.println(sb.toString().trim()); 

		sc.close();
		
	}
}
