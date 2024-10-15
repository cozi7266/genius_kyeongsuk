import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BAEAKJOON_4963_섬의개수 {
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int w;
	static int h;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			w = sc.nextInt();
			h = sc.nextInt();
			if(w == 0 && h == 0) break;
			map = new int[h][w];
			visited = new boolean[h][w];

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			int cnt = 0;

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (!visited[i][j] && map[i][j] == 1) {
						cnt++;
						bfs(i, j);
					}
				}
			}
			System.out.println(cnt);
		}
	}

	private static void bfs(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { i, j });
		visited[i][j] = true;

		while (!queue.isEmpty()) {
			int[] pop = queue.poll();
			for (int k = 0; k < 6; k++) {
				int nr = pop[0] + dr[k];
				int nc = pop[1] + dc[k];
				if (nr >= 0 && nr < h && nc >= 0 && nc < w && !visited[nr][nc] && map[nr][nc] == 1) {
					queue.add(new int[] { nr, nc });
					visited[nr][nc] = true;
				}
			}
		}

	}
}
