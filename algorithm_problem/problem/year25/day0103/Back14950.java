package problem.year25.day0103;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Back14950 {
    static class Node {
        int idx, value;
        Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("algorithm_problem/input.txt"));
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
                new StringTokenizer(br.readLine(), " ");

        int idxCnt = Integer.parseInt(st.nextToken());
        int seq = Integer.parseInt(st.nextToken());
        int mulValue = Integer.parseInt(st.nextToken());

        List<List<Node>> g = new ArrayList<>();
        for (int i = 0; i < idxCnt; i++) {
            g.add(new ArrayList<>());
        }
        int[] cost = new int[idxCnt];
        boolean[] v = new boolean[idxCnt];

        Arrays.fill(cost, Integer.MAX_VALUE);
        for (int i = 0; i < seq; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            g.get(y - 1).add(new Node(x - 1, value));
            g.get(x - 1).add(new Node(y - 1, value));
        }

        int mst = 0; int cnt = 0;
        for (int i = 0; i < idxCnt - 1; i++) {
            mst += i * mulValue;
        }
        cost[0] = 0;

        for (int i = 0; i < seq; i++) {
            int minVertex = -1;
            int minValue = Integer.MAX_VALUE;

            for (int j = 0; j < idxCnt; j++) {
                if (!v[j] && minValue > cost[j]) {
                    minVertex = j;
                    minValue = cost[j];
                }
            }

            v[minVertex] = true;
            mst += cost[minVertex];
            if (cnt++ == idxCnt - 1) {
                break;
            }

            for (int index = 0; index < g.get(minVertex).size(); index++) {
                if (!v[g.get(minVertex).get(index).idx] && cost[g.get(minVertex).get(index).idx] > g.get(minVertex).get(index).value) {
                    cost[g.get(minVertex).get(index).idx] = g.get(minVertex).get(index).value;
                }
            }
        }

        System.out.println(mst);
    }
}