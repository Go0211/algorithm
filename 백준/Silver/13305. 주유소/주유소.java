import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
  static class Node implements Comparable<Node> {
    int idx;
    int oil;
    long length;

    Node(int idx, int oil, long length) {
      this.idx = idx;
      this.oil = oil;
      this.length = length;
    }

    @Override
    public int compareTo(Node o) {
      return this.oil == o.oil
          ? this.length < o.length  ? -1 : 1
          : this.oil < o.oil ? -1 : 1;
    }

    public String toString() {
      return "idx : " + idx + " oil : " + oil + " length : " + length;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    int seq = Integer.parseInt(br.readLine());
    int[] lineDepths = new int[seq - 1];
    int[] oilCosts = new int[seq - 1];
    long total = 0;
    long answer = 0;

    StringTokenizer st =
        new StringTokenizer(br.readLine());
    for(int i = 0; i < seq - 1; i++) {
      lineDepths[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < seq - 1; i++) {
      int value = Integer.parseInt(st.nextToken());
      oilCosts[i] = value;
    }

    PriorityQueue<Node> pq = new PriorityQueue<>();

    for (int i = seq - 2; i >= 0; i--) {
      pq.add(new Node(i, oilCosts[i], lineDepths[i] + total));
      total += lineDepths[i];
    }

    int limitIdx = Integer.MAX_VALUE;
    long minusLength = 0;
    while(!pq.isEmpty()) {
      Node node = pq.poll();

      if (node.idx > limitIdx) {
        continue;
      }

      answer += node.oil * (node.length - minusLength);
      limitIdx = node.idx;
      minusLength += node.length - minusLength;

      if (limitIdx == 0) {
        break;
      }
    }

    System.out.println(answer);
  }
}