import java.util.Scanner;

public class 등산로문제연습 {
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int N, K, maxH, ans;
	static boolean[][] visited;
	static int[][] mountain;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			mountain = new int[N][N];
			visited = new boolean[N][N];
			maxH = 0;
			ans = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					mountain[i][j] = sc.nextInt();
					maxH = Math.max(mountain[i][j], maxH);
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(mountain[i][j] == maxH)
						work(i,j,1,true);
				}			
			}		
			System.out.println("#"+tc+" "+ans);	
		}//TC					
	}// main
	
	

	
	private static void work(int r, int c, int dist, boolean skill) {
		ans = Math.max(ans, dist);
		
		visited[r][c] = true;
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr<0 || nr>=N || nc<0 || nc>=N || visited[nr][nc]) continue;
			
			if(mountain[r][c] > mountain[nr][nc]) {
				work(nr,nc,dist+1,skill);
			}
			else if(skill && mountain[r][c] > mountain[nr][nc] - K) {
				int tmp = mountain[nr][nc];
				mountain[nr][nc] = mountain[r][c] - 1;
				work(nr, nc, dist+1, false);
				mountain[nr][nc] = tmp;
			  }
			}
		
		visited[r][c] = false;
			
		}
}
