package problem.year25.day0113;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back2467 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("algorithm_problem/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int seq = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[seq];

        for (int i = 0; i < seq; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int min = 0;
        int max = seq - 1;
        int minResult = Integer.MIN_VALUE;
        int maxResult = Integer.MAX_VALUE;
        int zero = Integer.MAX_VALUE;

        while (min < max) {
            int minValue = arr[min];
            int maxValue = arr[max];

            if (minValue + maxValue == 0) {
                minResult = minValue;
                maxResult = maxValue;
                break;
            }

            if (zero > Math.abs(minValue + maxValue)) {
                zero = Math.abs(minValue + maxValue);
                minResult = minValue;
                maxResult = maxValue;
            }

            if (minValue + maxValue < 0) {
                min++;
            } else {
                max--;
            }
        }

        System.out.println(minResult + " " + maxResult);
    }
}
