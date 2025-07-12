import java.io.*;
import java.util.*;

public class Main {
    static final long MOD = 1L << 32;

    public static void main(String[] args) throws IOException {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] v = sieve(n);
        long answer = 1;

        for (int p = 2; p <= n; p++) {
            if (!v[p]) continue;

            long power = p;
            while (power * p <= n) {
                power *= p;
            }
            answer = (answer * power) % MOD;
        }

        System.out.println(answer);
    }

    // 에라토스테네스의 체
    private static boolean[] sieve(int n) {
        boolean[] v = new boolean[n + 1];
        v[0] = v[1] = true;
        for (int i = 2; i * i <= n; i++) {
            if (!v[i]) {
                for (int j = i * i; j <= n; j += i) {
                    v[j] = true;
                }
            }
        }

        // 소수인 것만 false로 남기기
        for (int i = 0; i <= n; i++) {
            v[i] = !v[i];
        }
        return v;
    }
}
