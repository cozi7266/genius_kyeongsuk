import java.util.Scanner;

public class BAEKJOON_10974_모든순열 {
	static int N;
	static int[] output;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		N = sc.nextInt();
		output = new int[N];
		visited = new boolean[N];
		
		permute(0);
		
	}

	private static void permute(int depth) {
		if(depth == N) {
			for (int i = 0; i < N; i++) {
				System.out.print(output[i]+" ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				output[depth] = i + 1;
				permute(depth + 1);
				visited[i] = false;
			}
		}
	}	
}
