import java.util.*;
import java.io.*;

public class Main {
  static class Node {
    String str;
    int score;

    Node(String str, int score) {
      this.str = str;
      this.score = score;
    }
  }

  public static void main(String[] args) throws Exception {
    PriorityQueue<Node> minPq =
        new PriorityQueue<>((x, y) -> x.score - y.score);
    PriorityQueue<Node> maxPq =
        new PriorityQueue<>((x, y) -> y.score - x.score);
    Map<String, Integer> map = new HashMap<>();
    Set<String> minSets = new HashSet<>();
    Set<String> maxSets = new HashSet<>();
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st =
        new StringTokenizer(br.readLine());
    int seq = Integer.parseInt(st.nextToken());
    int len = Integer.parseInt(st.nextToken());
    int openSize = Integer.parseInt(st.nextToken());
    int copyLen = len - openSize;
    int min = 0;
    int max = 0;

    for(int i = 0; i < seq; i++) {
      st = new StringTokenizer(br.readLine());
      Node node = new Node(
          st.nextToken(),
          Integer.parseInt(st.nextToken())
      );
      minPq.offer(node);
      maxPq.offer(node);
      map.put(node.str, node.score);
    }

    for(int i = 0; i < openSize; i++) {
      String s = br.readLine();
      minSets.add(s);
      maxSets.add(s);
      min += map.get(s);
      max += map.get(s);
    }

    while(copyLen != 0) {
      copyLen--;
      Node node = minPq.poll();

      if(!minSets.contains(node.str)) {
        minSets.add(node.str);
        min += node.score;
      } else {
        copyLen++;
      }
    }

    copyLen = len - openSize;
    while(copyLen != 0) {
      copyLen--;
      Node node = maxPq.poll();

      if(!maxSets.contains(node.str)) {
        maxSets.add(node.str);
        max += node.score;
      } else {
        copyLen++;
      }
    }

    System.out.println(min + " " + max);
  }
}