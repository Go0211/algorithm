import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
            new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long min = Math.min(a, b);
        long max = Math.max(a, b);

        long sum = (((max + 1) * max) / 2) - (((min - 1) * min) / 2);

        System.out.println(sum);
    }
}