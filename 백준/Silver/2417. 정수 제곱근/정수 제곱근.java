import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        long num = Long.parseLong(br.readLine());

        long start = 0;
        long end = (long)Math.pow(2, 63) - 1;
        while(num != 0 && start < end) {
            long mid = start + (end - start >>> 1);

            if(Math.pow(mid, 2) < num) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        System.out.println(start);
    }
}