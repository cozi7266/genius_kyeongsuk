import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_12851_숨바꼭질2 {
	static class Pos {
		int x, time;

		public Pos(int x, int time) {
			this.x = x;
			this.time = time;
		}
	}
	
	static int N, K, minTime, counting;
	static int[] movement;
	static boolean[] check;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		
		bfs();
			
		System.out.println(minTime);
		System.out.println(counting);
				
	}

	private static void bfs() {
		Queue<Pos> queue = new LinkedList<>();
		queue.add(new Pos(N,0));
		check = new boolean[100001];
		check[N] = true;
		
		minTime = Integer.MAX_VALUE;
		
		while(!queue.isEmpty()) {
			Pos pos = queue.poll();
			
			check[pos.x] = true;
			
			if(pos.x == K) {
				if(pos.time < minTime) {
					counting = 1;
					minTime = pos.time;
				}
				else if(pos.time == minTime) counting++;					
			}
			int[] move = {-1, 1, pos.x};
			for (int i = 0; i < move.length; i++) {	
				int nx = pos.x + move[i];
				if(0<=nx && nx <=100000 && !check[nx]){
					queue.add(new Pos(nx, pos.time+1));	
				}
			}
		}
		
	}	
}