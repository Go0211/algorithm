import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    StringBuilder sb = new StringBuilder();
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    int seq = Integer.parseInt(br.readLine());
    Map<String, Integer> toNumberMap = new HashMap<>();
    String[] arr = new String[16];
    arr[0] = "{}";
    toNumberMap.put("{}", 0);
    for(int i = 1; i < 16; i++) {
      StringBuilder str = new StringBuilder("{");

      for(int j = 0; j < i; j++) {
        str.append(arr[j]);

        if(j + 1 != i) {
          str.append(",");
        }
      }

      str.append("}");

      arr[i] = str.toString();
      toNumberMap.put(str.toString(), i);
    }

    for(int i = 0; i < seq; i++) {
      sb.append(
          arr[toNumberMap.get(br.readLine()) + toNumberMap.get(br.readLine())]).append("\n");
    }

    System.out.println(sb);
  }
}