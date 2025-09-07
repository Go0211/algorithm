import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    long N = Long.parseLong(br.readLine());
    long k = Long.parseLong(br.readLine());

    long start = 1;
    long end = N * N;

    while(start < end) {
      long mid = start + ((end - start) >>> 1);
      long cnt = 0;

      for(int i = 1; i <= N; i++) {
        cnt += Math.min(N, mid / i);

        if(cnt > k) {
          break;
        }
      }

      if(cnt < k) {
        start = mid + 1;
      } else {
        end = mid;
      }
    }

    System.out.println(start);
  }
}