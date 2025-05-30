import java.util.*;
import java.io.*;

public class Main {
  static int answer = 0;

  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st =
        new StringTokenizer(br.readLine());
    int seq = Integer.parseInt(st.nextToken());
    int words = Integer.parseInt(st.nextToken()) - 5;
    List<List<Character>> list = new ArrayList<>();
    int emptyCount = 0;

    if(words >= 0) {
      List<Character> chars = new ArrayList<>();

      for(int i = 0; i < seq; i++) {
        String str = br.readLine();
        List<Character> l = new ArrayList<>();

        for(int j = 4; j < str.length() - 4; j++) {
          char c = str.charAt(j);

          if(c != 'a' && c != 'c' && c != 'n'
              && c != 't' && c != 'i' && !l.contains(c)) {
            if (!chars.contains(c)) {
              chars.add(c);
            }
            l.add(c);
          }
        }

        if (l.size() != 0) {
          list.add(l);
        } else {
          emptyCount++;
        }
      }

      comb(list, chars, new ArrayList<>(), 0, 0, Math.min(words, chars.size()));
    }

    System.out.println(answer + emptyCount);
  }

  static void comb(List<List<Character>> list, List<Character> chars,
      List<Character> sets, int depth, int idx, int size) {
    if(depth == size) {
      int count = 0;

      for(List<Character> l : list) {
        if(sets.containsAll(l)) {
          count++;
        }
      }

      answer = Math.max(count, answer);
      return;
    }

    for(int i = idx; i < chars.size(); i++) {
      sets.add(chars.get(i));
      comb(list, chars, sets, depth + 1, i + 1, size);
      sets.remove(chars.get(i));
    }
  }
}