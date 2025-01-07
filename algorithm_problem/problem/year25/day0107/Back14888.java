package problem.year25.day0107;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Back14888 {
    static boolean[] v;
    static int max, min;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("algorithm_problem/input.txt"));
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int seq = Integer.parseInt(br.readLine());
        int[] numbers = new int[seq];
        int[] operations = new int[4];
        v = new boolean[seq];
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        StringTokenizer st =
                new StringTokenizer(br.readLine());
        for (int i = 0; i < seq; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operations[i] = Integer.parseInt(st.nextToken());
        }
        
        permAndCalc(numbers, operations, 0, new int[seq - 1], seq - 1);

        System.out.println(max);
        System.out.println(min);
    }

    private static void permAndCalc(int[] numbers, int[] operations, int idx, int[] returnArr, int seq) {
        if (seq == idx) {
            int result = numbers[0];

            for (int i = 1; i < seq + 1; i++) {
                switch (returnArr[i-1]) {
                    case 0:
                        result += numbers[i];
                        break;
                    case 1:
                        result -= numbers[i];
                        break;
                    case 2:
                        result *= numbers[i];
                        break;
                    case 3:
                        result /= numbers[i];
                        break;
                }
            }

            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operations[i] != 0) {
                operations[i]--;
                returnArr[idx] = i;
                permAndCalc(numbers, operations, idx + 1, returnArr.clone(), seq);
                operations[i]++;
            }
        }
    }
}
