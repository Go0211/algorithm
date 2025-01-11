package problem.year25.day0111;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back2343 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("algorithm_problem/input.txt"));
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
                new StringTokenizer(br.readLine(), " ");
        int len = Integer.parseInt(st.nextToken());
        int seq = Integer.parseInt(st.nextToken());
        int[] arr = new int[len];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int min = 0;
        int max = 10_000 * 100_000;

        System.out.println(divide(arr, seq, min, max));
    }

    private static int divide(int[] arr, int seq, int min, int max) {
        while (max >= min) {
            int mid = (max + min) / 2;

            int count = 0;
            int total = 0;
            for (int i = 0; i < arr.length; i++) {
                if (count > seq) {
                    break;
                }

                total += arr[i];

                if (total > mid) {
                    total = 0;
                    count++;
                    i--;
                }
            }

            if (seq <= count) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        return min;
    }
}