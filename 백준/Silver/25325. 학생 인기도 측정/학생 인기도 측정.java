import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    int seq = Integer.parseInt(br.readLine());
    Map<String, Integer> maps = new HashMap<>();
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for(int i = 0; i < seq; i++) {
      maps.put(st.nextToken(), 0);
    }

    for(int i = 0; i < seq; i++) {
      st = new StringTokenizer(br.readLine(), " ");

      while(st.hasMoreTokens()) {
        String str = st.nextToken();
        maps.put(str, maps.get(str) + 1);
      }
    }

    List<Map.Entry<String, Integer>> list = new ArrayList<>(maps.entrySet());
    list.sort((x, y) -> y.getValue() - x.getValue() == 0
        ? x.getKey().compareTo(y.getKey())
        : y.getValue() - x.getValue());

    for(Map.Entry<String, Integer> entry : list) {
      System.out.println(entry.getKey() + " " + entry.getValue());
    }
  }
}