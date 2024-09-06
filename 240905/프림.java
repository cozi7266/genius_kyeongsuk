import java.util.Arrays;
import java.util.Scanner;

public class 프림 {
	public static void main(String[] args) {
		Scanner sc = new Scanner("7 11\r\n"
				+ "0 1 32\r\n"
				+ "0 2 31\r\n"
				+ "0 5 60\r\n"
				+ "0 6 51\r\n"
				+ "1 2 21\r\n"
				+ "2 4 46\r\n"
				+ "2 6 25\r\n"
				+ "3 4 34\r\n"
				+ "3 5 18\r\n"
				+ "4 5 40\r\n"
				+ "4 6 51\r\n"
				+ "");
		
		int V = sc.nextInt();
		int E = sc.nextInt();
		int[][] adj = new int[V][V];
		for (int i = 0; i < E; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			int w = sc.nextInt();
			adj[v1][v2] = adj[v2][v1] = w;
		}
		
		int[] p = new int[V];          // 누구로 부터
		int[] D = new int[V];          // 최소비용
		boolean[] v = new boolean[V];  // 신장트리 포함 여부
		
		Arrays.fill(p, -1);
		Arrays.fill(D, Integer.MAX_VALUE);
		
		D[0] = 0;  // 시작 정점
		int ans = 0;
		for (int i = 0; i < V; i++) {
			// 최소인 것 찾기
			int minCost = Integer.MAX_VALUE;
			int minVertex = -1;
			for (int j = 0; j < v.length; j++) {
				if(!v[j] && minCost > D[j]) {
					minCost = D[j];
					minVertex = j;
				}
			}
			
			ans += minCost;         // 신장트리에 포함된 정점들의 총 비용
			v[minVertex] = true;    // 신장트리 포함
			
			// 최소인 정점의 인접 정점들의 비용 업데이트
			for (int j = 0; j < V; j++) {
				if(!v[j] 
						&& adj[minVertex][j] != 0
					    && D[j] > adj[minVertex][j]){
				D[j] = adj[minVertex][j];
				p[j] = minVertex;
				
			  }
		   }
		}
		System.out.println(ans);	
	}
}
