package problem.year24.day1027;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Back5958 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int seq = Integer.parseInt(br.readLine());
        int len = (int) Math.pow(2, seq);
        long answer = 0;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 2; i <= len; i *= 2) {
            for (int j = 0; j < len; j += i) {
                if (arr[j] > arr[j + i / 2]) {
                    for (int k = j; k < j + i / 2; k++) {
                        int temp = arr[k];
                        arr[k] = arr[k + i / 2];
                        arr[k + i / 2] = temp;
                    }
                    answer += (long) Math.pow(2, (int)(Math.log(i) / Math.log(2))) * (i / 2);
                }
            }
        }
        System.out.println(answer);
        for (int num : arr) {
            System.out.println(num);
        }
    }
}
