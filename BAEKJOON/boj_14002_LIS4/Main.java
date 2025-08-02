package boj_14002_LIS4;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arrA = new int[N];
        
        for (int i = 0; i < N; i++) {
            arrA[i] = sc.nextInt();
        }

        // dp[i]: i번째 원소를 마지막으로 하는 LIS의 길이
        int[] dp = new int[N];
        
        // parent[i]: i번째 원소 이전에 오는 LIS 상의 원소 인덱스를 저장
        int[] parent = new int[N];

        int maxLISLength = 0; // LIS의 최대 길이
        int lastIndex = -1;   // LIS의 마지막 원소의 인덱스

        // LIS 길이 계산 및 경로 기록
        for (int i = 0; i < N; i++) {
            dp[i] = 1;      // 모든 원소는 그 자체로 길이 1의 수열
            parent[i] = -1; // 이전 원소가 없음을 의미 (-1로 초기화)

            for (int j = 0; j < i; j++) {
                // arrA[i]가 arrA[j]보다 크고, arrA[j]를 포함하는 LIS에 arrA[i]를 붙였을 때 더 길어진다면
                if (arrA[i] > arrA[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j; // i번째 원소의 부모는 j번째 원소임을 기록
                }
            }

            // 전체 LIS의 최대 길이와 그 마지막 인덱스를 갱신
            if (dp[i] > maxLISLength) {
                maxLISLength = dp[i];
                lastIndex = i;
            }
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        sb.append(maxLISLength).append("\n");

        // LIS 수열 역추적
        Stack<Integer> lisStack = new Stack<>();
        int currentIndex = lastIndex;

        // parent 배열을 따라가며 스택에 원소를 추가 (결과는 역순으로 쌓임)
        while (currentIndex != -1) {
            lisStack.push(arrA[currentIndex]);
            currentIndex = parent[currentIndex];
        }

        // 스택에서 원소를 꺼내면서 출력 (올바른 순서로 출력됨)
        while (!lisStack.isEmpty()) {
            sb.append(lisStack.pop()).append(" ");
        }

        System.out.println(sb.toString().trim());
        
        sc.close(); // Scanner 리소스 정리
    }
}