import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BAEKJOON_2109_순회강연 {
    public static class Scholar implements Comparable<Scholar> {
        int p; 
        int d; 

        public Scholar(int p, int d) {
            this.p = p;
            this.d = d;
        }

        @Override
        public int compareTo(Scholar other) {
            if (this.d > other.d)
                return 1;
            else if (this.d == other.d)
                if (this.p < other.p)
                    return 1;
            return -1;
        }
    }

    static ArrayList<Scholar> scholars;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        scholars = new ArrayList<>();

        int sum = 0;

        for (int i = 0; i < n; i++) {
            scholars.add(new Scholar(sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(scholars);

        for (int i = n; i > 0; i--) {
            sum += getMaxScholarship(i);
        }
        System.out.println(sum);
    }

    private static int getMaxScholarship(int day) {
        Scholar tempScholar = new Scholar(0, 1);
        for (Scholar a : scholars) {
            if (a.d >= day) {
                if (tempScholar.p < a.p)
                    tempScholar = a;
            }
        }
        int maxP = tempScholar.p;
        scholars.remove(tempScholar);
        return maxP;
    }
}
