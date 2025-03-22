import java.io.*;
import java.util.*;

public class Main {
  static int total = 17;
  static int[] dices = {6, 5, 4, 3, 2, 1};

  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st =
        new StringTokenizer(br.readLine(), " ");
    // 사다리 수, 뱀 수, 사다리+뱀의 map, 방문여부
    int ladders = Integer.parseInt(st.nextToken());
    int snakes = Integer.parseInt(st.nextToken());
    Map<Integer, Integer> maps = new HashMap<>();
    boolean[] v = new boolean[101];
    v[1] = true;

    //map에 다 저장
    for(int i = 0; i < ladders + snakes; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      maps.put(
          Integer.parseInt(st.nextToken()),
          Integer.parseInt(st.nextToken())
      );
    }

    System.out.println(Math.min(bfs(maps), total));
  }

  static int bfs(Map<Integer, Integer> maps) {
    ArrayDeque<int[]> queue = new ArrayDeque<>();
    queue.add(new int[]{1, 0});
    boolean[] v = new boolean[101];

    while (!queue.isEmpty()) {
      int[] arr = queue.poll();
      int idx = arr[0];
      int c = arr[1];

      // 현재 count가 total 이상으로 return
      if(c >= total) {
        continue;
      }

      // 현재 start가 100이상이면 total과 비교
      if(idx >= 100) {
        return c;
      }

      // 6~1까지 값 넣기
      for(int i : dices) {
        int next = idx + i;

        // v가 false, 1~100사이
        if(next <= 100 && !v[next]) {
          // maps에 존재하면 그 곳으로 이동
          // 아니면 그냥 반복문
          if (maps.containsKey(next)) {
            v[maps.get(next)] = true;
            queue.add(new int[]{maps.get(next), c + 1});
          } else {
            v[next] = true;
            queue.add(new int[]{next, c + 1});
          }
        }
      }
    }

    return 17;
  }
}