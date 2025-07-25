import java.io.*;
import java.util.*;

public class Main {
  static class Node {
    int a, b;

    Node(int a, int b) {
      this.a = a;
      this.b = b;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st =
        new StringTokenizer(br.readLine(), " ");
    int D = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    Node[] dp = new Node[31];
    dp[1] = new Node(1, 0);
    dp[2] = new Node(0, 1);

    for(int i = 3; i <= 30; i++) {
      Node n1 = dp[i - 2];
      Node n2 = dp[i - 1];
      dp[i] = new Node(n1.a + n2.a, n1.b + n2.b);
    }

    Node node = dp[D];
    for(int i = 1; i <= 100_000; i++) {
      if((K - (node.a * i)) % node.b == 0) {
        System.out.println(i);
        System.out.println((K - (node.a * i)) / node.b);
        break;
      }
    }
  }
}