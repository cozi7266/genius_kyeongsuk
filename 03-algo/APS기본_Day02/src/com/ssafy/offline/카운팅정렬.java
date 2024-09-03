package com.ssafy.offline;

import java.util.Arrays;
import java.util.Comparator;

public class 카운팅정렬 {
	static class Comp implements Comparator<int[]> {
		@Override
		public int compare(int[] o1, int[] o2) {
			if (o1[0] == o2[0]) {
				return o1[1] - o2[1];
			}
			return o1[0] - o2[0];
		}
		
	}
	public static void main(String[] args) {
		int[][] arr = {
			{1, 3},
			{2, 5},
			{1, 2},
		};
		Arrays.sort(arr, new Comp());
		System.out.println(Arrays.deepToString(arr));
		
		
		
		/*
		// 1 - 10까지
		int[] data = {1, 9, 2, 2, 6, 4, 10};
		int[] dataSort = countingSort(data);
		System.out.println(Arrays.toString(dataSort));
		*/
	}
	
	static int[] countingSort(int[] data) {
		int[] count = new int[10 + 1];
		for (int i = 0; i < data.length; i++) {
			count[data[i]]++;
		}
//		System.out.println(Arrays.toString(count));
		
		// 누적합
		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}
		
//		System.out.println(Arrays.toString(data));
//		System.out.println(Arrays.toString(count));
		
		int[] dataSort = new int[data.length];
		// data 배열의 뒤부터 가져온다.
		for (int i = data.length - 1; i >=0; i--) {
			dataSort[--count[data[i]]] = data[i];
		}
//		System.out.println(Arrays.toString(dataSort));
		return dataSort;
	}
}




