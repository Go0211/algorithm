import java.sql.SQLOutput;
import java.util.*;
import java.io.*;

public class Main {
  static class Node {
    int idx, count;

    Node(int idx, int count) {
      this.idx = idx;
      this.count = count;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    int seq = Integer.parseInt(br.readLine());
    List<Set<Integer>> list = new ArrayList<>();

    for(int i = 0; i < seq + 1; i++) {
      list.add(new HashSet<>());
    }
    StringTokenizer st;
    for(int i = 0; i < seq - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      list.get(a).add(b);
      list.get(b).add(a);
    }

    boolean flag = false;
    ArrayDeque<Node> stack = new ArrayDeque<>();
    st = new StringTokenizer(br.readLine());
    if (Integer.parseInt(st.nextToken()) == 1) {
      stack.push(new Node(1, 0));

      while(st.hasMoreTokens()) {
        Node node = stack.peek();

        if(list.get(node.idx).size() <= node.count) {
          stack.pop();
          continue;
        }

        int nextIdx = Integer.parseInt(st.nextToken());

        if (list.get(node.idx).contains(nextIdx)) {
          node.count++;
          stack.push(new Node(nextIdx, 1));
          continue;
        }

        flag = true;
        break;
      }

      System.out.println(!flag ? 1 : 0);
    } else {
      System.out.println(0);
    }
  }
}