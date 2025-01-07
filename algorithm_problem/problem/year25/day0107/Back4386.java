package problem.year25.day0107;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Back4386 {
    static class Node {
        int nextIdx;
        double depth;

        Node(int nextIdx, double depth) {
            this.nextIdx = nextIdx;
            this.depth = depth;
        }

        public String toString() {
            return "idx -> " + nextIdx + " | depth -> " + depth;
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("algorithm_problem/input.txt"));
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int seq = Integer.parseInt(br.readLine());
        List<double[]> stars = new ArrayList<>();
        List<List<Node>> nodes = new ArrayList<>();
        double[] cost = new double[seq];
        boolean[] v = new boolean[seq];

        for (int i = 0; i < seq; i++) {
            nodes.add(new ArrayList<>());
        }
        for (int i = 0; i < seq; i++) {
            StringTokenizer st =
                    new StringTokenizer(br.readLine(), " ");
            double y = Double.parseDouble(st.nextToken());
            double x = Double.parseDouble(st.nextToken());
            stars.add(new double[]{y, x});
        }

        for (int i = 0; i < seq; i++) {
            for (int j = 0; j < seq; j++) {
                double[] pres = stars.get(i);
                double[] nexts = stars.get(j);

                double preY = pres[0];
                double preX = pres[1];
                double nextY = nexts[0];
                double nextX = nexts[1];
                double cc = Math.sqrt((preY - nextY) * (preY - nextY)
                        + (preX - nextX) * (preX - nextX));

                if (i != j) {
                    nodes.get(i).add(new Node(j, cc));
                }
            }
        }

        Arrays.fill(cost, Double.MAX_VALUE);
        cost[0] = 0;
        PriorityQueue<Node> pq =
                new PriorityQueue<>((x, y) -> Double.compare(x.depth, y.depth));
        pq.add(new Node(0, 0));

        int count = 0;
        double total = 0;
        while (!pq.isEmpty()) {
            Node preNode = pq.poll();

            List<Node> l = nodes.get(preNode.nextIdx);
            if (v[preNode.nextIdx]) {
                continue;
            }

            v[preNode.nextIdx] = true;
            total += preNode.depth;
            for (Node nextNode : l) {
                if (!v[nextNode.nextIdx] &&
                        cost[nextNode.nextIdx] > nextNode.depth) {
                    cost[nextNode.nextIdx] = nextNode.depth;
                    pq.add(new Node(nextNode.nextIdx, nextNode.depth));
                }
            }

            if (count++ == seq - 1) {
                break;
            }
        }


        System.out.println(Math.round(total * 100.0) / 100.0);
    }
}
