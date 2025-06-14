import java.util.*;
import java.io.*;

public class Main {
  static class Numbers implements Comparable<Numbers> {
    int value;

    Numbers(int value) {
      this.value = value;
    }

    public int compareTo(Numbers other) {
      if (Math.abs(value) == Math.abs(other.value)) {
        return Integer.compare(value, other.value);
      } else {
        return Integer.compare(Math.abs(value), Math.abs(other.value));
      }
    }
  }

  public static void main(String[] args) throws Exception {
    StringBuilder sb = new StringBuilder();
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    PriorityQueue<Numbers> pq = new PriorityQueue<>();

    int seq = Integer.parseInt(br.readLine());

    for(int i = 0; i < seq; i++) {
      int num = Integer.parseInt(br.readLine());

      if(num == 0) {
        sb.append(pq.isEmpty() ? 0 : pq.poll().value).append("\n");
        continue;
      }

      pq.offer(new Numbers(num));
    }

    System.out.print(sb);
  }
}