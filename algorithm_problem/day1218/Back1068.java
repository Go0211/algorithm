package day1218;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Back1068 {
    static boolean[] v;
    static int count = 0, ban;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("algorithm_problem/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int seq  = Integer.parseInt(br.readLine());
        v = new boolean[seq];
        int start = -1;
        List<Integer>[] arr = new List[seq];
        for (int i = 0; i < seq; i++) {
            arr[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < seq; i++) {
            int idx = Integer.parseInt(st.nextToken());

            if (idx == -1) {
                start = i;
                continue;
            }

            arr[idx].add(i);
        }

        ban = Integer.parseInt(br.readLine());

        dfs(arr, start);

        System.out.println(count);
    }

    private static void dfs(List<Integer>[] arr, int idx) {
        if (idx == ban) {
            return;
        }

        if (arr[idx].contains(ban)) {
            arr[idx].remove(arr[idx].lastIndexOf(ban));
        }

        if (arr[idx].isEmpty()) {
            count++;
            return;
        }

        for (int i = 0; i < arr[idx].size(); i++) {
            int index = arr[idx].get(i);
            if (!v[index]) {
                v[index] = true;
                dfs(arr, index);
            }
        }
    }
}