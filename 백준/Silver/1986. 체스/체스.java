import java.io.*;
import java.util.*;

public class Main {
  static int[][] knightDirs =
      {{-2, 1},{-2, -1},{-1, 2},{-1, -2},{1, 2},{1, -2},{2, 1},{2, -1}};
  static int[][] queenDirs =
      {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {-1, 1}, {-1, -1}, {1, 1}, {1, -1}};

  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st =
        new StringTokenizer(br.readLine(), " ");
    int row = Integer.parseInt(st.nextToken());
    int col = Integer.parseInt(st.nextToken());
    int[][] arr = new int[row][col];

    List<int[]> knightList = new ArrayList<>();
    List<int[]> queenList = new ArrayList<>();
    int answer = 0;

    st = new StringTokenizer(br.readLine(), " ");
    int seq = Integer.parseInt(st.nextToken());
    for(int i = 0; i < seq; i++) {
      int[] a =
          new int[]{Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1};
      arr[a[0]][a[1]] = 1;
      queenList.add(a);
    }
    st = new StringTokenizer(br.readLine(), " ");
    seq = Integer.parseInt(st.nextToken());
    for(int i = 0; i < seq; i++) {
      int[] a =
          new int[]{Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1};
      arr[a[0]][a[1]] = 1;
      knightList.add(a);
    }
    st = new StringTokenizer(br.readLine(), " ");
    seq = Integer.parseInt(st.nextToken());
    for(int i = 0; i < seq; i++) {
      arr[Integer.parseInt(st.nextToken()) - 1]
          [Integer.parseInt(st.nextToken()) - 1] = 1;
    }


    for(int[] yxArr : queenList) {
      queenMove(arr, yxArr[0], yxArr[1], row, col);
    }
    for(int[] yxArr : knightList) {
      knightMove(arr, yxArr[0], yxArr[1], row, col);
    }

    for(int i = 0; i < row; i++) {
      for(int j = 0; j < col; j++) {
        answer += arr[i][j] == 0 ? 1 : 0;
      }
    }

    System.out.println(answer);
  }

  static void knightMove(int[][] arr, int y, int x, int row, int col) {
    for(int[] dir : knightDirs) {
      int ny = y + dir[0];
      int nx = x + dir[1];

      if(ny >= 0 && ny < row
          && nx >= 0 && nx < col
          && arr[ny][nx] != 1) {
        arr[ny][nx] = 2;
      }
    }
  }
  static void queenMove(int[][] arr, int y, int x, int row, int col) {
    for(int[] dir : queenDirs) {
      int ny = y + dir[0];
      int nx = x + dir[1];

      while(ny >= 0 && ny < row
          && nx >= 0 && nx < col
          && arr[ny][nx] != 1) {
        arr[ny][nx] = 2;

        ny = ny + dir[0];
        nx = nx + dir[1];
      }
    }
  }
}