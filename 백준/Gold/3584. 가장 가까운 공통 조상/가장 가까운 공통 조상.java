import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int seq = Integer.parseInt(br.readLine());
    StringTokenizer st;

    for(int z = 0; z < seq; z++) {
      int nodeCount = Integer.parseInt(br.readLine());
      Map<Integer, Integer> map = new HashMap<>();

      for(int i = 0; i < nodeCount - 1; i++) {
        st = new StringTokenizer(br.readLine(), " ");
        int upNode = Integer.parseInt(st.nextToken());
        int downNode = Integer.parseInt(st.nextToken());

        map.put(downNode, upNode);
      }

      st = new StringTokenizer(br.readLine(), " ");
      int target1 = Integer.parseInt(st.nextToken());
      int target2 = Integer.parseInt(st.nextToken());
      Set<Integer> sets = new HashSet<>();
      sets.add(target1);
      while(map.containsKey(target1)) {
        int value = map.get(target1);
        sets.add(value);
        target1 = value;
      }

      while (!sets.contains(target2)) {
        target2 = map.get(target2);
      }
        
      sb.append(target2).append("\n");
    }

    System.out.print(sb);
  }
}