import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = 
        new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = 
        new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[] jewels = new int[M];
    int maxJewel = 0;

    for (int i = 0; i < M; i++) {
      jewels[i] = Integer.parseInt(br.readLine());
      maxJewel = Math.max(maxJewel, jewels[i]);
    }

    int start = 1, end = maxJewel;
    int answer = maxJewel;

    while (start <= end) {
      int mid = (start + end) / 2;

      long needed = 0;
      for (int j : jewels) {
        needed += (long) Math.ceil((double) j / mid);
      }

      if (needed <= N) {
        answer = mid;
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }

    System.out.println(answer);
  }
}
