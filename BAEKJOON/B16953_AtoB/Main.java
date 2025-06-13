package algo.B16953_AtoB;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static class Point{	
		int num; 
		int cnt;
		
		public Point(int num, int cnt) {
			super();
			this.num = num;
			this.cnt = cnt;
		}		
	}
	
	static int A, B;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		B = sc.nextInt();
		
		Queue<Point> queue = new LinkedList<>();
		
		queue.add(new Point(A, 0));
		
		while(!queue.isEmpty()) {
			Point current = queue.poll();
			
			if(current.num == B) {
				System.out.println(current.cnt+1);
				return;
			}
			
			if(current.num < B) {
				queue.add(new Point(2*current.num, current.cnt+1));
				queue.add(new Point(Integer.parseInt(String.valueOf(current.num)+"1"), current.cnt+1));
			}
		}
		
		System.out.println(-1);
			
	}
}
