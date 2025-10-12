import java.io.*;
import java.util.*;

public class Main {
  static int[][] dirs = {{0, 1},{0, -1},{-1, 0},{1, 0}};

  static class AirMachine {
    int y1, x1, y2, x2;
    boolean isNotNull;

    AirMachine() {
      this.isNotNull = false;
    }

    AirMachine(int y1, int x1, int y2, int x2) {
      this.y1 = y1;
      this.x1 = x1;
      this.y2 = y2;
      this.x2 = x2;
      this.isNotNull = true;
    }

    boolean isMachine(int y, int x) {
      return (y == y1 && x == x1) || (y == y2 && x == x2);
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st =
        new StringTokenizer(br.readLine(), " ");
    int R = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());
    int T = Integer.parseInt(st.nextToken());
    int[][] arr = new int[R][C];
    AirMachine airMachine = new AirMachine();

    for(int i = 0; i < R; i++) {
      st = new StringTokenizer(br.readLine(), " ");

      for(int j = 0; j < C; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());

        if(arr[i][j] == -1 && !airMachine.isNotNull) {
          airMachine = new AirMachine(i, j, i + 1, j);
        }
      }
    }

    while(T > 0) {
      T--;

      int[][] tempArr = new int[R][C];

      for(int i = 0; i < R; i++) {
        for(int j = 0; j < C; j++) {
          if(arr[i][j] > 0) {
            divide(arr, tempArr, airMachine, i, j, R, C);
          }
        }
      }

      add(arr, tempArr, airMachine, R, C);
      reverseAir(airMachine.y1, airMachine.x1, arr, R, C);
      directAir(airMachine.y2, airMachine.x2, arr, R, C);
    }

    int answer = 0;
    for(int[] a : arr) {
      for(int b : a) {
        answer += b;
      }
    }

    System.out.println(answer);
  }

  // 상하좌우로 먼지를 분사하는 메소드
  static void divide(int[][] arr, int[][] tempArr,
      AirMachine airMachine,
      int y, int x, int R, int C) {
    // 사방으로 분사
    for(int[] dir : dirs) {
      int ny = y + dir[0];
      int nx = x + dir[1];

      if(ny >= 0 && ny < R && nx >= 0 && nx < C && !airMachine.isMachine(ny, nx)) {
        tempArr[ny][nx] += arr[y][x] / 5;
        tempArr[y][x] -= arr[y][x] / 5;
      }
    }
  }

  // 분사한 모래와 현재모래들 합치기
  static void add(int[][] arr, int[][] tempArr, AirMachine airMachine, int R, int C) {
    for(int i = 0; i < R; i++) {
      for(int j = 0; j < C; j++) {
        if(airMachine.isMachine(i, j)) {
          continue;
        }

        arr[i][j] += tempArr[i][j];

        if(arr[i][j] < 0) {
          arr[i][j] = 0;
        }
      }
    }
  }

  // 공기청정기 역시계바람으로 이동시키기
  static void reverseAir(int y, int x, int[][] arr, int R, int C) {
    int ty = y;
    int tx = x;
    arr[ty - 1][tx] = 0;

    // 위 -> 아래
    while(ty > 0) {
      arr[ty][tx] = arr[ty - 1][tx];
      ty--;
    }
    // 우 -> 좌
    while(tx < C - 1) {
      arr[ty][tx] = arr[ty][tx + 1];
      tx++;
    }
    // 아래 -> 위
    while(ty < y) {
      arr[ty][tx] = arr[ty + 1][tx];
      ty++;
    }
    // 좌 -> 우
    while(tx > x) {
      arr[ty][tx] = arr[ty][tx - 1];
      tx--;
    }
  }

  // 공기청정기 시계바람으로 이동시키기
  static void directAir(int y, int x, int[][] arr, int R, int C) {
    int ty = y;
    int tx = x;
    arr[ty + 1][tx] = 0;

    // 아래 -> 위
    while(ty < R - 1) {
      arr[ty][tx] = arr[ty + 1][tx];
      ty++;
    }
    // 우 -> 좌
    while(tx < C - 1) {
      arr[ty][tx] = arr[ty][tx + 1];
      tx++;
    }
    // 위 -> 아래
    while(ty > y) {
      arr[ty][tx] = arr[ty - 1][tx];
      ty--;
    }
    // 좌 -> 우
    while(tx > x) {
      arr[ty][tx] = arr[ty][tx - 1];
      tx--;
    }
  }
}