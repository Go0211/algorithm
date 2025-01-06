package problem.year25.day0106;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Back15658 {
    static boolean[] v;
    static List<int[]> list;
    static int max, min;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("algorithm_problem/input.txt"));
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int seq = Integer.parseInt(br.readLine());
        int[] numArr = new int[seq];
        int[] gArr = new int[4];
        StringTokenizer st =
                new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < seq; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            gArr[i] = Integer.parseInt(st.nextToken());
        }

        v = new boolean[seq];
        list = new ArrayList<>();
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        permAndCalc(numArr, gArr, 0, new int[seq], seq - 1);

        System.out.println(max);
        System.out.println(min);
    }

    private static void permAndCalc(int[] numArr, int[] gArr, int i, int[] arr, int seq) {
        if (i == seq) {
            int result = numArr[0];

            for (int j = 0; j < seq; j++) {
                if (arr[j] == 0) {
                    result += numArr[j + 1];
                } else if (arr[j] == 1) {
                    result -= numArr[j + 1];
                } else if (arr[j] == 2) {
                    result *= numArr[j + 1];
                } else {
                    result /= numArr[j + 1];
                }
            }

            max = Math.max(result, max);
            min = Math.min(result, min);

            return;
        }

        for (int j = 0; j < 4; j++) {
            if (gArr[j] != 0) {
                gArr[j]--;
                arr[i] = j;
                permAndCalc(numArr, gArr, i + 1, arr.clone(), seq);
                gArr[j]++;
            }
        }
    }
}