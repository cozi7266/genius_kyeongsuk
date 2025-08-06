package boj_1431_serial_number;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		sc.nextLine(); 
		
		String[] guitars = new String[N];
		
		for (int i = 0; i < N; i++) {
			guitars[i] = sc.nextLine();
		}
		
		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < N - 1; j++) {
				
				String s1 = guitars[j];
				String s2 = guitars[j + 1];
				
				boolean needSwap = false;
				
				
				if (s1.length() > s2.length()) {
	                    needSwap = true;
	            }
				
				
                else if (s1.length() == s2.length()) {
                    int sum1 = getSumOfDigits(s1);
                    int sum2 = getSumOfDigits(s2);
                    
                    if (sum1 > sum2) {
                        needSwap = true;
                    } 
                   
                    else if (sum1 == sum2) {
                        if (s1.compareTo(s2) > 0) {
                            needSwap = true;
                        }
                    }
                }
				
				 if (needSwap) {
	                    String temp = guitars[j];
	                    guitars[j] = guitars[j + 1];
	                    guitars[j + 1] = temp;
	              }
			}
		}
		
		  for (String guitar : guitars) {
	            System.out.println(guitar);
	        }
	        
	        sc.close();
	}

	private static int getSumOfDigits(String s) {
		int sum = 0;
		for(char c : s.toCharArray()) {
			if(Character.isDigit(c)) {
				sum += c - '0';
			}
		}
		return sum;
	}
}
