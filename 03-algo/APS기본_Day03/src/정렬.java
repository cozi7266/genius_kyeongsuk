import java.util.Arrays;

public class 정렬 {
	public static void main(String[] args) {
		int [] arr = {4, 3, 1, 2, 5};
		버블정렬(arr);
		선택정렬(arr);
	}
	
	static void 선택정렬(int[] arr) {
		
	}
	
	static void 버블정렬(int[] arr) {
		/*
		 * 정렬 코드 작성~
		 */
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				} 
			}
		}
		System.out.println("버블정렬 결과 : ");
		System.out.println(Arrays.toString(arr));
	}
}
