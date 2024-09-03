import java.util.*;
class SWEA_Sum_1209_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(), t = 0;
		while (t++ < T) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] array = new int[N][M];
			int ans = 0, sum = 0;
			// 입력
			for (int r = 0; r < N; r++) 
				for (int c = 0; c < M; c++) 
					array[r][c] = sc.nextInt();
			
			// 가장 큰 행의 합 구하기
			for (int r = 0; r < N; r++) { 
				for (int c = 0; c < M; c++) sum += array[r][c];
				
				ans = Math.max(ans, sum);
				sum = 0;
			}

			// 가장 큰 열의 합 구하기
			for (int r = 0; r < N; r++) { 
				for (int c = 0; c < M; c++) sum += array[c][r];
				
				ans = Math.max(ans, sum);
				sum = 0;
			}
			
			System.out.println("#" + t + " " + ans);
		}
	}
}