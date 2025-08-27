import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int z = 0; z < N; z++) {
            StringTokenizer st =
                    new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            long sum = 0;
            int[] arr = new int[A];
            int[] brr = new int[B];

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < A; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < B; i++) {
                brr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(brr);

            // 이분탐색
            for (int target : arr) {
                // target을 기준으로 절대값이 작은 걸 찾기!
                // 절대값이 같다면 더 작은 값이 우선!
                sum += closest(brr, target);
            }

            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }

    private static int lowerBound(int[] brr, int target) {
        int start = 0;
        int end = brr.length;

        while (start < end) {
            int mid = start + ((end - start) >>> 1);
            int isMinus = Integer.compare(target - brr[mid], 0);

            if (isMinus > 0) {
                start = mid + 1;
            } else if (isMinus < 0){
                end = mid;
            } else {
                return mid;
            }
        }

        return start;
    }

    static int closest(int[] b, int target) {
        int n = b.length;
        int idx = lowerBound(b, target);

        if (idx == 0) return b[0];
        if (idx == n) return b[n - 1];

        int c1 = b[idx - 1];
        int c2 = b[idx];    
        int d1 = Math.abs(target - c1);
        int d2 = Math.abs(target - c2);

        if (d1 < d2) return c1;
        if (d2 < d1) return c2;
        
        return Math.min(c1, c2);
    }
}