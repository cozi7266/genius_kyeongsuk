import java.util.Scanner;

public class 이경석_SWEA_1486_장훈이의높은선반 {
	static int sum, B, min, N;
	static int[] workers;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			B = sc.nextInt();
			
			workers = new int[N];
			
			for (int i = 0; i < N; i++) {
				workers[i] = sc.nextInt();
			}
			
			min = Integer.MAX_VALUE;
			

			top(0,0);
			
			int result = min - B;
			
			System.out.println("#"+tc+" "+result);
			
		}//TC
	}//main
	

	private static void top(int i, int sum) {
		if (sum >= min) return;
		
		else if(sum >= B) {
			min = Math.min(sum, min);
			return;
		}
		
		
		if(i >= N) return;
		
		top(i+1, sum + workers[i]);
		
		top(i+1, sum);
	}
}
