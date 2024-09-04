import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SWEA_7465_창용마을무리의개수 {
	static class Edge implements Comparable<Edge> {
		int from;
		int to;
		
		public Edge(int from, int to) {
			super();
			this.from = from;
			this.to = to;
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + "]";
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.to - o.to;
		}
		
	}
	static int V,E;
	static int[] parents;
	static int cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {	
			V = sc.nextInt();
			E = sc.nextInt();
			cnt = 0;
			Edge[] edge = new Edge[E];
			parents = new int[V+1];
			make();
			
			for (int i = 0; i < E; i++) {
				edge[i] = new Edge(sc.nextInt(),sc.nextInt());
			}
			
			Arrays.sort(edge);
			
			for (int i = 0; i < E; i++) {
				union(edge[i].from, edge[i].to);
			}
			
			Set<Integer> set = new HashSet<>();
			
			for (int i = 1; i <= V; i++) {
				set.add(find(parents[i]));
			}
			
			
			
				
			System.out.println("#"+t+" "+set.size());
			
		}	
	}
	
	private static boolean union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		
		if(xRoot == yRoot) return false;	
	    parents[yRoot] = xRoot;
	    return true;
	}	   
		   
	   

	private static int find(int x) {
		if(parents[x] == x) return x;
		return parents[x] = find(parents[x]);		
	}

	private static void make() {
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}	
	}
}
