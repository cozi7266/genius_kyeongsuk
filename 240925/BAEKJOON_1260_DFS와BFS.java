import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BAEKJOON_1260_DFS와BFS {
	
	static boolean[] visited;
	static ArrayList<Integer>[] graph;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();
	
		graph = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			graph[u].add(v);
			graph[v].add(u);
		}
		
		for (int i = 1; i <= N; i++) {
			Collections.sort(graph[i]);
		}
		
		visited = new boolean[N+1];
		DFS(V);
		System.out.println();
		
		visited = new boolean[N+1];
		BFS(V);
		
	}
	private static void BFS(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			System.out.print(node + " ");
			
			for (int next : graph[node]) {
				if(!visited[next]) {
					visited[next] = true;
					queue.offer(next);
				}
			}
		}
		
	}
	private static void DFS(int node) {
		visited[node] = true;
		System.out.print(node + " ");
		
		for (int next : graph[node]) {
			if(!visited[next]) {
				DFS(next);
			}		
		}	
	}
}
