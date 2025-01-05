package problem.year25.day0105;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Back17396 {
    static class Node {
        int nIdx;
        long depth;

        Node(int nIdx, long depth) {
            this.nIdx = nIdx;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("algorithm_problem/input.txt"));
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
                new StringTokenizer(br.readLine(), " ");
        int nodeCount = Integer.parseInt(st.nextToken());
        int seq = Integer.parseInt(st.nextToken());
        long[] cost = new long[nodeCount];
        boolean[] v = new boolean[nodeCount];
        List<List<Node>> g = new ArrayList<>();
        for (int i = 0; i < nodeCount; i++) {
            g.add(new ArrayList<>());
        }

        Arrays.fill(cost,Long.MAX_VALUE);
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < nodeCount; i++) {
            v[i] = st.nextToken().equals("1");
        }
        v[nodeCount - 1] = false;
        for (int i = 0; i < seq; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            g.get(a).add(new Node(b, d));
            g.get(b).add(new Node(a, d));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> compareToLong(x.depth, y.depth));
        cost[0] = 0L;
        pq.add(new Node(0, 0L));


        while (!pq.isEmpty()) {
            Node preNode = pq.poll();
            int idx = preNode.nIdx;
            long depth = preNode.depth;

            System.out.println(idx);

            if (cost[idx] < depth) {
                continue;
            }
            v[idx] = true;

            List<Node> list = g.get(idx);
            for (Node nextNode : list) {
                if (!v[nextNode.nIdx] &&
                        cost[nextNode.nIdx] > cost[idx] + nextNode.depth) {
                    cost[nextNode.nIdx] = cost[idx] + nextNode.depth;
                    pq.add(new Node(nextNode.nIdx, cost[nextNode.nIdx]));
                }
            }
        }

        System.out.println(cost[nodeCount - 1] == Long.MAX_VALUE ? -1 : cost[nodeCount - 1]);
    }

    private static int compareToLong(long depth1, long depth2) {
        return depth1 < depth2 ? -1 : 1;
    }
}