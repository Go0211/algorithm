import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static int[][] A;
  static long outSand = 0;
  static final int[][] DIR = {{0,-1},{1,0},{0,1},{-1,0}};

  static final int[][] SY = {
      {-1, 1, -1,  1, -2,  2, -1,  1,  0},
      {-1,-1,  0,  0,  0,  0,  1,  1,  2},
      {-1, 1, -1,  1, -2,  2, -1,  1,  0},
      { 1, 1,  0,  0,  0,  0, -1, -1, -2}
  };
  static final int[][] SX = {
      { 1, 1,  0,  0,  0,  0, -1, -1, -2},
      {-1, 1, -1,  1, -2,  2, -1,  1,  0},
      {-1,-1,  0,  0,  0,  0,  1,  1,  2},
      {-1, 1, -1,  1, -2,  2, -1,  1,  0}
  };
  
  static int[] P = {1,1,7,7,2,2,10,10,5};
  
  static int[][] ALPHA = {
      {0, -1},
      {1,  0},
      {0,  1},
      {-1, 0}
  };

  static boolean in(int y, int x) {
    return 0 <= y && y < N && 0 <= x && x < N;
  }

  static void spread(int y, int x, int d) {
    int sand = A[y][x];
    if (sand == 0) return;

    int sum = 0;
    for (int k = 0; k < 9; k++) {
      int ny = y + SY[d][k];
      int nx = x + SX[d][k];
      int give = sand * P[k] / 100; // 바닥 연산
      sum += give;
      if (in(ny, nx)) A[ny][nx] += give;
      else outSand += give;
    }
    
    int ay = y + ALPHA[d][0];
    int ax = x + ALPHA[d][1];
    int alpha = sand - sum;
    if (in(ay, ax)) A[ay][ax] += alpha;
    else outSand += alpha;

    A[y][x] = 0;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    A = new int[N][N];
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) A[i][j] = Integer.parseInt(st.nextToken());
    }

    int y = N/2, x = N/2; 
    int len = 1;
    int d = 0;

    while (true) {
      for (int rep = 0; rep < 2; rep++) {
        for (int s = 0; s < len; s++) {
          int ny = y + DIR[d][0];
          int nx = x + DIR[d][1];
          spread(ny, nx, d);
          y = ny; x = nx;
          if (y == 0 && x == 0) {
            System.out.println(outSand);
            return;
          }
        }
        d = (d + 1) % 4;
      }
      len++;
    }
  }
}
