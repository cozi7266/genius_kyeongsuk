import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BAEKJOON_2146_다리만들기 {
	static class Node {
		int x, y, cnt;

		public Node() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Node(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}				
	}
	
	static int[] dr = {-1, 1, 0 ,0}; 
	static int[] dc = {0, 0, -1 ,1};
	static boolean[][] visited;
	static int[][] map;
	static int N, indtf, min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(string);
		N = sc.nextInt();
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		indtf = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j] && map[i][j] == 1) {
					indentify_Island(new Node(i,j,0));
				}
			}
		}
		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//					System.out.print(map[i][j]+" ");
//				}
//			System.out.println();
//			}
		
		
		min = Integer.MAX_VALUE;
		
		for (int islandNum = 1; islandNum <= indtf; islandNum++) {
			bfs(islandNum);
		}
		
		System.out.println(min);
		
		
		
		
	}// main
	
	
	

	
	private static void bfs(int islandNum) {
		Queue<Node> queue2 = new LinkedList<>();
		boolean[][] visited2 = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == islandNum ) {
					queue2.add(new Node(i,j,0));
					visited2[i][j] = true;
				}
			}
		}

		while(!queue2.isEmpty()) {
			Node node2 = queue2.poll();
			
			for (int k = 0; k < 4; k++) {
				int nr = node2.x + dr[k];
				int nc = node2.y + dc[k];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if(map[nr][nc] != 0 && map[nr][nc] != islandNum) {
						min = Math.min(min, node2.cnt);
						return;
					}
					if (!visited2[nr][nc] && map[nr][nc] == 0) {
                        queue2.add(new Node(nr, nc, node2.cnt + 1));
                        visited2[nr][nc] = true;
				}
			}
		}
	  }
	}




	private static void indentify_Island(Node island) {
		Queue<Node> queue1 = new LinkedList<>();
		queue1.add(island);
		visited[island.x][island.y] = true;
		map[island.x][island.y] = ++indtf;
		
		while(!queue1.isEmpty()) {
			Node node1 = queue1.poll();
			for (int k = 0; k < 4; k++) {
				int nr = node1.x + dr[k];
				int nc = node1.y + dc[k];
				if(nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && map[nr][nc] == 1) {
					map[nr][nc] = indtf;
					queue1.add(new Node(nr,nc,0));
					visited[nr][nc] = true;
				}
			}
		}
	}


















	static String string = "10\r\n"
			+ "1 1 1 0 0 0 0 1 1 1\r\n"
			+ "1 1 1 1 0 0 0 0 1 1\r\n"
			+ "1 0 1 1 0 0 0 0 1 1\r\n"
			+ "0 0 1 1 1 0 0 0 0 1\r\n"
			+ "0 0 0 1 0 0 0 0 0 1\r\n"
			+ "0 0 0 0 0 0 0 0 0 1\r\n"
			+ "0 0 0 0 0 0 0 0 0 0\r\n"
			+ "0 0 0 0 1 1 0 0 0 0\r\n"
			+ "0 0 0 0 1 1 1 0 0 0\r\n"
			+ "0 0 0 0 0 0 0 0 0 0\r\n"
			+ "";
}
