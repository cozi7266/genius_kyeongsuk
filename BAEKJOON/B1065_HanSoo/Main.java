package algo.B1065_HanSoo;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int counts = 0;
		
		for (int i = 1; i <= N; i++) {
			char[] nums = String.valueOf(i).toCharArray();
			if(nums.length <= 2) {
				counts++;
				continue;
			}
			
			boolean isHansoo = true;
			
			for (int j = 0; j < nums.length - 1; j++) {
				if((nums[j+1] - '0') - (nums[j] - '0') != (nums[1] - '0') - (nums[0] - '0')) {
					isHansoo = false;
					break;
				}
			}
			
			if(isHansoo == true) {
				counts++;
			}
			
		}
		
		System.out.println(counts);
	}
}
