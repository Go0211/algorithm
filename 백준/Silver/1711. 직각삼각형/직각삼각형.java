import java.io.*;
import java.util.*;

public class Main {
  static class Node {
    int x, y;

    Node(int y, int x) {
      this.y = y;
      this.x = x;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int seq = Integer.parseInt(br.readLine());
    Node[] arr = new Node[seq];
    for (int i = 0; i < seq; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      arr[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }

    int answer = 0;
    for (int i = 0; i < seq; i++) {
      for (int j = i + 1; j < seq; j++) {
        for (int k = j + 1; k < seq; k++) {
          if (isTriangle(arr[i], arr[j], arr[k]) && isRightTriangle(arr[i], arr[j], arr[k])) {
            answer++;
          }
        }
      }
    }
    System.out.println(answer);
  }

  static boolean isTriangle(Node node1, Node node2, Node node3) {
    return (long)(node2.x - node1.x) * (long)(node3.y - node1.y)
        - (long)(node2.y - node1.y) * (long)(node3.x - node1.x) != 0;
  }

  static boolean isRightTriangle(Node node1, Node node2, Node node3) {
    return dotProduct(node1, node2, node3) || dotProduct(node2, node1, node3) || dotProduct(node3,
        node1, node2);
  }

  static boolean dotProduct(Node node1, Node node2, Node node3) {
    return (long)(node2.x - node1.x) * (long)(node3.x - node1.x)
        + (long)(node2.y - node1.y) * (long)(node3.y - node1.y) == 0;
  }
}
