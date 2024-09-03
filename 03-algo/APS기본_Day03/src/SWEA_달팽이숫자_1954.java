import java.util.Scanner;

public class SWEA_달팽이숫자_1954 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(), t = 0;
		int[] dr = {0, 1, 0, -1};
		int[] dc = {-1, 0, 1, 0};
		while (t++ < T) {
			int N = sc.nextInt();
			int map[][] = new int[N][N];
			int num = 0;
			int d = 0, r = 0, c = 1;
			while (num < N * N) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] != 0) {
					d = (d + 1) % 4;
					continue;
				}
				
				map[nr][nc] = ++num;	
				r = nr;
				c = nc;
			}

			System.out.println("#" + t);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(map[i][j] + " ");
				}	
				System.out.println();
			}
		}
		sc.close();
		
	}
}