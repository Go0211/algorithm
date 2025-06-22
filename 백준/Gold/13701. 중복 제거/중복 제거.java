import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    StringBuilder sb = new StringBuilder();
    Set<String> sets = new HashSet<>();

    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st =
        new StringTokenizer(br.readLine(), " ");
    while(st.hasMoreTokens()) {
      String str = st.nextToken();

      if (!sets.contains(str)) {
        sb.append(str).append(" ");
        sets.add(str);
      }
    }

    System.out.println(sb);
  }
}