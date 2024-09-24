import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Baekjoon_1990_소수인팰린드롬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a =sc.nextInt();
		int b =sc.nextInt();
		boolean[] prime_Check = new boolean[b+1];
		Arrays.fill(prime_Check, true);
		
		
	  //에라토스테네스의 체 : 2부터 시작하고 1씩 증가하는 변수 i가 소수라면 자신을 제외한 자신의 모든 배수를 제외시키면서 소수를 탐색하는 알고리즘
		for (int i = 2;  i <= b; i++) {
		    if (prime_Check[i]) {
		        for (int j = i * i; j <= b; j = j + i) {
		            prime_Check[j] = false;
		        }
		    }
		}

		for (int i = a; i <= b; i++) {
			if(prime_Check[i] == true && sysmetry_Check(i))
				System.out.println(i);
		}
		System.out.println(-1);
		
		
	}

	
	// 대칭판별 함수
	private static boolean sysmetry_Check(int num) {
		String tmp = Integer.toString(num);
		char[] line = tmp.toCharArray();
		int size = line.length;
		
		for (int i = 0; i < size/2; i++) {
			if(line[i] != line[size-1-i]) return false;
		}
		return true;
		
	}

}
