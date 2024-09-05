import java.util.Scanner;

public class Baekjoon_1717_집합의표현 {
	static int[] parents;
	static int n,m;
	public static void main(String[] args) {
		Scanner sc = new Scanner("7 8\r\n"
				+ "0 1 3\r\n"
				+ "1 1 7\r\n"
				+ "0 7 6\r\n"
				+ "1 7 1\r\n"
				+ "0 3 7\r\n"
				+ "0 4 2\r\n"
				+ "0 1 1\r\n"
				+ "1 1 1\r\n"
				+ "");
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		parents = new int[n+1];
		
		make();
		
		for (int i = 0; i < m; i++) {
			int op = sc.nextInt();
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			
			switch(op) {
				case 0:
					union(from,to);
					break;
				case 1:
					if(!check(from,to)) {
						System.out.println("Yes");
						break;
					}
					
					else {
						System.out.println("No");
						break;
				}
			}			
		}
	}
	private static void make() {
		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}
		
	}
	private static boolean check(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		
		if(xRoot == yRoot) return false;
		return true;
	}
	
	
	
	private static boolean union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		
		if(xRoot == yRoot) return false;
		
		parents[yRoot] = xRoot;
		return true;
		
	}

	private static int find(int x) {
		if(parents[x] == x) return parents[x];
		return parents[x] = find(parents[x]);
	}

}
