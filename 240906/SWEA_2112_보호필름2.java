import java.util.Arrays;
import java.util.Scanner;

public class SWEA_2112_보호필름2 {
	static int D, W, K; // D:행 3~13, W:열1~20, K:통과기준1~D
	static int[][] film; // 보호필름 저장
	static int ans; // 정답(최소 투약 횟수)
	static int[] A, B;

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			D = sc.nextInt();
			W = sc.nextInt();
			K = sc.nextInt();
			film = new int[D][W];
			A = new int[W]; // 이미 0으로 초기화가 되어있어요~~
			B = new int[W]; // 1로 전부 만들어 주자!
			Arrays.fill(B, 1);

			for (int i = 0; i < D; i++) {
				for (int j = 0; j < W; j++) {
					film[i][j] = sc.nextInt();
				}
			} // 보호입력 완료

			ans = K; // 통과기준인 K만큼 쏠 수 있어!

			makefilm(0, 0);

			System.out.println("#" + tc + " " + ans);

		} // tc
	}// main

	// idx : 현재 약을 주입하려고 하는 행
	// cnt : 약품을 주입한 횟수
	private static void makefilm(int idx, int cnt) {
		if (isOk()) {
			ans = Math.min(ans, cnt);
			return;
		}
		if (ans < cnt)
			return; // 이미 나는 더 좋은 값 알고 있어!
		if (idx == D)
			return;

		// 1. 주입 X
		makefilm(idx + 1, cnt);

		int[] tmp = film[idx];

		// 2. 주입 A
		film[idx] = A;
		makefilm(idx + 1, cnt + 1);

		// 3. 주입 B
		film[idx] = B;
		makefilm(idx + 1, cnt + 1);

		// 원상복구
		film[idx] = tmp;

	}

	// 모든 열이 연속된 특성이 K개 이상 인가?
	private static boolean isOk() {
		// 열을 고정시킨 상태에서 검사를 할꺼야
		for (int c = 0; c < W; c++) {
			boolean flag = false;
			int cnt = 1;

			for (int r = 1; r < D; r++) {
				if (film[r][c] == film[r - 1][c])
					cnt++; // 이전과 나와 같다면 카운트
				else
					cnt = 1;

				if (cnt >= K) {
					flag = true;
					break;
				}
			} // 해당 열검사 완료
			if (!flag)
				return false; // 해당 열이 통과하지 못했다. 이후는 볼필요 없어
		} // 모든 열검사 완료
		return true;
	}

	static String input = "10\r\n" + "6 8 3\r\n" + "0 0 1 0 1 0 0 1\r\n" + "0 1 0 0 0 1 1 1\r\n" + "0 1 1 1 0 0 0 0\r\n"
			+ "1 1 1 1 0 0 0 1\r\n" + "0 1 1 0 1 0 0 1\r\n" + "1 0 1 0 1 1 0 1\r\n" + "6 8 3\r\n"
			+ "1 1 1 1 0 0 1 0\r\n" + "0 0 1 1 0 1 0 1\r\n" + "1 1 1 1 0 0 1 0\r\n" + "1 1 1 0 0 1 1 0\r\n"
			+ "1 1 0 1 1 1 1 0\r\n" + "1 1 1 0 0 1 1 0\r\n" + "6 8 4\r\n" + "1 1 0 0 0 1 1 0\r\n"
			+ "1 0 1 0 0 1 1 1\r\n" + "0 1 0 0 1 1 0 0\r\n" + "1 0 1 0 0 0 0 0\r\n" + "1 1 0 0 0 0 0 0\r\n"
			+ "1 0 0 0 1 1 1 1\r\n" + "6 4 4\r\n" + "1 1 0 0\r\n" + "0 1 0 1\r\n" + "0 0 0 1\r\n" + "1 1 1 1\r\n"
			+ "1 1 0 1\r\n" + "1 0 1 0\r\n" + "6 10 3\r\n" + "0 1 0 0 0 1 0 0 1 1\r\n" + "0 1 1 0 0 1 0 0 1 0\r\n"
			+ "0 1 0 0 1 0 1 1 1 1\r\n" + "0 0 0 0 0 1 1 1 1 0\r\n" + "0 1 0 0 1 1 1 1 1 1\r\n"
			+ "1 0 0 0 1 1 0 0 1 1\r\n" + "6 6 5\r\n" + "0 0 0 0 0 0\r\n" + "0 0 0 0 0 0\r\n" + "0 0 0 0 0 0\r\n"
			+ "0 0 0 0 0 0\r\n" + "0 0 0 0 0 0\r\n" + "0 0 0 0 0 0\r\n" + "6 6 4\r\n" + "1 1 1 1 1 1\r\n"
			+ "0 0 0 0 0 1\r\n" + "0 1 1 1 0 1\r\n" + "0 1 0 1 0 1\r\n" + "0 1 0 0 0 1\r\n" + "0 1 1 1 1 1\r\n"
			+ "8 15 3\r\n" + "0 1 1 0 0 1 1 0 1 1 0 0 0 0 0\r\n" + "1 0 0 0 1 1 0 0 0 0 0 1 0 1 1\r\n"
			+ "1 1 0 1 0 1 0 1 0 1 0 1 0 0 0\r\n" + "0 1 1 1 0 0 1 0 0 0 0 1 0 0 0\r\n"
			+ "0 0 0 0 0 0 1 0 0 0 1 1 0 0 1\r\n" + "1 0 1 0 0 1 0 1 1 1 1 0 1 1 1\r\n"
			+ "0 0 0 0 0 1 1 1 0 0 0 0 0 1 0\r\n" + "0 0 1 0 1 1 0 1 1 0 0 0 1 0 0\r\n" + "10 20 4\r\n"
			+ "1 0 1 1 1 1 1 1 1 1 0 0 1 1 1 0 1 1 0 1\r\n" + "1 1 0 1 1 1 0 0 1 0 0 0 1 1 1 1 0 0 1 0\r\n"
			+ "1 1 0 1 1 0 0 0 1 1 1 1 1 0 0 1 1 0 1 0\r\n" + "0 0 0 1 1 0 0 0 0 1 0 0 1 0 1 1 1 0 1 0\r\n"
			+ "0 1 1 0 1 0 1 0 1 0 0 1 0 0 0 0 1 1 1 1\r\n" + "1 0 1 0 1 0 1 1 0 0 0 0 1 1 1 0 0 0 0 0\r\n"
			+ "0 1 0 0 1 1 0 0 0 0 0 1 1 0 0 1 1 0 1 1\r\n" + "1 0 0 0 0 1 0 1 1 0 1 1 0 1 0 0 1 1 1 0\r\n"
			+ "0 1 1 0 0 1 0 1 0 0 0 0 0 0 0 1 1 1 0 1\r\n" + "0 0 0 0 0 0 1 1 0 0 1 1 0 0 0 0 0 0 1 0\r\n"
			+ "13 20 5\r\n" + "1 1 0 1 0 0 0 1 1 1 1 0 0 0 1 1 1 0 0 0\r\n"
			+ "1 1 1 1 0 1 0 1 0 0 0 0 1 0 0 0 0 1 0 0\r\n" + "1 0 1 0 1 1 0 1 0 1 1 0 0 0 0 1 1 0 1 0\r\n"
			+ "0 0 1 1 0 1 1 0 1 0 0 1 1 0 0 0 1 1 1 1\r\n" + "0 0 1 0 0 1 0 0 1 0 0 0 0 1 0 0 0 0 1 1\r\n"
			+ "0 0 1 0 0 0 0 0 0 0 0 0 1 1 1 0 0 1 0 1\r\n" + "0 0 0 1 0 0 0 0 0 0 1 1 0 0 0 1 0 0 1 0\r\n"
			+ "1 1 1 0 0 0 1 0 0 1 1 1 0 1 0 1 0 0 1 1\r\n" + "0 1 1 1 1 0 0 0 1 1 0 1 0 0 0 0 1 0 0 1\r\n"
			+ "0 0 0 0 1 0 1 0 0 0 1 0 0 0 0 1 1 1 1 1\r\n" + "0 1 0 0 1 1 0 0 1 0 0 0 0 1 0 1 0 0 1 0\r\n"
			+ "0 0 1 1 0 0 1 0 0 0 1 0 1 1 0 1 1 1 0 0\r\n" + "0 0 0 1 0 0 1 0 0 0 1 0 1 1 0 0 1 0 1 0\r\n" + "";
}
