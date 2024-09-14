import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_2252_줄세우기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner("4 2\r\n"
        		+ "4 2\r\n"
        		+ "3 1\r\n"
        		+ "");
        int N = sc.nextInt();
        int M = sc.nextInt();

        // 그래프와 진입 차수 배열 초기화
        List<List<Integer>> graph = new ArrayList<>(N + 1);
        int[] indegree = new int[N + 1];

        // 그래프의 각 인덱스에 대한 리스트 생성
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 정보 입력 및 그래프 구성
        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            graph.get(start).add(end);
            indegree[end]++;
        }

        // 위상 정렬을 위한 큐와 결과를 저장할 리스트 초기화
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        // 진입 차수가 0인 노드를 큐에 추가
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // 위상 정렬 수행
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            result.add(curr);

            for (int next : graph.get(curr)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        // 결과 출력
        for (int student : result) {
            System.out.print(student + " ");
        }
    }
}
