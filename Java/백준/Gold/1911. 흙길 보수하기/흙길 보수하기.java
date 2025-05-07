import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int start, end;

        Node(int start, int end) {
            this.start = start;
            this.end = end - 1;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
                new StringTokenizer(br.readLine());
        int seq = Integer.parseInt(st.nextToken());
        int len = Integer.parseInt(st.nextToken());
        int nextIdx = 0;
        int count = 0;
        PriorityQueue<Node> pq =
                new PriorityQueue<>((x, y) -> x.start - y.start);

        for (int i = 0; i < seq; i++) {
            st = new StringTokenizer(br.readLine());
            pq.offer(new Node(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (nextIdx < node.start) {
                nextIdx = node.start;
            }

            while (nextIdx <= node.end) {
                nextIdx += len;
                count++;
            }
        }

        System.out.println(count);
    }
}