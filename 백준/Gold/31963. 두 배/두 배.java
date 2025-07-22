import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        int answer = 0;

        StringTokenizer st =
                new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        for(int i = 1; i < N; i++) {
            long front = arr[i - 1];
            long target = arr[i];

            while(front > target) {
                target *= 2;
                answer++;
            }

            arr[i] = target;
        }

        System.out.println(answer);
    }
}