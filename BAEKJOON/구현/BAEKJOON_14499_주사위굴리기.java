import java.util.Scanner;

public class BAEKJOON_14499_주사위굴리기 {
	// dr[0]과 dc[0]은 그냥 편의상 설정 의미X
	// 인덱스 1부터 동쪽, 서쪽, 북쪽, 남쪽 순으로
	static int[] dr = { 0, 0, 0, -1, 1 };
	static int[] dc = { 0, 1, -1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	// 세로 크기 N
		int M = sc.nextInt();	// 가로 크기 M
		int x = sc.nextInt();   // 주사위를 놓은 곳의 좌표 x
		int y = sc.nextInt();   // 주사위를 놓은 곳의 좌표 y
		int K = sc.nextInt();	// 명령의 개수 K
		
		int[][] map = new int[N][M];	// 지도

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		// 주사위 6면의 각각의 값을 저장할 배열
		int[] dice = new int[6];	// 주사위의 상태 (0: 위, 1: 서, 2: 북, 3: 동, 4: 남, 5: 아래)

		for (int t = 0; t < K; t++) {
			// 이동 명령 (1. 동쪽, 2. 서쪽, 3. 북쪽, 4. 남쪽)
			int comm = sc.nextInt();
			
			// 이동 명령에 따른 사방탐색
			int nx = x + dr[comm];
			int ny = y + dc[comm];
			
			// 만약에 이동된 x, y이 범위를 벗어난다면 for문으로 다시 이동
			if (nx < 0 || nx >= N || ny < 0 || ny >= M)
				continue;
			
			// 만약에 범위를 벗어나지 않는다면 x, y값에 이동된 x, y값(nx, ny) 각각 대입
			x = nx;
			y = ny;
			
			
			int[] tmp = dice.clone();   // tmp 배열 만든 이유 : 같은 배열을 이용해서 덮어쓰면 오류 발생 가능.
									    //					 swap(x,y)에서 tmp 변수 만든이유와 같음.
			
			// 동쪽으로 굴려라
			if (comm == 1) {
				dice[0] = tmp[1]; // 윗면에 서쪽면 값 대입  
				dice[1] = tmp[5]; // 서쪽면에 남쪽면 값 대입 
				dice[5] = tmp[3]; // 남쪽면에 동쪽면 값 대입
				dice[3] = tmp[0]; // 동쪽면에 윗면 값 대입
			}
			
			// 서쪽으로 굴려라
			else if (comm == 2) {
				dice[0] = tmp[3]; // 윗면에 동쪽면 값 대입
				dice[3] = tmp[5]; // 동쪽면에 남쪽면 값 대입
				dice[5] = tmp[1]; // 남쪽면에 서쪽면 값 대입
				dice[1] = tmp[0]; // 서쪽면에 윗면 값 대입
			}
			
			// 북쪽으로 굴려라
			else if (comm == 3) {
				dice[0] = tmp[4]; // 윗면에 남쪽면 값 대입
				dice[4] = tmp[5]; // 남쪽면에 아랫면 값 대입
				dice[5] = tmp[2]; // 아랫면에 북쪽면 값 대입
				dice[2] = tmp[0]; // 북쪽면에 윗면 값 대입
			}
			
			// 남쪽으로 굴려라
			else {
				dice[0] = tmp[2]; // 윗면에 북쪽면 값 대입
				dice[2] = tmp[5]; // 북쪽면에 아랫면 값 대입
				dice[5] = tmp[4]; // 아랫면 값에 남쪽면 값 대입
				dice[4] = tmp[0]; // 남쪽면 값에 윗면 값 대입
			}
			
			// 이동한 칸에 쓰여 있는 수가 0이면, 주사위의 바닥면에 쓰여 있는 수가 칸에 복사됨
			if (map[x][y] == 0) {
				map[x][y] = dice[5];
			}
			// 0이 아닌 경우에는 칸에 쓰여 있는 수가 주사위의 바닥면으로 복사되며, 칸에 쓰여 있는 수는 0이 됨
			else {
				dice[5] = map[x][y];
				map[x][y] = 0;
			}
			
			// dice[0]은 항상 주사위 윗면, 윗면 출력
			System.out.println(dice[0]);
		}

	}
}
