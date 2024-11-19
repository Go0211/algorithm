package day1119;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Back18258 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int seq = Integer.parseInt(br.readLine());
		ArrayDeque<String> deque = new ArrayDeque<>();
		for (int i = 0; i < seq; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			switch (st.nextToken()) {
				case "push":
					deque.add(st.nextToken());
					break;
				case "front":
					sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append("\n");
					break;
				case "back":
					sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append("\n");
					break;
				case "size":
					sb.append(deque.size()).append("\n");
					break;
				case "empty":
					sb.append(deque.isEmpty() ? 1 : 0).append("\n");
					break;
				case "pop":
					sb.append(deque.isEmpty() ? -1 : deque.pollFirst()).append("\n");
					break;
			}
		}
		
		System.out.println(sb);
	}
}
