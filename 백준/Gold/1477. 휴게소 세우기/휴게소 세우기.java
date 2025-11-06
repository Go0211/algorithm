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
        int L = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+2];
        arr[0] = 0;
        arr[N+1] = L;

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i < N+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int[] lens = new int[N+1];
        for(int i = 0; i < N + 1; i++) {
            lens[i] = arr[i+1] - arr[i];
        }

        int start = 1;
        int end = L - 1;

        while(start < end) {
            int mid = start + ((end - start) >>> 1);
            long total = 0;

            for(int len : lens) {
                total += (len - 1) / mid;
            }

            if(total > M) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        System.out.println(start);
    }
}