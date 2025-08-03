import java.util.*;
import java.io.*;

public class Main {
  static class Node {
    long num;
    int count;

    Node(long num, int count) {
      this.num = num;
      this.count = count;
    }

    public String toString() {
      return num + " " + count;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));

    int startCount = 10;
    List<Node> list = new ArrayList<>();
    list.add(new Node(1, startCount));

    for(long i = 2; i < 1_000_000_000; i *= 2) {
      startCount++;
      list.add(new Node(i, startCount));
    }

    int answer = 0;
    long input = Long.parseLong(br.readLine());

    for(Node node : list) {

      if (node.num > input) {
        answer = node.count - 1;
        break;
      }
    }

    System.out.println(answer == 0 ? list.get(list.size() - 1).count : answer);
  }
}