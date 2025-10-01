import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    StringBuilder sb = new StringBuilder();
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st =
        new StringTokenizer(br.readLine(), " ");
    int R = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());
    int[][] arr = new int[R][C];
    for(int i = 0; i < R; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for(int j = 0; j < C; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int seq = Integer.parseInt(br.readLine());
    for(int z = 0; z < seq; z++) {
      st = new StringTokenizer(br.readLine(), " ");
      int preY = Integer.parseInt(st.nextToken()) - 1;
      int preX = Integer.parseInt(st.nextToken()) - 1;
      int nextY = Integer.parseInt(st.nextToken()) - 1;
      int nextX = Integer.parseInt(st.nextToken()) - 1;

      int total = 0;
      for(int i = preY; i <= nextY; i++) {
        for(int j = preX; j <= nextX; j++) {
          total += arr[i][j];
        }
      }

      sb.append(total).append("\n");
    }

    System.out.println(sb);
  }
}