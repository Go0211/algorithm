import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        char alpha;
        int num;

        Node(char alpha, int num) {
            this.alpha = alpha;
            this.num = num;
        }

        public int compareTo(Node node) {
            return alpha == node.alpha
                    ? num > node.num ? 1 : -1
                    : alpha > node.alpha ? 1 : -1;
        }

        boolean isSame(Node node) {
            return node.num == this.num && node.alpha == this.alpha;
        }

        public String toString() {
            return this.alpha + "-" + this.num;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());

        Node[][] arr = new Node[N][5];

        for(int i = 0; i < N; i++) {
            StringTokenizer st =
                    new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < 5; j++) {
                String str = st.nextToken();
                String[] a = str.split("-");
                Node node = new Node(a[0].charAt(0), Integer.parseInt(a[1]));

                arr[i][j] = node;
                pq.add(node);
            }
        }

        int row = 0;
        int col = 0;
        ArrayDeque<Node> stack = new ArrayDeque<>();

        while(row != N) {
            // Queue의 peek값이 안비어있고, 가장 빠른 값일 때,
            if (!stack.isEmpty() && pq.peek().isSame(stack.peek())) {
                pq.poll();
                stack.pollFirst();
                continue;
            }

            // 현재 배열위치값이 가장 빠른 값일 때
            if(pq.peek().isSame(arr[row][col])) {
                pq.poll();
            }
            // 다 만족하지 않을 때
            else {
                stack.offerFirst(arr[row][col]);
            }

            col++;
            if(col == 5) {
                row++;
                col = 0;
            }
        }

        while(!pq.isEmpty()) {
            if (!pq.peek().equals(stack.peek())) {
                break;
            }
            pq.poll();
            stack.pollFirst();
        }

        System.out.println(stack.isEmpty() && pq.isEmpty() ? "GOOD" : "BAD");
    }
}