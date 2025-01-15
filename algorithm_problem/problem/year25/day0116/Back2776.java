package problem.year25.day0116;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Back2776 {

  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int seq = Integer.parseInt(br.readLine());

    for (int i = 0; i < seq; i++) {
      Set<String> sets = new HashSet<>();
      int len1 = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");

      for (int j = 0; j < len1; j++) {
        sets.add(st.nextToken());
      }

      int len2= Integer.parseInt(br.readLine());
      st = new StringTokenizer(br.readLine(), " ");

      for (int j = 0; j < len2; j++) {
        if (sets.contains(st.nextToken())) {
          sb.append(1).append("\n");
        } else {
          sb.append(0).append("\n");
        }
      }
    }

    System.out.print(sb);
  }
}
