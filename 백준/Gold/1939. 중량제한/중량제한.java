import java.util.*;
import java.io.*;

public class Main {
    static class Node implements Comparable<Node> {
        int idx, depth;

        Node(int idx, int depth) {
            this.idx = idx;
            this.depth = depth;
        }

        public int compareTo(Node n) {
            return n.depth > this.depth ? 1 : -1;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
                new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int answer = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        List<List<Node>> list = new ArrayList<>();
        boolean[] v = new boolean[N];
        int[] cost = new int[N];
        for(int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }
        Arrays.fill(cost, -1);

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b,c));
            list.get(b).add(new Node(a,c));
        }

        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken()) - 1;
        int end = Integer.parseInt(st.nextToken()) - 1;

        pq.offer(new Node(start, Integer.MAX_VALUE));

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int idx = node.idx;
            int depth = node.depth;
            v[idx] = true;

            if(idx == end) {
                System.out.println(cost[idx]);
                break;
            }

            List<Node> nl = list.get(idx);
            for(Node n : nl) {
                if(v[n.idx]) {
                    continue;
                }

                int nextDepth = Math.min(depth, n.depth);
                if(nextDepth > cost[n.idx]) {
                    cost[n.idx] = nextDepth;
                    pq.offer(new Node(n.idx, Math.min(n.depth, depth)));
                }
            }
        }
    }
}