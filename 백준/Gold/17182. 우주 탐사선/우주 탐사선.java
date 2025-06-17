import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int answer = Integer.MAX_VALUE;

  public static void main(String[] args) throws Exception{
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st =
        new StringTokenizer(br.readLine());
    int len = Integer.parseInt(st.nextToken());
    int startIdx = Integer.parseInt(st.nextToken());
    int[][] arr = new int[len][len];

    for (int i = 0; i < len; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < len; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < len; i++) {
      for (int j = 0; j < len; j++) {
        for (int k = 0; k < len; k++) {
          arr[j][k] = Math.min(arr[j][k], arr[i][k] + arr[j][i]);
        }
      }
    }

    dfs(arr, startIdx, 0,0, new boolean[len], len);

    System.out.println(answer);
  }

  private static void dfs(int[][] arr, int startIdx, int total, int count, boolean[] v, int len) {
    if (count == len) {
      answer = Math.min(total, answer);
      return;
    }

    if (total >= answer) {
      return;
    }

    for (int i = 0; i < len; i++) {
      if (!v[i]) {
        v[i] = true;
        dfs(arr, i, total + arr[startIdx][i], count + 1, v, len);
        v[i] = false;
      }
    }
  }
}