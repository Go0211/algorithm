import java.io.*;
import java.util.*;

public class Main {
  static int result = 0;

  static class Node {
    Map<Character, Node> child;
    boolean end;

    Node() {
      this.child = new HashMap<>();
      this.end = false;
    }
  }
  static class Trie {
    Node trie;

    Trie() {
      trie = new Node();
    }

    //생성
    public void insert(String str) {
      Node trie = this.trie;

      for(int i = 0; i < str.length(); i++) {
        char c = str.charAt(i);

        trie.child.putIfAbsent(c, new Node());
        trie = trie.child.get(c);
      }

      trie.end = true;
    }
    //탐색
    public boolean search(String str) {
      Node trie = this.trie;

      for(int i = 0; i < str.length(); i++) {
        char c = str.charAt(i);

        if(trie.child.containsKey(c)) {
          trie = trie.child.get(c);
        } else {
          return false;
        }
      }

      return true;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st =
        new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    List<String> list = new ArrayList<>();

    Trie T = new Trie();
    for(int i = 0; i < N; i++) {
      list.add(br.readLine());
    }
    Collections.sort(list);
    for(String str : list) {
      T.insert(str);
    }

    list = new ArrayList<>();
    for(int i = 0; i < M; i++) {
      list.add(br.readLine());
    }
    Collections.sort(list);
    for(String str : list) {
      if(T.search(str)) {
        result++;
      }
    }

    System.out.println(result);
  }
}