import java.util.Arrays;

public class 오늘의할일 {
	static int N, R;
	static int[] sel; // 각 자리에 선택된 값을 넣어주자
	static int[] data;
	public static void main(String[] args) {
		N = 4;
		R = 3;
		data = new int[] {10, 20, 30, 40};
		
		sel = new int[N];
		System.out.println("부분집합반복 --------------------");
		부분집합반복();
		System.out.println("부분집합재귀 --------------------");
		부분집합재귀(0);
		System.out.println("부분집합비트마스킹 --------------------");
		부분집합비트마스킹();
		
		sel = new int[R];
		System.out.println("조합반복문 --------------------");
		조합반복문();
		System.out.println("조합반복재귀 --------------------");
		조합반복재귀(0, 0);

		sel = new int[R];
		System.out.println("조합재귀 --------------------");
		조합재귀(0, 0);  // 데이터의 위치, 선택한 데이터의 위치
	}
	
	
	private static void 부분집합비트마스킹() {
		// 2^N 개 만큼 경우의 수가 나온다.
		for (int i = 0; i < (1 << N); i++) {  // i : 하나의 경우의 수
//			System.out.println(i + "," + Integer.toBinaryString(i));
			// 하나의 경우에 대한 N개의 데이터에 대한 선택과 비선택 여부 체크
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) != 0) {
					System.out.print(data[j] + " ");
				}
			}
			System.out.println();
			
		}
		
	}


	private static void 부분집합재귀(int idx) {
		if (idx == N) {
			for (int i = 0; i < N; i++) {
				if (sel[i] == 0) continue; // 선택되지 않은 경우
				
				System.out.print(data[i] + " ");
			}
			System.out.println();
			return;
		}
		// 미선택
		sel[idx] = 0;
		부분집합재귀(idx + 1);
		// 선택
		sel[idx] = 1;
		부분집합재귀(idx + 1);
	}


	private static void 부분집합반복() {
		for (int i = 0; i < 2; i++) {					// 첫번째 요소의 포함 여부
			sel[0] = i;	
			for (int j = 0; j < 2; j++) {				// 두번째 요소의 포함 여부
				sel[1] = j;	
				for (int k = 0; k < 2; k++) {			// 세번째 요소의 포함 여부
					sel[2] = k;	
					for (int m = 0; m < 2; m++) {			// 세번째 요소의 포함 여부
						sel[3] = m;
						
						for (int n = 0; n < N; n++) {
							if (sel[n] == 0) continue; // 선택되지 않은 경우
							
							System.out.print(data[n] + " ");
						}
						System.out.println();
						
					}
				}
			}
		}
	}

	// idx : 현재 판단하는 값
	// selectIndex : 선택된 항목
	private static void 조합재귀(int idx, int selectIndex) {
		if (selectIndex == R) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		
		if (idx == N) {
			return;
		}

		// 선택한 경우
		sel[selectIndex] = data[idx];
		조합재귀(idx + 1, selectIndex + 1);
		
		// 선택하지 않은 경우
		조합재귀(idx + 1, selectIndex);
	}
	
	// R의 갯수가 정해져 있는 경우 가능함
	private static void 조합반복재귀(int start, int idx) {
		if (idx == R) {
//			System.out.println(Arrays.toString(sel));
			for (int i = 0; i < R; i++) {
				System.out.print(data[sel[i]] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = start; i <= N - R + idx; i++) {  // 첫번째 자리
			sel[idx] = i;
			조합반복재귀(i + 1, idx + 1);
		}
	}
	
	// R의 갯수가 정해져 있는 경우 가능함
	private static void 조합반복문() {
		for (int i = 0; i <= N - R + 0; i++) {  // 첫번째 자리
			for (int j = i + 1; j <= N - R + 1; j++) {  // 두번째 자리
				for (int k = j + 1; k <= N - R + 2; k++) {	// 세번째 자리
					System.out.println(i + "," + j + "," + k);
				}
			}
		}
	}
}



