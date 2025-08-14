package boj_11650_arrange_coordinate;

import java.util.Arrays;
import java.util.Scanner;


class Point implements Comparable<Point>{
	
	int x, y;

	public Point(int x, int y) {
		
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int compareTo(Point point) {
		
		if(this.x == point.x) {
			return this.y - point.y;
		} else {
			return this.x - point.x;
		}
	}
	
}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		Point[] points = new Point[N];
		
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			points[i] = new Point(x, y);
		}
		
		Arrays.sort(points);
		
		for (int i = 0; i < points.length; i++) {
			System.out.println(points[i].x + " " + points[i].y);
		}
		
		
	}
}
