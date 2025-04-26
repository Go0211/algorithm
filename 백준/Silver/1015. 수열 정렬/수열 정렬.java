import java.util.*;
import java.io.*;

public class Main {
  static class Node {
    int value, idx;
    Node(int value, int idx) {
      this.value = value;
      this.idx = idx;
    }

    public String toString() {
      return "value: " + value + " idx: " + idx;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    int len = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> compare(x ,y));
    int idx = 0;
    while(st.hasMoreTokens()) {
      pq.add(new Node(Integer.parseInt(st.nextToken()), idx));
      idx++;
    }
    int[] arr = new int[len];
    for(int i = 0; i < len; i++) {
      Node n = pq.remove();
      arr[n.idx] = i;
    }

    for(int i : arr) {
      sb.append(i).append(" ");
    }
    System.out.println(sb);
  }

  static int compare(Node x, Node y) {
    if(x.value == y.value) {
      return x.idx < y.idx ? -1 : 1;
    } else if(x.value < y.value) {
      return -1;
    } else {
      return 1;
    }
  }
}