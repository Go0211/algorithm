import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[M];

        StringTokenizer st =
                new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 1;
        int end = N;

        next:
        while(start < end) {
            int mid = start + ((end - start) >>> 1);
            boolean touchN = false;
            int prev = 0;

            for(int i : arr) {
                int min = i - mid;
                int max = i + mid;

                if(prev < min) {
                    start = mid + 1;
                    continue next;
                }
                if(max >= N) {
                    touchN = true;
                }

                prev = max;
            }

            if(!touchN) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        System.out.println(start);
    }
}