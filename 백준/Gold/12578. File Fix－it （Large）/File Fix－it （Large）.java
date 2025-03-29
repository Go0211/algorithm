import java.io.*;
import java.util.*;

public class Main {
  static int count;

  static class Node {
    Map<String, Node> node;

    Node() {
      node = new HashMap<>();
    }
  }

  static class Trie {
    Node trie = new Node();

    // /기준으로 분리한 str배열로 trie 삽입
    void insert(String[] arr) {
      Node n = trie;

      // 시작 제외하고 map에 다 삽입
      for(int i = 1; i < arr.length; i++) {
        if(arr[i] != null || arr[i].isEmpty()) {
          if (!n.node.containsKey(arr[i])) {
            n.node.put(arr[i], new Node());
          }
          n = n.node.get(arr[i]);
        }
      }
    }

    // 탐색 + 없으면 삽입
    void searchAndInsert(String[] arr) {
      Node n = trie;

      // 시작 제외하고 map에 다 삽입
      for(int i = 1; i < arr.length; i++) {
        if(arr[i] != null || arr[i].isEmpty()) {
          if (!n.node.containsKey(arr[i])) {
            count++;
            n.node.put(arr[i], new Node());
          }
          n = n.node.get(arr[i]);
        }
      }
    }
  }

  public static void main(String[] args) throws Exception{
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    int freq = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    for(int z = 1; z <= freq; z++) {
      count = 0;
      Trie t = new Trie();
      StringTokenizer st =
          new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int problem = Integer.parseInt(st.nextToken());

      for(int i = 0; i < start; i++) {
        t.insert(br.readLine().split("/"));
      }
      for(int i = 0; i < problem; i++) {
        t.searchAndInsert(br.readLine().split("/"));
      }

      sb.append("Case").append(" ")
          .append("#").append(z).append(":").append(" ")
          .append(count).append("\n");
    }

    System.out.println(sb);
  }
}