import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    StringBuilder sb = new StringBuilder();
    BitSet sets = new BitSet(1 << 25);

    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st =
        new StringTokenizer(br.readLine(), " ");
    while(st.hasMoreTokens()) {
      int num = Integer.parseInt(st.nextToken());

      if (!sets.get(num)) {
        sets.set(num);
        sb.append(num).append(" ");
      }
    }

    System.out.println(sb);
  }
}