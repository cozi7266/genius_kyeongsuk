import java.util.Arrays;
import java.util.Scanner;

public class 크루스칼오프라인연습 {
	static class Edge implements Comparable<Edge>{
		int from, to, weight;
				
		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}

		@Override
		public int compareTo(Edge o) {			
			return this.weight - o.weight;
		}		
	}
	static int V, E;
	static int[] parents;
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
		V = sc.nextInt();
		E = sc.nextInt();
		parents = new int[V];
		Edge[] edgeList = new Edge[E];
		for (int i = 0; i < E; i++) {  // 간선정보 저장
			edgeList[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		
		Arrays.sort(edgeList);
		
		make();
		
		int cnt = 0; // 선택된 간선의 수
		int sum = 0;
		for (Edge e : edgeList) {
			if(!union(e.from, e.to)) continue;
			
			sum += e.weight;
			if(++cnt == V-1) {
				break;
			}		
		}
		System.out.println(sum);
		
		
		
		
	}
	
	// 합치기
	private static boolean union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		if(xRoot == yRoot) return false;
		parents[yRoot] = xRoot;
		return true;
	}
	
	//찾기
	private static int find(int x) {
		if(parents[x] == x) return x;
		
		return parents[x] = find(parents[x]); 
		
	}
	
	//만들기
	private static void make() {
		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}
		
	}
}
