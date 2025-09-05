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
        long[] arr = new long[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr);

        //최소시간
        long start = 0;
        //최대시간 (가장 작은 값 * 인원수)
        long end = arr[0] * M;

        while(start < end) {
            // 중간 시간
            long mid = start + ((end - start) >>> 1);
            long count = 0;

            for(long n : arr) {
                count += mid / n;

                if(count > M) {
                    break;
                }
            }

            //중간 시간내에 인원내에 불가능
            if(count < M) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        System.out.println(start);
    }
}