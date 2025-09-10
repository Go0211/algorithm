import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
                new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        int start = 0;
        int end = 10_000 * 100_000;
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            start = Math.max(start, arr[i]);
        }

        next:
        while(start < end) {
            int count = 1;
            int mid = start + ((end - start) >>> 1);
            int temp = mid;

            for(int num : arr) {
                if(temp >= num) {
                    temp -= num;
                    continue;
                }

                count++;
                
                if(count > M) {
                    start = mid + 1;
                    continue next;
                }

                temp = mid - num;
            }

            end = mid;
        }

        System.out.println(start);
    }
}