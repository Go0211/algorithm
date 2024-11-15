package day1115;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Back18243 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int nodeCount = Integer.parseInt(st.nextToken());
        int seq = Integer.parseInt(st.nextToken());
        boolean check = true;

        List<Integer>[] la = new List[nodeCount];
        for (int i = 0; i < nodeCount; i++) {
            la[i] = new ArrayList<>();
        }

        for (int i = 0; i < seq; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            la[a].add(b);
            la[b].add(a);
        }

        for (int start = 0; start < nodeCount; start++) {
            boolean cc = bfs(start, nodeCount, la);
//            System.out.println(cc);
            check = cc && check;
        }

        if(check) {
            System.out.println("Small World!");
        } else {
            System.out.println("Big World!");
        }
    }

    static boolean bfs(int start, int nodeCount, List<Integer>[] la) {
        int answer = 0;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{start, 0});
        Set<Integer> sets = new HashSet<>();
        for (int i = 0; i < nodeCount; i++) {
            if (i != start) {
                sets.add(i);
            }
        }

        while (!q.isEmpty()) {
            int[] arr = q.poll();
            int num = arr[0];
            int count = arr[1];

            answer = Math.max(count, answer);

            for (int i : la[num]) {
                if (sets.contains(i)) {
                    sets.remove(i);
                    q.add(new int[] {i, count + 1});
                }
            }
        }

//        System.out.println(start + 1);
//        System.out.println(answer);
//        System.out.println(sets);
        return answer <= 6 && sets.isEmpty();
    }
}
