import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    StringBuilder sb = new StringBuilder();
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st =
        new StringTokenizer(br.readLine());
    int size = Integer.parseInt(st.nextToken());
    int seq = Integer.parseInt(st.nextToken());
    List<Integer> list = new ArrayList<>();

    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < size; i++) {
      list.add(Integer.parseInt(st.nextToken()));
    }
    list.sort((x, y) -> x - y);

    int min = list.get(0);
    int max = list.get(list.size() - 1);

    long[] dp = new long[max + 1];

    for(int a : list) {
      dp[min] += Math.abs(a - min);
    }

    for(int i = min + 1; i < max + 1; i++) {
      int l = 0, r = list.size();
      while (l < r) {
        int mid = (l + r) / 2;
        if (list.get(mid) < i) {
          l = mid + 1;
        } else {
          r = mid;
        }
      }
      int count = l;

      dp[i] = dp[i - 1] + count - (size - count);
    }

    for(int i = 0; i < seq; i++) {
      int idx = Integer.parseInt(br.readLine());

      if(idx < min) {
        sb.append(dp[min] + ((long)(min - idx) * size)).append("\n");
      } else if(idx > max) {
        sb.append(dp[max] + ((long)(idx - max) * size)).append("\n");
      } else {
        sb.append(dp[idx]).append("\n");
      }
    }

    System.out.println(sb);
  }
}