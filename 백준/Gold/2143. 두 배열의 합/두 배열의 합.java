import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        long answer = 0;
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int[] partSumNArr =
                inputInitialize(new StringTokenizer(br.readLine(), " "), n);

        int m = Integer.parseInt(br.readLine());
        int[] partSumMArr =
                inputInitialize(new StringTokenizer(br.readLine(), " "), m);

        for(int num : partSumNArr) {
            answer += upperBound(partSumMArr, target - num, partSumMArr.length)
            - lowerBound(partSumMArr, target - num, partSumMArr.length);
        }

        System.out.println(answer);
    }

    static int[] inputInitialize(StringTokenizer st, int len) {
        int[] arr = IntStream.range(0, len)
                .map(i -> Integer.parseInt(st.nextToken()))
                .toArray();

        int[] partSumArr = new int[(len * (len + 1)) / 2];

        int index = 0;
        for(int i = 0; i < len; i++) {
            int num = 0;
            for(int j = i; j < len; j++) {
                num += arr[j];
                partSumArr[index++] = num;
            }
        }

        Arrays.sort(partSumArr);

        return partSumArr;
    }

    static int lowerBound(int[] arr, int target, int len) {
        int start = 0;
        int end = len;

        while(start < end) {
            int mid = start + ((end - start) >> 1);

            if(target > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;
    }

    static int upperBound(int[] arr, int target, int len) {
        int start = 0;
        int end = len;

        while(start < end) {
            int mid = start + ((end - start) >> 1);

            if(target >= arr[mid]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;
    }
}