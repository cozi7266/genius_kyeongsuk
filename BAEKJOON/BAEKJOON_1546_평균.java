package algo;

import java.util.Scanner;

public class BAEKJOON_1546_평균 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		double[] scores = new double[N];
		double max = 0;
		
		for (int i = 0; i < scores.length; i++) {
			scores[i] = sc.nextDouble();
			max = Math.max(max, scores[i]);
		}
		
		double sum = 0;
		
		for (int i = 0; i < scores.length; i++) {
			scores[i] = scores[i]/max*100;
			sum += scores[i];
		}
		
		double avg = sum/scores.length;
		
		System.out.println(avg);
				
	}

}
