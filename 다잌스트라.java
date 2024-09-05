import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 다잌스트라 {
    static class Node {
        int v, w;  // v: 정점, w: 가중치

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner("6 11\r\n"
                + "0 1 4\r\n"
                + "0 2 2\r\n"
                + "0 5 25\r\n"
                + "1 3 8\r\n"
                + "1 4 7\r\n"
                + "2 1 1\r\n"
                + "2 4 4\r\n"
                + "3 0 3\r\n"
                + "3 5 6\r\n"
                + "4 3 5\r\n"
                + "4 5 12\r\n");

        int V = sc.nextInt(); // 정점의 개수
        int E = sc.nextInt(); // 간선의 개수

        List<Node>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();    
        }

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();  // 출발 정점
            int v = sc.nextInt();  // 도착 정점
            int w = sc.nextInt();  // 가중치
            adj[u].add(new Node(v, w));
        }

        // 시작 정점을 0으로 설정하고 다익스트라 알고리즘 실행
        int start = 0;
        int[] D = new int[V];          // 최단 경로를 저장할 배열
        boolean[] visited = new boolean[V];  // 방문 여부를 저장할 배열
        Arrays.fill(D, Integer.MAX_VALUE);
        
        D[start] = 0;  // 시작점에서 시작점으로의 거리는 0

        // 다익스트라 알고리즘 수행
        for (int i = 0; i < V; i++) {
            // 방문하지 않은 정점 중에서 가장 가까운 정점 선택
            int minVertex = -1;
            int minCost = Integer.MAX_VALUE;
            
            for (int j = 0; j < V; j++) {
                if (!visited[j] && D[j] < minCost) {
                    minCost = D[j];
                    minVertex = j;
                }
            }

            if (minVertex == -1) break;  // 더 이상 방문할 정점이 없을 경우 종료

            visited[minVertex] = true;  // 선택한 정점을 방문 처리

            // 선택한 정점과 연결된 다른 정점들의 최단 거리 갱신
            for (Node node : adj[minVertex]) {
                if (!visited[node.v] && D[node.v] > D[minVertex] + node.w) {
                    D[node.v] = D[minVertex] + node.w;
                }
            }
        }

        // 결과 출력 (0번 정점에서 각 정점까지의 최단 거리)
        System.out.println("0번 정점에서 각 정점까지의 최단 거리:");
        for (int i = 0; i < V; i++) {
            System.out.println("정점 " + i + " : " + D[i]);
        }
    }
}
