import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = 
        new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[] left = new int[N + 1];
    int[] right = new int[N + 1];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = 
          new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      left[a] = Integer.parseInt(st.nextToken());
      right[a] = Integer.parseInt(st.nextToken());
    }

    int depth = 0;
    int cur = 1;
    while (right[cur] != -1) {
      cur = right[cur];
      depth++;
    }

    System.out.println(2L * (N - 1) - depth);
  }
}
