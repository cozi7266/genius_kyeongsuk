import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class Contact {
    static int N, start;
    static int[][] adj;
    static boolean[] check;
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       for (int t = 1; t <= 10; t++) {
         
           N = sc.nextInt();
           start = sc.nextInt();
            
           adj = new int[101][101];
           check = new boolean[101];
            
           for (int i = 0; i < N/2; i++) {
               adj[sc.nextInt()][sc.nextInt()] = 1; 
           }
            
           int result = bfs(start);
            
           System.out.println("#"+t+" "+result);   
       }
    }
    
private static int bfs(int start) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);
    check[start] = true;
     
    int max = 0;
   
     
    while(!queue.isEmpty()) {
        int size = queue.size();
        max = 0;
         
        for (int i = 0; i < size; i++) {
            int curr = queue.poll();
            max = Math.max(max,curr);
            for (int to = 0; to < 101; to++) {
                if(adj[curr][to] == 1 && !check[to]) {
                    check[to] = true;
                    queue.add(to);
            }           
          }
        }
      }
      return max;
   } 
}