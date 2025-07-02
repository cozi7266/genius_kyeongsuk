package B4150_FibonacciSequence;

import java.math.BigInteger; // BigInteger 클래스 임포트
import java.util.Scanner;

public class Main {
 
    // static BigInteger[] memo; // long 대신 BigInteger 배열 사용

    // BigInteger는 배열 초기화 시 null이 되므로, 명시적으로 초기화해야 합니다.
    // 여기서는 Main 클래스 내부에 선언하여 사용합니다.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        // n+1 크기의 BigInteger 배열 선언
        BigInteger[] memo = new BigInteger[n + 1]; 
        
        // recursive_function이 BigInteger를 반환하도록 수정
        BigInteger result = recursive_function(n, memo); 
        
        System.out.println(result);
        sc.close(); 
    }

    // recursive_function의 반환 타입과 매개변수 타입 수정
    private static BigInteger recursive_function(int n, BigInteger[] memo) {
    
        // 이미 계산된 값이 있다면 바로 반환
        // BigInteger의 null 체크 (아직 계산되지 않았음을 의미)
        if (n >= 1 && memo[n] != null) { 
            return memo[n];
        }

        // 기본 케이스 (f(1) = 1, f(2) = 1)
        if (n == 1 || n == 2) { // n < 3은 n=0일 경우도 포함하지만, 문제에서 f(1)부터 시작하므로 1과 2만 처리
            memo[n] = BigInteger.ONE; // BigInteger.ONE은 BigInteger 객체로 1을 나타냅니다.
            return BigInteger.ONE;
        }
        
        // f(n > 2) = f(n − 1) + f(n − 2)
        // BigInteger의 덧셈은 .add() 메서드를 사용합니다.
        memo[n] = recursive_function(n - 1, memo).add(recursive_function(n - 2, memo));
        return memo[n];
    }
}