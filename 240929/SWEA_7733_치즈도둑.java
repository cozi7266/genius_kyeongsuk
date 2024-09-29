import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_7733_치즈도둑 {
	static class Node {
		int r,c;

		public Node() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}	
	}
	static int N, cnt;
	static int[][] map;
	static boolean[][] check;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			map = new int[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			int max = 0;
			for (int day = 0; day <= 100; day++) {
				cnt = 0;
				check = new boolean[N][N];
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						if(!check[r][c] && map[r][c] > day) {
							bfs(new Node(r,c),day);
							cnt++;
						}
					}				
				}
				max = Math.max(cnt,max);
			}
			
			System.out.println("#"+t+" "+max);
		}
	}
	private static void bfs(Node start, int day) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(start);
		check[start.r][start.c] = true;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			for (int k = 0; k < 4; k++) {
				int nr = node.r + dr[k];
				int nc = node.c + dc[k];
				if(nr >= 0 && nr < N && nc >= 0 && nc < N && !check[nr][nc] && map[nr][nc] > day) {
					queue.add(new Node(nr,nc));
					check[nr][nc] = true;
				}
			}
		}	
	}
}
