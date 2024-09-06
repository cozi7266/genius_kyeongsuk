
import java.util.Scanner;

public class 보호필름연습2 {
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

            minCnt = D;  // 가능한 최대 투입 횟수로 초기화

            makefilm(0, 0);

            System.out.println("#" + tc + " " + minCnt);
        }
    }

    private static void makefilm(int idx, int cnt) {
        // 최소 투입 횟수를 넘어가면 더 이상 탐색할 필요 없음
        if (cnt >= minCnt) {
            return;
        }

        // 모든 행을 처리한 후에 조건을 만족하는지 검사
        if (idx == D) {
            if (isOk()) {
                minCnt = Math.min(cnt, minCnt);  // 최소 투입 횟수 갱신
            }
            return;
        }

        // 약품을 투입하지 않고 다음 단계로 이동
        makefilm(idx + 1, cnt);

        // 현재 행을 임시로 저장
        int[] tmp = film[idx].clone();

        // A 약품 투입 후 다음 단계로
        injection(idx, 0);
        makefilm(idx + 1, cnt + 1);

        // B 약품 투입 후 다음 단계로
        injection(idx, 1);
        makefilm(idx + 1, cnt + 1);

        // 원상복구
        film[idx] = tmp;
    }

    // 특정 행에 약품을 투입하는 메소드
    private static void injection(int idx, int chemical) {
        for (int i = 0; i < W; i++) {
            film[idx][i] = chemical;
        }
    }

    // 모든 열이 K개 이상 연속된 동일한 값을 만족하는지 체크하는 메소드
    private static boolean isOk() {
        for (int c = 0; c < W; c++) {
            int cnt = 1;  // 연속된 셀의 카운트

            for (int r = 1; r < D; r++) {
                if (film[r - 1][c] == film[r][c]) {
                    cnt++;
                } else {
                    cnt = 1;  // 연속이 끊기면 다시 1부터 시작
                }

                if (cnt >= K) {
                    break;  // 이 열은 조건을 만족하므로 다음 열로 이동
                }
            }

            if (cnt < K) {
                return false;  // 한 열이라도 조건을 만족하지 않으면 실패
            }
        }
        return true;  // 모든 열이 조건을 만족하면 성공
    }
}
