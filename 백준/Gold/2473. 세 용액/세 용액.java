import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];
        StringTokenizer st =
                new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);

        long best = Long.MAX_VALUE;
        int x = 0, y = 1, z = 2;

        for (int i = 0; i < N - 2; i++) {
            int start = i + 1, end = N - 1;
            while (start < end) {
                long sum = (long) a[i] + a[start] + a[end];
                if (Math.abs(sum) < Math.abs(best)) {
                    best = sum;
                    x = i;
                    y = start;
                    z = end;
                }
                if (sum > 0) {
                    end--;
                } else if (sum < 0) {
                    start++;
                } else {
                    System.out.println(a[x] + " " + a[y] + " " + a[z]);
                    return;
                }
            }
        }
        System.out.println(a[x] + " " + a[y] + " " + a[z]);
    }
}
