import java.util.Arrays;
import java.util.Scanner;

public class 이경석_SWEA_1251_하나로 {
	static class Edge implements Comparable<Edge> {
		int from;
		int to;
		double tax;
		
		public Edge(int to, int from, double tax) {
			this.from = from;
			this.to = to;
			this.tax = tax;	
		}	
	@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", tax=" + tax + "]";
		}
	
	@Override
	public int compareTo(Edge o) {
	    return Double.compare(this.tax, o.tax);
	  }
	}
	
	static int N;
	static int[] X,Y;
	static int[] parents;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			parents = new int[N];
			X = new int[N];
			Y = new int[N];
			
			for (int i = 0; i < N; i++) {
				X[i] = sc.nextInt();
			}
			for (int i = 0; i < N; i++) {
				Y[i] = sc.nextInt();
			}
			
			double E = sc.nextDouble();
			
			
			int bridgeNum = N*(N-1)/2;
			Edge[] edgeList = new Edge[bridgeNum];
			
			int tmpCnt = 0;
			for (int i = 0; i < N-1; i++) {
				for (int j = i+1; j < N; j++) {
					int to = i;
					int from = j;
					double distance = E*(Math.pow(X[i] - X[j],2) + Math.pow(Y[i]-Y[j],2));
					edgeList[tmpCnt++] = new Edge(i,j,distance);		
				}
			}
			
			Arrays.sort(edgeList);
			
			make();
			
			int cnt = 0;
			double sum = 0;
			
			for (int i = 0; i < bridgeNum; i++) {
				if(!union(edgeList[i].from, edgeList[i].to)) continue;
				
				sum += edgeList[i].tax;		
			
				if(++cnt == N-1) break;
			}		
			System.out.printf("#%d %.0f\n", t, sum);

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
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}	
	}
}
