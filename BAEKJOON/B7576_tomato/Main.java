package algo.B7576_tomato;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main{
	
	static int M, N;
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static int[][] box;
	static boolean[][] isVisited;
	
	static class Point{
		int r,c,days;

		public Point(int r, int c, int days) {
			this.r = r;
			this.c = c;
			this.days = days;
		}
		
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		
		box = new int[N][M];
		isVisited = new boolean[N][M];
		
		Queue<Point> queue = new LinkedList<>();
		int unripeTomatoes = 0; 
		
		for (int i = 0; i < N; i++) { 
            for (int j = 0; j < M; j++) { 
                box[i][j] = sc.nextInt();
                if (box[i][j] == 1) {
                    queue.add(new Point(i, j, 0)); 
                    isVisited[i][j] = true; 
                } else if (box[i][j] == 0) {
                    unripeTomatoes++;
                }
            }
        }
		
		
        int maxDays = 0; 

    
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            maxDays = current.days; 

            for (int k = 0; k < 4; k++) {
                int nr = current.r + dr[k];
                int nc = current.c + dc[k];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M && !isVisited[nr][nc] && box[nr][nc] == 0) {
                    box[nr][nc] = 1; 
                    unripeTomatoes--; 
                    queue.add(new Point(nr, nc, current.days + 1)); 
                }
            }
        }
        
        if (unripeTomatoes == 0) { 
        	System.out.println(maxDays);
        } else { 
        	System.out.println(-1);
        }

	}
}
