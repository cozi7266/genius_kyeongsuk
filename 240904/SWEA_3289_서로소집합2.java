import java.util.Scanner;

public class SWEA_3289_서로소집합2 {
	static int n, m;
	static int[] parents;
	public static void main(String[] args) {
		Scanner sc = new Scanner("1\r\n"
				+ "7 8\r\n"
				+ "0 1 3\r\n"
				+ "1 1 7\r\n"
				+ "0 7 6\r\n"
				+ "1 7 1\r\n"
				+ "0 3 7\r\n"
				+ "0 4 2\r\n"
				+ "0 1 1\r\n"
				+ "1 1 1");
		int T = sc.nextInt();
		int t = 0;
		while(t++ < T) {
			n = sc.nextInt();
			int m = sc.nextInt();
			parents = new int[n+1];
			make();
			
			StringBuffer sb = new StringBuffer();
			
			for (int i = 0; i < m; i++) {
				int op = sc.nextInt();
				int x = sc.nextInt();
				int y = sc.nextInt();
				switch(op) {
				case 0 :
					union(x,y);
					break;
				case 1:
					if(find(x) == find(y))
						sb.append("1");
					else
						sb.append("0");
				}
			}
			System.out.println("#"+t+" "+sb.toString());
		}
		
	}

	private static int find(int x) {
		if(parents[x] == x) return x;
		return parents[x] = find(parents[x]);
	}

	private static boolean union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		if(xRoot == yRoot) return false;
		
		parents[yRoot] = xRoot;
		return true;
		
	}

	private static void make() {
		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}
		
	}
}
