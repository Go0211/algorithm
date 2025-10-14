import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int idx, count;

        Node(int idx) {
            this.idx = idx;
            this.count = 0;
        }

        Node(int next, int count) {
            this.idx = next;
            this.count = count;
        }
    }

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
                new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Node n = new Node(-1);

        ArrayDeque<Node> queue = new ArrayDeque<>();
        int[] prev = new int[100_001];
        boolean[] v = new boolean[100_001];
        queue.offer(new Node(N));
        v[N] = true;

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            if(node.idx == K) {
                System.out.println(node.count);

                ArrayDeque<Integer> stack = new ArrayDeque<>();
                
                stack.push(K);
                while(K != N) {
                    stack.push(prev[K]);
                    K = prev[K];
                }

                while(!stack.isEmpty()) {
                    sb.append(stack.pop()).append(" ");
                }
                System.out.println(sb);

                break;
            }

            if(0 <= node.idx - 1 && !v[node.idx - 1]) {
                queue.offer(new Node(node.idx - 1, node.count + 1));
                prev[node.idx - 1] = node.idx;
                v[node.idx - 1] = true;
            }
            if(node.idx + 1 < 100_001 && !v[node.idx + 1]) {
                queue.offer(new Node(node.idx + 1, node.count + 1));
                prev[node.idx + 1] = node.idx;
                v[node.idx + 1] = true;
            }
            if(node.idx * 2 < 100_001 && !v[node.idx * 2]) {
                queue.offer(new Node(node.idx * 2, node.count + 1));
                prev[node.idx * 2] = node.idx;
                v[node.idx * 2] = true;
            }
        }
    }
}