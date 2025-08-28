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
    int rx = 0, ry = 1, rz = 2;

    for (int i = 0; i < N - 2; i++) {
      int l = i + 1, r = N - 1;
      while (l < r) {
        long sum = (long) a[i] + a[l] + a[r];
        if (Math.abs(sum) < Math.abs(best)) {
          best = sum;
          rx = i;
          ry = l;
          rz = r;
        }
        if (sum > 0) {
          r--;
        } else if (sum < 0) {
          l++;
        } else {
          System.out.println(a[rx] + " " + a[ry] + " " + a[rz]);
          return;
        }
      }
    }
    System.out.println(a[rx] + " " + a[ry] + " " + a[rz]);
  }
}
