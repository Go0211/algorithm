package problem.year25.day0111;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Back1342 {
  static int result = 0;
  static Set<String> sets = new HashSet<>();

  public static void main(String[] args) throws Exception {
    System.setIn(new FileInputStream("algorithm_problem/input.txt"));
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    char[] chars = br.readLine().toCharArray();
    Map<Character, Integer> maps = new HashMap<>();

    for (char c : chars) {
      if (!maps.containsKey(c)) {
        maps.put(c, 0);
      }
      maps.put(c, maps.get(c) + 1);
    }

    System.out.println(maps);

    perm(maps, 0, 'A', chars.length);
    System.out.println(result);
  }

  private static void perm(Map<Character, Integer> maps, int idx, char preIdx, int length) {
    if (idx == length) {
//      System.out.println(Arrays.toString(arr));
      result++;
      return;
    }

    for (char c : maps.keySet()) {
      if (maps.get(c) != 0 && preIdx != c) {
        maps.put(c, maps.get(c) - 1);
        perm(maps, idx + 1, c, length);
        maps.put(c, maps.get(c) + 1);
      }
    }
  }
}