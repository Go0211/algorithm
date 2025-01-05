package problem.year25.day0104;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Back5972 {
    static class Node {
        int nIdx, depth;
        Node(int nIdx, int depth) {
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

        List<List<Node>> g = new ArrayList<>();
        int[] cost = new int[nodeCount + 1];
        boolean[] v = new boolean[nodeCount + 1];
        for (int i = 0; i < nodeCount + 1; i++) {
            g.add(new ArrayList<>());
        }
        Arrays.fill(cost, Integer.MAX_VALUE);

        for (int i = 0; i < seq; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            g.get(a).add(new Node(b, d));
            g.get(b).add(new Node(a, d));
        }

        cost[1] = 0;
        PriorityQueue<Node> pq =
                new PriorityQueue<>((x, y) -> x.depth - y.depth);
        pq.add(new Node(1, cost[1]));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int minVertex = node.nIdx;
            int minValue = node.depth;

            if (minVertex == nodeCount) {
                System.out.println(minValue);
                break;
            }
            v[minVertex] = true;

            for (Node nextNode : g.get(minVertex)) {
                if (!v[nextNode.nIdx] && cost[nextNode.nIdx] > nextNode.depth + minValue) {
                    cost[nextNode.nIdx] = nextNode.depth + minValue;
                    pq.add(new Node(nextNode.nIdx, cost[nextNode.nIdx]));
                }
            }
        }
    }
}