import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
                new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int digit = 1;
        long count = 9;
        long len = 0;

        while (k > digit * count) {
            k -= digit * count;
            len += count;
            digit++;
            count *= 10;
        }

        int num = (int)(Math.pow(10, digit - 1) + (k - 1) / digit);
        if (num > n) {
            System.out.println(-1);
        } else {
            String s = String.valueOf(num);
            System.out.println(s.charAt((k - 1) % digit));
        }
    }
}