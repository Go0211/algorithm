import java.io.*;
import java.util.*;

public class Main {
  static final long[][] FIB_MATRIX = {{1, 1}, {1, 0}};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());

    for (int z = 1; z <= T; z++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int P = Integer.parseInt(st.nextToken());
      int Q = Integer.parseInt(st.nextToken());

      long result = fibMod(P, Q);
      sb.append("Case #")
          .append(z)
          .append(": ")
          .append(result)
          .append("\n");
    }

    System.out.println(sb);
  }

  private static long fibMod(int n, int mod) {
    if (mod == 1) return 0;
    if (n == 0) return 0;
    long[][] result = pow(FIB_MATRIX, n - 1, mod);
    return result[0][0]; // F(n)
  }

  private static long[][] pow(long[][] matrix, int power, int mod) {
    long[][] result = {{1, 0}, {0, 1}}; // identity matrix
    while (power > 0) {
      if ((power & 1) == 1) {
        result = multiply(result, matrix, mod);
      }
      matrix = multiply(matrix, matrix, mod);
      power >>= 1;
    }
    return result;
  }

  private static long[][] multiply(long[][] a, long[][] b, int mod) {
    long[][] result = new long[2][2];
    result[0][0] = (a[0][0] * b[0][0] + a[0][1] * b[1][0]) % mod;
    result[0][1] = (a[0][0] * b[0][1] + a[0][1] * b[1][1]) % mod;
    result[1][0] = (a[1][0] * b[0][0] + a[1][1] * b[1][0]) % mod;
    result[1][1] = (a[1][0] * b[0][1] + a[1][1] * b[1][1]) % mod;
    return result;
  }
}
