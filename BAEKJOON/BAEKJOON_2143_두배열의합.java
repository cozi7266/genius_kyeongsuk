import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BAEKJOON_2143_두배열의합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // 목표 합

        // 배열 A 입력
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < A.length; i++) {
            A[i] = sc.nextInt();
        }

        // 배열 B 입력
        int m = sc.nextInt();
        int[] B = new int[m];
        for (int i = 0; i < B.length; i++) {
            B[i] = sc.nextInt();
        }

        // 배열 A와 B의 모든 부분합을 각각 구하기
        ArrayList<Integer> subA = getAllSubsetSums(A);
        ArrayList<Integer> subB = getAllSubsetSums(B);

        // 배열 A의 부분합을 해시맵에 저장하여 빈도수 기록
        HashMap<Integer, Integer> mapA = new HashMap<>();
        for (int sum : subA) {
            mapA.put(sum, mapA.getOrDefault(sum, 0) + 1);
        }

        // 배열 B의 부분합을 사용하여 목표 합 T와 맞는 경우의 수 계산
        long count = 0;
        for (int sumB : subB) {
            int target = T - sumB;
            if (mapA.containsKey(target)) {
                count += mapA.get(target);
            }
        }

        // 결과 출력
        System.out.println(count);
    }

    // 모든 부분합을 구하는 메서드
    private static ArrayList<Integer> getAllSubsetSums(int[] arr) {
        ArrayList<Integer> subSums = new ArrayList<>();
        int length = arr.length;

        // 모든 시작점과 끝점을 이용해 부분합을 구한다
        for (int start = 0; start < length; start++) {
            int currentSum = 0;
            for (int end = start; end < length; end++) {
                currentSum += arr[end];
                subSums.add(currentSum);
            }
        }

        return subSums;
    }
}
