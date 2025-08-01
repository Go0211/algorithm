import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static class Node {
    int[][] arr;
    int count;

    Node(int[][] arr, int count) {
      this.arr = arr;
      this.count = count;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st =
        new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int[][] notebook = new int[N][M];
    int answer = 0;

    //1. 그대로 GET
    for(int z = 0; z < K; z++) {
      st = new StringTokenizer(br.readLine(), " ");
      int row = Integer.parseInt(st.nextToken());
      int col = Integer.parseInt(st.nextToken());
      int[][] arr = new int[row][col];
      int count = 0;
      int sequence = 0;

      for(int i = 0; i < row; i++) {
        st = new StringTokenizer(br.readLine(), " ");
        for(int j = 0; j < col; j++) {
          int num = Integer.parseInt(st.nextToken());
          arr[i][j] = num;

          if(num != 0) {
            count++;
          }
        }
      }

      //4. 3번 돌려도 안되면 REMOVE
      while(sequence < 4) {
        //2. 붙일 수 있는 곳 FIND, 맨왼맨위 우선
        if(findAttach(notebook, arr, N, M, arr.length, arr[0].length)) {
          answer += count;
          break;
        }
        //3. 없다면 90도 회전 후, 다시 FIND
        arr = right90(arr);
        sequence++;
      }
    }

    System.out.println(answer);
  }

  static boolean findAttach(int[][] notebook, int[][] arr, int N, int M, int NN, int MM) {
    for (int y = 0; y <= N - NN; y++) {
      for (int x = 0; x <= M - MM; x++) {

        boolean canAttach = true;

        for (int i = 0; i < NN; i++) {
          for (int j = 0; j < MM; j++) {
            if (arr[i][j] == 1 && notebook[y + i][x + j] == 1) {
              canAttach = false;
              break;
            }
          }
          if (!canAttach) {
            break;
          }
        }

        if (canAttach) {
          for (int i = 0; i < NN; i++) {
            for (int j = 0; j < MM; j++) {
              if (arr[i][j] == 1) {
                notebook[y + i][x + j] = 1;
              }
            }
          }
          return true;
        }
      }
    }

    return false;
  }

  static int[][] right90(int[][] arr) {
    int n = arr.length;
    int m = arr[0].length;
    int[][] rotated = new int[m][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        rotated[j][n - i - 1] = arr[i][j];
      }
    }

    return rotated;
  }
}