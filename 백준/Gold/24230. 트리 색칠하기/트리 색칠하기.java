import java.util.*;
import java.io.*;

public class Main {
  static int answer = 0;

  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];
    StringTokenizer st =
        new StringTokenizer(br.readLine(), " ");
    for(int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    List<Integer>[] la = new ArrayList[N];

    for(int i = 0; i < N; i++) {
      la[i] = new ArrayList<>();
    }

    for(int i = 0; i < N - 1; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;
      la[a].add(b);
      la[b].add(a);
    }

    boolean[] v = new boolean[N];
    v[0] = true;
    dfs(la, arr, 0, 0, v);

    System.out.println(answer);
  }

  static void dfs(List<Integer>[] la, int[] arr, int index, int color, boolean[] v) {
    if(arr[index] != color) {
      answer++;
      color = arr[index];
    }

    List<Integer> list = la[index];
    for(int idx : list) {
      if(!v[idx]) {
        v[idx] = true;
        dfs(la, arr, idx, color, v);
      }
    }
  }
}