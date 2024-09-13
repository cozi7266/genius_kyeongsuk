import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_1922_네트워크연결 {
	static class Edge implements Comparable<Edge>{
		int point1, point2, weight;

		public Edge(int point1, int point2, int weight) {
			this.point1 = point1;
			this.point2 = point2;
			this.weight = weight;
		}
        
		// Comparable 인터페이스의 compareTo 메서드를 구현함(이유 : Edge 클래스를 구현한 객체에서 가중치 크기로 오름차순
		// 나열하기 위해서)
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);  // compareTo 메서드에서 직접 뺄셈을 사용하지 않고 Integer.compare()를 사용하는 이유
			                                                // 1. 오버플로우(Overflow)방지 : 차이가 큰 뺄세에서 오버플로우 문제 처리
			                                                // 2. 가독성 : a-b 일런식으로 빼면 혼란 있을 수 있어서, 이것을 방지해준다.
			                                                // 3. 일관성 : 일관된 메서드를 사용한다(이유 : Double.compare, Long.compare 등)
		}	
	}
	static int N, M;
	static int[] parents;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		parents = new int[N+1];
		Edge[] edgeList = new Edge[M];
		
		for (int i = 0; i < M; i++) {
			int point1 = sc.nextInt();
			int point2 = sc.nextInt();
			int weight = sc.nextInt();
			edgeList[i] = new Edge(point1, point2, weight);
		}
		
		// compareTo
		Arrays.sort(edgeList);       
		
		makeSet();
		
		int cnt = 0;  // 선택된 간선의 개수를 셀 변수
		int sum = 0;  // 최소 신장 트리의 총 가중치를 저장할 변수
		
		for (int i = 0; i < M; i++) {
			if(!union(edgeList[i].point1,edgeList[i].point2)) continue;
			sum += edgeList[i].weight;  // 연결되어 있지만 않다면, 가중치를 더함
			
			if(++cnt == N - 1) break; // N-1개의 간선을 선택하면 MST가 완성되므로 반복문 종료			
		}
		
		System.out.println(sum);
		
		sc.close();		
	} 
	
	// 두 정점을 결합하는 메서드 : 이미 결합되어 있으면 false 반환, 아니면 true 반환
	private static boolean union(int x, int y) {
		int xRoot = findSet(x);
		int yRoot = findSet(y);
		
		if(xRoot == yRoot) return false;  // 이미 같은 집합에 속해 있는 경우
		parents[yRoot] = xRoot;  // y의 부모를 x로 설정하여 집합을 결합
		return true;
	}
	
	// 한 정점이 속해 있는 집합의 대표(root)를 찾는 메서드 (경로 압축 기법 사용)
	private static int findSet(int x) {
		if(parents[x] == x) return parents[x];	// 자신이 루트일 경우 자기 자신 반환
		return parents[x] = findSet(parents[x]); // 경로 압축을 통해 루트를 찾음
	}
	
	// 각 정점의 부모를 자기 자신으로 초기화하여, 모든 정점을 독립된 집합으로 만드는 메서드
	private static void makeSet() {
		for (int i = 1; i <= N; i++) {
			parents[i] = i; // 각 정점의 부모를 자기 자신으로 설정
		}		
	}
}

