import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_2473_세용액 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        // 배열 입력 받기
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        // 배열 정렬
        Arrays.sort(arr);

        // 세 용액의 합이 0에 가장 가까운 값을 찾기 위한 초기화
        long closestSum = Long.MAX_VALUE;
        int x = 0, y = 0, z = 0;  // 결과로 출력할 세 개의 용액 인덱스
        
        // 첫 번째 용액 고정, 나머지 두 용액은 투 포인터로 처리
        for (int i = 0; i < N - 2; i++) {
            int left = i + 1;  // 두 번째 용액의 시작
            int right = N - 1; // 세 번째 용액의 시작

            while (left < right) {
                long sum = (long) arr[i] + arr[left] + arr[right];

                // 0에 가까운 합을 찾았을 때
                if (Math.abs(sum) < Math.abs(closestSum)) {
                    closestSum = sum;
                    x = i;
                    y = left;
                    z = right;
                }

                // 합이 0보다 작으면 왼쪽 포인터를 오른쪽으로 이동
                if (sum < 0) {
                    left++;
                }
                // 합이 0보다 크면 오른쪽 포인터를 왼쪽으로 이동
                else {
                    right--;
                }
            }
        }

        // 결과 출력 (세 용액의 값을 출력)
        System.out.println(arr[x] + " " + arr[y] + " " + arr[z]);
    }
}
