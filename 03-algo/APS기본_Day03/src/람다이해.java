import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 람다이해 {
	static class Student implements Comparable<Student> {
		String name;
		int age;
		public Student() {}
		public Student(String name, int age) {
			this.name = name;
			this.age = age;
		}
		@Override
		public String toString() {
			return "Student [name=" + name + ", age=" + age + "]";
		}
		@Override
		public int compareTo(Student o) {
			return this.name.compareTo(o.name);
		}
	}
	/*
	static void sort(List<Student> students) {
		Student me = students.get(0);
		Student other = students.get(0 + 1);
		int n = me.compareTo(other);
		if (n < 0) {
			
		} else if (n > 0) {
			
		} 
	}
	*/
	
	static class StudentComp implements Comparator<Student> {
		@Override
		public int compare(Student o1, Student o2) {
			return o1.age - o2.age;
		}
	}
	static class IntArrayComp implements Comparator<int[]> {
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
				{1, 5},
				{3, 2},
				{1, 2},
				{2, 3},
		};
		Arrays.sort(arr, new IntArrayComp());
		/*
			익명클래스
			new 클래스명|Comparator<int[]>() {
				내용정의
			}
		 */
		// static class IntArrayComp implements Comparator<int[]> { }
		/*
		static class IntArrayComp implements Comparator<int[]> {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			}
		}
		Comparator<int[]> comp = new IntArrayComp();
		*/
		Arrays.sort(arr, new IntArrayComp());
		
		
		Comparator<int[]> comp = new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			}
		};
		Arrays.sort(arr, comp);
		
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			}
		});
		Arrays.sort(arr, (o1, o2) -> {
			if (o1[0] == o2[0]) {
				return o1[1] - o2[1];
			}
			return o1[0] - o2[0];
		});
		
		System.out.println(Arrays.deepToString(arr));
		
		/*
		// 정렬 : Comparable, Comparator - compare(비교1, 비교2)
		List<Student> students = new ArrayList<>();
		students.add(new Student("홍길동", 22));
		students.add(new Student("장보고", 32));
		students.add(new Student("임꺽정", 27));
//		Collections.sort(students);
		Collections.sort(students, new StudentComp());
		
		System.out.println(students);
		*/
	}
}









