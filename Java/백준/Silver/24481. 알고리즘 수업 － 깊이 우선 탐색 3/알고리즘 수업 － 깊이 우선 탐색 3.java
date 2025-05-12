import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
                new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int nodeCount = Integer.parseInt(st.nextToken());
        int seq = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken()) - 1;
        int[] arr = new int[nodeCount];
        Arrays.fill(arr, -1);

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nodeCount; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < seq; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            list.get(a).add(b);
            list.get(b).add(a);
        }

        for (int i = 0; i < nodeCount; i++) {
            list.get(i).sort((x, y) -> x - y);
        }

        dfs(list, start, 0, arr);

        for (int i : arr) {
            sb.append(i).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(List<List<Integer>> list, int start, int count, int[] arr) {
        arr[start] = count;

        List<Integer> l = list.get(start);

        for (int i : l) {
            if (arr[i] == -1) {
                dfs(list, i, count + 1, arr);
            }
        }
    }
}