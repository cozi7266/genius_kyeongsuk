import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BAEKJOON_2206_벽부수고이동하기 {
	static class Node {
		int x, y, cnt;
		boolean skill;

		public Node() {}
		public Node(int x, int y, int cnt, boolean skill) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.skill = skill;
		}			
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int N, M, min;
	static boolean[][][] check;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		check = new boolean[N][M][2];
		min = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			String tmp = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = tmp.charAt(j)-'0';
			}
		}
		
		int result = bfs(new Node(0,0,1,false));
		
		System.out.println(result);
		
		
	}// main
	
	private static int bfs(Node start) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(start);
		check[start.x][start.y][0] = true;
		
		while(!queue.isEmpty()) {
			Node pop = queue.poll();
			if(pop.x == N - 1 && pop.y == M - 1) {
				min = Math.min(min, pop.cnt);
			}
			for (int k = 0; k < 4; k++) {
				int nr = pop.x + dr[k];
				int nc = pop.y + dc[k];
				if(nr >= 0 && nr < N && nc >= 0 && nc < M ) {
					
					if(map[nr][nc] == 0) {
						
						if(!pop.skill && !check[nr][nc][0]) {
						queue.add(new Node(nr,nc,pop.cnt+1,false));
						check[nr][nc][0] = true;
					   }
						else if (pop.skill && !check[nr][nc][1]) {
						queue.add(new Node(nr,nc,pop.cnt+1,true));
						check[nr][nc][1] = true;	
						}
					}
					
					else if (map[nr][nc] == 1 && !pop.skill) {
						queue.add(new Node(nr,nc,pop.cnt+1,true));
						check[nr][nc][1] = true;					
					}
				}
				
			}	
		}
		if(min == Integer.MAX_VALUE) return -1;
		return min;
	}
}