import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
                new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] up = new int[H];
        int[] down = new int[H];

        int min = Integer.MAX_VALUE;
        int count = 0;

        for(int i = 0; i < N; i++) {
            if(i % 2 == 0) {
                up[Integer.parseInt(br.readLine()) - 1]++;
            } else {
                down[Integer.parseInt(br.readLine()) - 1]++;
            }
        }

        for(int i = H - 1; i > 0; i--) {
            up[i - 1] += up[i];
            down[i - 1] += down[i];
        }

        for(int i = 0; i < H; i++) {
            int value = up[i] + down[H - i - 1];

            if(min > value) {
                min = value;
                count = 1;
            } else if(min == value) {
                count++;
            }
        }

        System.out.println(min + " " + count);
    }
}