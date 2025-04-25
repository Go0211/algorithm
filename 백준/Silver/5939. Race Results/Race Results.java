import java.util.*;
import java.io.*;

public class Main {
  static class Node {
    int h, m, s;
    Node(int h, int m, int s) {
      this.h = h;
      this.m = m;
      this.s = s;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    StringBuilder stringBuilder = new StringBuilder();
    int seq = Integer.parseInt(br.readLine());
    List<Node> list = new ArrayList<>();
    for(int i = 0; i < seq; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      list.add(new Node(
          Integer.parseInt(st.nextToken()),
          Integer.parseInt(st.nextToken()),
          Integer.parseInt(st.nextToken())));
    }

    list.sort((x, y) -> compareNode(x, y));
    for(Node s : list) {
      stringBuilder.append(s.h + " " + s.m + " " + s.s).append("\n");
    }
    System.out.print(stringBuilder);
  }

  private static int compareNode(Node x, Node y) {
    return x.h * 60 * 60 + x.m * 60 + x.s > y.h * 60 * 60 + y.m * 60 + y.s ? 1 : -1;
  }
}