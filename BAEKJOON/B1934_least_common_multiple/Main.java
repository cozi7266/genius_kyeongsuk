package B1934_least_common_multiple;

import java.util.Scanner;

public class Main {
	
	// 최대공약수 (GCD)를 구하는 함수 - 유클리드 호제법
	// 재귀 방식
	public static int gcd(int A, int B) {
		if(B == 0) {
			return A;
		}
		
		return gcd(B, A % B);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 0; t < T; t++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			// 최소공배수(LCM) 계산
			// LCM(A, B) = (A * B) / GCD(A, B)
			long lcm = (A * B) / gcd(A, B);
			System.out.println(lcm);
			
		}
	}
}
