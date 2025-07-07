import java.util.*;
import java.io.*;

public class Main {
	static class Node {
		int idx;
		int depth;

		Node(int idx, int depth) {
			this.idx = idx;
			this.depth = depth;
		}
	}

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br =
				new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		ArrayDeque<Node> queue = new ArrayDeque<>();

		StringTokenizer st =
				new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= len; i++) {
			queue.offer(new Node(i, Integer.parseInt(st.nextToken())));
		}

		while(true) {
			Node node = queue.pollFirst();
			sb.append(node.idx).append(" ");

			if(queue.isEmpty()) {
				break;
			}

			int seq = node.depth;
			if(node.depth > 0) {
				for(int i = 0; i < seq - 1; i++) {
					queue.offerLast(queue.pollFirst());
				}
			} else {
				for(int i = seq + 1; i <= 0; i++) {
					queue.offerFirst(queue.pollLast());
				}
			}
		}

		System.out.println(sb);
	}
}