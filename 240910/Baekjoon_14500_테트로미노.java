import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_14500_테트로미노 {
	static class Pos {
		int r,c,cnt,sum;

		public Pos(int r, int c, int cnt, int sum) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.sum = sum;
		}
						
	}
	
	static int N, M, max;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0 , 0};
	static int[] dc = {0, 0, -1 , 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int [N][M];
		visited = new boolean[N][M];
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		
		max = 0;
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				visited[r][c] = true;
				dfs(new Pos(r,c,1,map[r][c]),r ,c);
				visited[r][c] = false;
			}
		}
		
		for (int i = 0; i < N; i++) {
		    for (int j = 0; j < M; j++) {
		        // T자형 테트로미노의 중심이 (i, j)일 때 가능한 모든 합을 계산
		        if (j - 1 >= 0 && j + 1 < M && i + 1 < N) {  // 가로로 세 개, 아래로 하나
		            int sumT = map[i][j] + map[i][j - 1] + map[i][j + 1] + map[i + 1][j];
		            max = Math.max(max, sumT);
		        }
		        if (j - 1 >= 0 && j + 1 < M && i - 1 >= 0) {  // 가로로 세 개, 위로 하나
		            int sumT = map[i][j] + map[i][j - 1] + map[i][j + 1] + map[i - 1][j];
		            max = Math.max(max, sumT);
		        }
		        if (i - 1 >= 0 && i + 1 < N && j + 1 < M) {  // 세로로 세 개, 오른쪽으로 하나
		            int sumT = map[i][j] + map[i - 1][j] + map[i + 1][j] + map[i][j + 1];
		            max = Math.max(max, sumT);
		        }
		        if (i - 1 >= 0 && i + 1 < N && j - 1 >= 0) {  // 세로로 세 개, 왼쪽으로 하나
		            int sumT = map[i][j] + map[i - 1][j] + map[i + 1][j] + map[i][j - 1];
		            max = Math.max(max, sumT);
		        }
		    }
		}

		
		
		System.out.println(max);
		
		
	}

	private static void dfs(Pos start, int r, int c) {
			if(start.cnt == 4) {
				max = Math.max(max, start.sum);
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) continue;
				visited[nr][nc] = true;
				dfs(new Pos(nr,nc,start.cnt + 1,start.sum + map[nr][nc]),nr ,nc);
				visited[nr][nc] = false;					
			}
		}				
	}

