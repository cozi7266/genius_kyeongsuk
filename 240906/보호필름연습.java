import java.util.Scanner;

public class 보호필름연습 {
	static int D, W, K;
	static int[][] film;
	static int minCnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();	
		for (int tc = 1; tc <= TC; tc++) {
			D = sc.nextInt();
			W = sc.nextInt();
			K = sc.nextInt();
			film = new int[D][W];
			
			for (int r = 0; r < D; r++) {
				for (int c = 0; c < W; c++) {
					film[r][c] = sc.nextInt();
				}
			}		
			minCnt = D;
			
			makefilm(0,0);
			
			System.out.println("#"+tc+" "+minCnt);	
		}// TC
		
	}// main
	
	private static void makefilm(int idx, int cnt) {
		if(idx == D) {
			if(isOk()) 
				minCnt = Math.min(cnt, minCnt);
			return;
		}
		
		makefilm(idx+1, cnt);
		
		int[] tmp = new int[W];
		for (int i = 0; i < W; i++) {
			tmp[i] = film[idx][i];
		}
		
		injection(idx, 0);
		makefilm(idx+1, cnt+1);
		
		injection(idx, 1);
		makefilm(idx+1, cnt+1);
		
		
		for (int i = 0; i < W; i++) {
			film[idx][i] = tmp[i];
		}
	}

	private static void injection(int dIdx, int chemical) {
		for (int i = 0; i < W; i++) {
			film[dIdx][i] = chemical;
		}
	}

	private static boolean isOk() {
		for (int c = 0; c < W; c++) {
			boolean valid = false;
			int sequential_cnt = 1;
			
			for (int r = 1; r < D; r++) {
				if(film[r-1][c] == film[r][c]) sequential_cnt++;
				else sequential_cnt = 1;
			
			    if(sequential_cnt >= K) {
				   valid = true;
				   break;
			  }
		   }
		   if(!valid) return false;
		}
		return true;
	}
}	
