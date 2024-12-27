package problem.day1019;

import java.io.*;
import java.util.*;

public class Back2805 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int len = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());
        int[] arr = new int[len];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int min = 0;
        int max = arr[arr.length - 1];

        System.out.println(findValue(arr, min, max, limit));
    }

    private static int findValue(int[] arr, int min, int max, int limit) {
        while(max >= min) {
            int mid = (max + min) / 2;
            long value = 0;

            for (int num : arr) {
                value += Math.max(num - mid, 0);
            }

            if(limit > value) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return max;
    }
}
