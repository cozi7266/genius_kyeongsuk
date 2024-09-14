

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Baekjoon_1976_여행가자 {
	static int N, M;
	static int[] parents;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		N = sc.nextInt();
		M = sc.nextInt();
		parents = new int[N+1];
		
		make();
		
		int[][] adj = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
			 adj[i][j] = sc.nextInt();
			 if(adj[i][j] == 1)
				 union(i,j);
		   }		
	    }
			
		Set<Integer> set = new HashSet<>();
	
		for (int i = 1; i <= N; i++) {
			set.add(find(i));	
		}
		
		if(set.size() == 1)
			System.out.println("YES");
		else
			System.out.println("NO");
	
}
	private static void make() {
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
		
	}
	private static boolean union(int i, int j) {
		int iRoot = find(i);
		int jRoot = find(j);
		
		if(iRoot == jRoot) return false;
		parents[jRoot] = iRoot;
		return true;
		
	}
	private static int find(int i) {
		if(parents[i] == i) return parents[i];
		return parents[i] = find(parents[i]);
	}
	
	
	
}
