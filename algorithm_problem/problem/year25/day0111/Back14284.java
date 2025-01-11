package problem.year25.day0111;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Back14284 {
    static class Node {
        int nextIdx, depth;
        Node(int nextIdx, int depth) {
            this.nextIdx = nextIdx;
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
        List<List<Node>> list = new ArrayList<>();
        int[] cost = new int[nodeCount + 1];
        boolean[] v = new boolean[nodeCount + 1];

        Arrays.fill(cost, Integer.MAX_VALUE);
        for (int i = 0; i < nodeCount + 1; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < seq; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            list.get(a).add(new Node(b, d));
            list.get(b).add(new Node(a, d));
        }

        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        cost[start] = 0;

        for (int i = 0; i < seq; i++) {
            int minVertex = -1;
            int minValue = Integer.MAX_VALUE;

            for (int j = 1; j < nodeCount + 1; j++) {
                if (!v[j] && minValue > cost[j]) {
                    minVertex = j;
                    minValue = cost[j];
                }
            }

            if (minVertex == end) {
                break;
            }

            v[minVertex] = true;
            cost[minVertex] = minValue;

            for (Node node : list.get(minVertex)) {
                if (!v[node.nextIdx] && cost[node.nextIdx] > minValue + node.depth) {
                    cost[node.nextIdx] = minValue + node.depth;
                }
            }
        }

        System.out.println(cost[end]);
    }
}