import java.util.Scanner;

public class Queue_큐의구현 {

	// 배열 사이즈가 10이면 10번 삽입할 수 있다.
	static String[] queue = new String[10];
	static int front = -1;
	static int rear = -1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 11; i++) {
			enQueue("good");
		}
		
		System.out.println(size());
		
		while (!isEmpty()) {
			String rItem = deQueue();
			System.out.println(rItem);
		}
		
		deQueue();

	}

	// 공백상태 확인
	static boolean isEmpty() {
//		if (front == rear) {
//			return true;
//		}
//		return false;
		return front == rear;
	}

	// 포화상태 확인
	static boolean isFull() {
		// rear가 배열의 마지막 인덱스를 가리키면 포화상태
		return rear == queue.length - 1;
	}

	// 삽입
	// 삽입 성공 여부를 반환하려면 boolean타입도 반환가능
	static void enQueue(String item) {
		if (isFull()) {
			System.out.println("큐가 가득 찼습니다.");
			return;
		}
//		queue[rear + 1] = item;
//		rear++;
		queue[++rear] = item;
	}

	// 삭제
	static String deQueue() {
		if (isEmpty()) {
			System.out.println("큐가 비어있습니다.");
			return null;
		}
		return queue[++front];
	}

	// 삭제할 원소 조회
	static String Qpeek() {
		if (isEmpty()) {
			System.out.println("큐가 비어있습니다.");
			return null;
		}
		return queue[front + 1];
	}

	// 큐에 들어있는 데이터 개수
	static int size() {
		return rear - front;
	}

}
