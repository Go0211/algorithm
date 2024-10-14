package day1014;

import java.io.*;
import java.util.*;

public class Back10816 {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer.parseInt(br.readLine());
    Map<String, Integer> map = new HashMap<>();
    StringBuffer sb = new StringBuffer();

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    while (st.hasMoreTokens()) {
      String str = st.nextToken();
      if(map.containsKey(str)) {
        map.put(str, map.get(str) + 1);
      } else {
        map.put(str, 1);
      }
    }

    Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine(), " ");
    while (st.hasMoreTokens()) {
      String str = st.nextToken();
      sb.append(map.containsKey(str) ? map.get(str) + "" : 0 + "").append(" ");
    }

    System.out.println(sb);
  }
}
