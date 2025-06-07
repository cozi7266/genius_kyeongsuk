package algo;

import java.util.Arrays;
import java.util.Scanner;

public class BAEKJOON_1920_수찾기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] nArr = new long[N];
			
		for (int i = 0; i < N; i++) {
			nArr[i] = sc.nextLong();
		}
		
		
		Arrays.sort(nArr);
		
		int M = sc.nextInt();
			
		for (int i = 0; i < M; i++) {
			long target = sc.nextLong();
			int result = Arrays.binarySearch(nArr, target) >= 0 ? 1 : 0;
			System.out.println(result);
		}
	}
}
