import java.util.Scanner;

public class SWEA_3289_서로소집합 {
	static int[] parents;
	static int N;
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
		//#1 001
		int T = sc.nextInt(), t = 0;
		int M;
		while(t++ < T) {
			N = sc.nextInt();  // 7    정점수
			M = sc.nextInt();  // 8    연산의 개수
			parents = new int[N+1];
			make(); // 집합 만들기
			
			StringBuffer sb = new StringBuffer(); // 출력결과 담기
			for (int i = 0; i < M; i++) {
				int op = sc.nextInt();
				int x = sc.nextInt();
				int y = sc.nextInt();
				switch(op) {
				case 0:         // 합치기
					union(x, y);
					break;
				case 1:	        // 두 집합이 같은 인지 체크, 두집합이 같으면 1 다르면 0을 출력
					if(find(x) == find(y)) {
						sb.append("1");
					} else {
						sb.append("0");
					}
				}
			}
			System.out.println("#"+t+ " "+sb.toString());
			
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
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
}
