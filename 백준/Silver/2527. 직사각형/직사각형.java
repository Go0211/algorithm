import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = 
        new BufferedReader(new InputStreamReader(System.in));
    for (int z = 0; z < 4; z++) {
      StringTokenizer st = 
          new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());
      int x3 = Integer.parseInt(st.nextToken());
      int y3 = Integer.parseInt(st.nextToken());
      int x4 = Integer.parseInt(st.nextToken());
      int y4 = Integer.parseInt(st.nextToken());

      int dx = Math.min(x2, x4) - Math.max(x1, x3);
      int dy = Math.min(y2, y4) - Math.max(y1, y3);

      if (dx < 0 || dy < 0) {
          System.out.println('d');
      }
      else if (dx == 0 && dy == 0) {
          System.out.println('c');
      }
      else if (dx == 0 || dy == 0) {
          System.out.println('b');
      }
      else {
          System.out.println('a');
      }
    }
  }
}
