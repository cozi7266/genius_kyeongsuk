import java.util.Scanner;

public class boj_1934_GCD {
	
	public static long gcd(long a, long b) {
	        while (b != 0) {
	            long temp = a % b;
	            a = b;
	            b = temp;
	        }
	        return a;
	    }
	
	 public static long lcm(long a, long b) {
	        // (A * B) / GCD(A, B)
	        return (a * b) / gcd(a, b);
	    }
	
	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);
	     

	      
	            long A = sc.nextLong();
	            long B = sc.nextLong();
	            System.out.println(gcd(A, B));
	            System.out.println(lcm(A, B));
	        

	        sc.close();
	}
}
