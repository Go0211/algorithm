import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    StringBuilder sb = new StringBuilder();
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st =
        new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int Q = Integer.parseInt(st.nextToken());
    int[] arr = new int[N + 1];

    st = new StringTokenizer(br.readLine(), " ");

    for(int i = 1; i <= N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);

    for(int i = 2; i <= N; i++) {
      arr[i] += arr[i - 1];
    }

    for(int i = 0; i < Q; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      sb.append(arr[end] - arr[start - 1]).append("\n");
    }

    System.out.println(sb);
  }
}