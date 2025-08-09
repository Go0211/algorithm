import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    StringBuilder sb = new StringBuilder();
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    StringTokenizer st =
        new StringTokenizer(br.readLine());

    ArrayDeque<int[]> stack = new ArrayDeque<>();
    for(int i = 1; i <= n; i++) {
      int top = Integer.parseInt(st.nextToken());
      while(!stack.isEmpty()) {
        if(stack.peek()[1] >= top) {
          sb.append(stack.peek()[0]).append(" ");
          break;
        }
        stack.pop();
      }
      if(stack.isEmpty()) {
        sb.append(0).append(" ");
      }
      stack.push(new int[] {i, top});
    }

    System.out.println(sb);
  }
}
