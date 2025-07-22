import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader  br =
        new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];

    StringTokenizer st =
        new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    System.out.println(sol(arr, N));
  }

  public static long sol(int[] arr, int n) {
    long tmp = 0;
    long[] cnt_arr = new long[n];
    for (int i = 1; i < n; i++) {
      double ratio =
          Math.ceil(Math.log(arr[i - 1]
              / (double)arr[i]) / Math.log(2)) + cnt_arr[i - 1];
      if (ratio > 0) {
        cnt_arr[i] = Math.max(0, (long)ratio);
        tmp += cnt_arr[i];
      }
    }
    return tmp;
  }
}