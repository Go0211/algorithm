package problem.year25.day0109;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Back13023 {
    static boolean five = false;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("algorithm_problem/input.txt"));
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
                new StringTokenizer(br.readLine(), " ");
        int idxCount = Integer.parseInt(st.nextToken());
        int seq = Integer.parseInt(st.nextToken());
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < idxCount; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < seq; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

//        for (List<Integer> l : list) {
//            System.out.println(l);
//        }

        for (int i = 0; i < idxCount; i++) {
            if (five) {
                break;
            }

            dfs(list, i, 5, 1, new boolean[idxCount]);
        }

        System.out.println(five ? 1 : 0);
    }

    private static void dfs(List<List<Integer>> list, int idx, int maxLen, int count, boolean[] v) {
        if (count == maxLen) {
            five = true;
            return;
        }

        v[idx] = true;

        List<Integer> l = list.get(idx);
        for (int i : l) {
            if (!v[i] && !five) {
                dfs(list, i, maxLen, count + 1, v.clone());
                v[i] = false;
            }
        }
    }
}
