import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    StringBuilder sb = new StringBuilder();
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    PriorityQueue<Long> pq =
        new PriorityQueue<>((x, y) -> compare(x, y));

    int seq = Integer.parseInt(br.readLine());

    for(int i = 0; i < seq; i++) {
      long num = Long.parseLong(br.readLine());

      if(num == 0) {
        sb.append(pq.isEmpty() ? 0 : pq.poll()).append("\n");
        continue;
      }

      pq.offer(num);
    }

    System.out.print(sb);
  }

  static int compare(long x, long y) {
    return Math.abs(x) == Math.abs(y)
        ? (x > y ? 1 : -1)
        : (Math.abs(x) > Math.abs(y) ? 1 : -1);
  }
}