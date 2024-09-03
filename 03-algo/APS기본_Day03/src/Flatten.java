import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Flatten {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("data/input_flatten.txt"));
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <= 10; t++) {
			int[] box = new int[100 + 1];
			int N = sc.nextInt();
			int max = -1;
			int min = 101;
			for (int i = 0; i < 100; i++) {
				int h = sc.nextInt();
				if (max < h) max = h;
				min = Math.min(min, h);
				box[h]++;
			}
			
			while (N > 0 && min < max - 1) {
				box[max]--;
				box[max - 1]++;
				box[min]--;
				box[min + 1]++;
				if (box[max] == 0) max--;
				if (box[min] == 0) min++;
				N--;	// 덤프횟수 감소시키기
			}
			
			System.out.println("#" + t + " " + (max - min));
		}
	}
}








