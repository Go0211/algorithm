package problem.year24.day1014;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Back5568 {
  static Set<String> sets;
  static int N, K;

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    K = Integer.parseInt(br.readLine());
    sets = new HashSet<>();
    String[] arr = new String[N];
    for (int i = 0; i < N; i++) {
      arr[i] = br.readLine();
    }

    perm(0, new boolean[N], arr, new String[K]);

    System.out.println(sets.size());
  }

  private static void perm(int cnt, boolean[] v, String[] arr, String[] returnArr) {
    if(cnt == K) {
      String str = "";
      for (String s : returnArr) {
        str += s;
      }

      sets.add(str);
      return;
    }

    for (int i = 0; i < N; i++) {
      if(!v[i]) {
        v[i] = true;
        returnArr[cnt] = arr[i];
        perm(cnt + 1, v, arr, returnArr);
        v[i] = false;
      }
    }
  }
}
