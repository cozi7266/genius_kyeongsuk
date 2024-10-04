import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BAEKJOON_3055_탈출 {
    static class Node {
        int r, c, cnt;

        public Node() {
            super();
        }

        public Node(int r, int c, int cnt) {
            super();
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int R, C;
    static char[][] map;
    static boolean[][] visited_W;
    static boolean[][] visited_S;
    static Queue<Node> queue_W = new LinkedList<>();
    static Queue<Node> queue_S = new LinkedList<>();
    static Node loc_S;

    public static void main(String[] args) {
        Scanner sc = new Scanner(string);
        R = sc.nextInt();
        C = sc.nextInt();

        map = new char[R][C];
        visited_W = new boolean[R][C];
        visited_S = new boolean[R][C];

        for (int r = 0; r < R; r++) {
            String bin = sc.next();
            for (int c = 0; c < C; c++) {
                map[r][c] = bin.charAt(c);

                
                if (map[r][c] == '*') {
                    queue_W.add(new Node(r, c, 0));
                    visited_W[r][c] = true;
                }

                
                if (map[r][c] == 'S') {
                    loc_S = new Node(r, c, 0);
                    visited_S[r][c] = true;
                }
            }
        }

        
        queue_S.add(loc_S);

        // BFS 수행
        int result = bfs();
        if (result == -1) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(result);
        }
    }

    private static int bfs() {
        while (!queue_S.isEmpty()) {
            // 먼저 물을 이동시킨다.
            int waterSize = queue_W.size();
            for (int i = 0; i < waterSize; i++) {
                Node water = queue_W.poll();

                for (int k = 0; k < 4; k++) {
                    int nr = water.r + dr[k];
                    int nc = water.c + dc[k];

                    if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visited_W[nr][nc] && map[nr][nc] == '.') {
                        visited_W[nr][nc] = true;
                        map[nr][nc] = '*';
                        queue_W.add(new Node(nr, nc, water.cnt + 1));
                    }
                }
            }

            // 고슴도치를 이동시킨다.
            int hedgehogSize = queue_S.size();
            for (int i = 0; i < hedgehogSize; i++) {
                Node hedgehog = queue_S.poll();

                for (int k = 0; k < 4; k++) {
                    int nr = hedgehog.r + dr[k];
                    int nc = hedgehog.c + dc[k];

                    // 탈출구 'D'에 도착하면 종료
                    if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                        if (map[nr][nc] == 'D') {
                            return hedgehog.cnt + 1;
                        }

                        if (!visited_S[nr][nc] && map[nr][nc] == '.') {
                            visited_S[nr][nc] = true;
                            queue_S.add(new Node(nr, nc, hedgehog.cnt + 1));
                        }
                    }
                }
            }
        }
        return -1;
    }

    static String string = "5 4\r\n"
            + ".D.*\r\n"
            + "....\r\n"
            + "..X.\r\n"
            + "S.*.\r\n"
            + "....\r\n";
}
