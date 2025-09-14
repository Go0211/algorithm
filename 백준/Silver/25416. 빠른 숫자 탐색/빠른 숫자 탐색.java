import java.util.*;
import java.io.*;
import java.util.stream.IntStream;

public class Main {
  static int[][] dirs = {{1, 0},{-1, 0},{0, 1},{0, -1}};

  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    int[][] arr = new int[5][5];

    for(int i = 0; i < 5; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");

      arr[i] = IntStream.range(0, st.countTokens())
          .map(x -> Integer.parseInt(st.nextToken()))
          .toArray();
    }

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    ArrayDeque<int[]> queue = new ArrayDeque<>();
    queue.offer(new int[]{
        Integer.parseInt(st.nextToken()),
        Integer.parseInt(st.nextToken()),
        0});
    boolean[][] v = new boolean[5][5];

    int answer = -1;

    while(!queue.isEmpty()) {
      int[] ints = queue.poll();
      int py = ints[0];
      int px = ints[1];
      int count = ints[2];

      v[py][px] = true;

      if(arr[py][px] == 1) {
        answer = count;
        break;
      }

      for(int[] dir : dirs) {
        int ny = py + dir[0];
        int nx = px + dir[1];

        if(ny >= 0 && ny < 5
            && nx >= 0 && nx < 5
            && arr[ny][nx] != -1
            && !v[ny][nx]) {
          queue.offer(new int[]{ny, nx, count + 1});
        }
      }
    }

    System.out.println(answer);
  }
}