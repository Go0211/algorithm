import java.io.*;
import java.util.*;

public class Back1316 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int seq = Integer.parseInt(br.readLine());
    int cnt = 0;

    next:
    for (int i = 0; i < seq; i++) {
      String str = br.readLine();
      Set<Character> sets = new HashSet<>();

      char before = str.charAt(0);
      for (int j = 1; j < str.length(); j++) {
        char c = str.charAt(j);

        //이전 값과 같다 or 이전값과 다르다 + 전에 나온적이 없다.
        sets.add(before);
        if(c == before) {
          continue;
        } else if(!sets.contains(c)) {
          before = c;
          sets.add(c);
        } else {
          continue next;
        }
      }

      cnt++;
    }

    System.out.println(cnt);
  }
}
