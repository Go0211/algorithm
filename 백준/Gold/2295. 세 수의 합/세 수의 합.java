import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        long answer = 0;

        Arrays.sort(arr);

        for(int x = 0; x < N; x++) {
            long num1 = arr[x];
            for(int y = x; y < N; y++) {
                long num2 = arr[y];
                for(int z = y; z < N; z++) {
                    long sum = num1 + num2 + arr[z];

                    if (answer > sum) {
                        continue;
                    }

                    int index = Arrays.binarySearch(arr, sum);

                    if(index >= 0) {
                        answer = Math.max(arr[index], answer);
                    }
                }
            }
        }

        System.out.println(answer);
    }
}