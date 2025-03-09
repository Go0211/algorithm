import java.util.*;
import java.io.*;

public class Main {
  static class Node {
    //여기는 node만 만드는 곳
    Map<Character, Node> child;
    boolean end;

    Node() {
      child = new HashMap<>();
      end = false;
    }
  }

  static class Trie {
    //여기는 node를 사용해서 Trie를 만드는 곳
    Node root;

    Trie() {
      this.root = new Node();
    }

    public void insert(String str) {
      //root를 가져온다.
      Node root = this.root;

      //str에 요소를 반복문으로 insert 수행
      for(int i = 0; i < str.length(); i++) {
        char c = str.charAt(i);
        root.child.putIfAbsent(c, new Node());
        root = root.child.get(c);
      }

      //끝값일 때, true 입력
      root.end = true;
    }

    public boolean search(String str) {
      //root를 가져온다.
      Node root = this.root;

      //str에 요소를 반복문으로 insert 수행
      for(int i = 0; i < str.length(); i++) {
        char c = str.charAt(i);
        if (root.end) {
          return false;
        }

        if(root.child.containsKey(c)) {
          root = root.child.get(c);
        } else {
          return false;
        }
      }

      //끝 값 state return
      return root.end;
    }
    public boolean delete(Node node, String str, int idx) {
      //현재 idx의 character를 가져오기
      char c = str.charAt(idx);

      //현재 root에 c가 없으면 false
      if(!node.child.containsKey(c)) {
        return false;
      }

      //다음 node 탐색 및 idx 1 증가
      Node cur = node.child.get(c);
      idx++;

      //str 끝 도착 여부
      if(idx == str.length()) {
        //현재 end값이 false면 return false
        if(!cur.end) {
          return false;
        }
        //현재 end를 false로 변경
        cur.end = false;
        //그 뒤에 더 글자가 없다면 remove
        if(cur.child.isEmpty()) {
          cur.child.remove(c);
        }
      } else {
        //현재 재귀 return값이 false면 false return
        if(!this.delete(cur, str, idx)) {
          return false;
        }

        //현재 cur의 end가 false + 그 다음에 없다면 remove
        if(!cur.end && cur.child.isEmpty()) {
          cur.child.remove(c);
        }
      }

      return true;
    }
  }

  public static void main(String[] args) throws Exception{
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int freq = Integer.parseInt(br.readLine());

    for(int z = 0; z < freq; z++) {
      boolean no = false;
      int seq = Integer.parseInt(br.readLine());
      //Trie
      Trie trie = new Trie();
      //반복문 실행
      String[] strArr = new String[seq];
      for(int i = 0; i < seq; i++) {
        String str = br.readLine();

        strArr[i] = str;
      }

      Arrays.sort(strArr);

      for(String str : strArr) {
        if (no) {
          continue;
        }

        trie.insert(str);

        if(!trie.search(str)) {
          sb.append("NO").append("\n");
          no = true;
        }
      }

      if (no) {
        continue;
      }

      sb.append("YES").append("\n");
    }

    System.out.println(sb);
  }
}