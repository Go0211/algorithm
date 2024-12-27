package problem.day1029;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Back2164 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int seq = Integer.parseInt(br.readLine());
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		
		for (int i = 1; i <= seq; i++) {
			deque.addLast(i);
		}
		
		while (true) {
			if (deque.size() == 1) {
				System.out.println(deque.peek());
				break;
			}
			
			deque.pollFirst();
			deque.addLast(deque.pollFirst());
		}
	}
}
