import java.util.Arrays;
import java.util.Scanner;

public class backjoon_1197_최소스패닝트리 {
	static class Edge implements Comparable<Edge> {
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
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}
								
	}
	
	static int V, E;
	static int[] parents;
 	public static void main(String[] args) {
		Scanner sc = new Scanner("3 3\r\n"
				+ "1 2 1\r\n"
				+ "2 3 2\r\n"
				+ "1 3 3\r\n"
				+ "");
		
		V = sc.nextInt();
		E = sc.nextInt();
		parents = new int[V+1];
		
		Edge[] edgeList = new Edge[E];
		
		for (int i = 0; i < E; i++) {
			edgeList[i] = new Edge(sc.nextInt(),sc.nextInt(),sc.nextInt());
		}
		
		Arrays.sort(edgeList);
		
		makeSet();
		int sum = 0;
		int cnt = 0;
		
		for (int i = 0; i < E; i++) {
			if(!union(edgeList[i].from, edgeList[i].to)) continue;
				 
			sum += edgeList[i].weight;
			if(++cnt == V - 1) break;
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
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}
		
	}

}
