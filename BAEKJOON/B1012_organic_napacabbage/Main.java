package B1012_organic_napacabbage;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int M, N, bugs;
	static int[][] field;
	static boolean[][] isChecked;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 0; t < T; t++) {
			
			M = sc.nextInt();
			N = sc.nextInt();
			
			field = new int[N][M];
			isChecked = new boolean[N][M];
			
			bugs = 0;
			
			int K = sc.nextInt();
			
			for (int k = 0; k < K; k++) {
				int m = sc.nextInt();
				int n = sc.nextInt();
				
				field[n][m] = 1;
			}
			
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					if(field[n][m] == 1 && isChecked[n][m] == false) {
						countingBugs(n, m);
						bugs++;
					}
				}
			}
			
			System.out.println(bugs);
			
				
		}
	}

	private static void countingBugs(int n, int m) {
		isChecked[n][m] = true;
		
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(new int[] {n, m});
		
		while(!queue.isEmpty()) {
			
			int[] pop = queue.poll();
			
			for (int l = 0; l < 4; l++) {
				int nr = pop[0] + dr[l];
				int nc = pop[1] + dc[l];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < M && !isChecked[nr][nc] && field[nr][nc] == 1) {
					isChecked[nr][nc] = true;
					queue.add(new int[] {nr, nc});
				}
			}
			
		}	
		
	}

	
}
