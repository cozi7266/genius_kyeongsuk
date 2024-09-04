import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_네트워크연결_1922 {
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
			
			return Integer.compare(this.weight, o.weight);
		}	
	}
	static int N, M;
	static int[] parents;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		parents = new int[N+1];
		Edge[] edgeList = new Edge[M];
		
		for (int i = 0; i < M; i++) {
			edgeList[i] = new Edge(sc.nextInt(),sc.nextInt(),sc.nextInt());
		}
		
		Arrays.sort(edgeList);
		
		makeSet();
		
		int cnt = 0;
		int sum = 0;
		
		for (int i = 0; i < M; i++) {
			if(!union(edgeList[i].from,edgeList[i].to)) continue;
			sum += edgeList[i].weight;
			
			if(++cnt == N - 1) break;					
		}
		
		System.out.println(sum);
			
	} 
	private static boolean union(int x, int y) {
		int xRoot = findSet(x);
		int yRoot = findSet(y);
		
		if(xRoot == yRoot) return false;
		parents[yRoot] = xRoot;
		return true;
	}
	
	private static int findSet(int x) {
		if(parents[x] == x) return parents[x];	
		return parents[x] = findSet(parents[x]);	
	}
	
	private static void makeSet() {
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
		
	}

}
