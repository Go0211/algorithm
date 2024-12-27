package problem.day1227;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Back21735 {
    static int result;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("algorithm_problem/input.txt"));
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
                new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        result = 0;

        List<Integer> list =
                Arrays.stream(br.readLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        comb(list, -1, 1,0, R);
        System.out.println(result);
    }

    private static void comb(List<Integer> list, int idx, int sum, int cnt, int R) {
        if (idx == list.size() - 1 || cnt == R) {
            result = Math.max(sum, result);
            return;
        }

        if (idx + 1 < list.size()) {
            comb(list, idx + 1, sum + list.get(idx + 1), cnt + 1, R);
        }
        if (idx + 2 < list.size()) {
            comb(list, idx + 2, (sum / 2) + list.get(idx + 2), cnt + 1, R);
        }
    }
}