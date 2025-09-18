import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();

        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            StringTokenizer st =
                    new StringTokenizer(br.readLine(), " ");

            if(st.nextToken().equals("1")) {
                int left = Integer.parseInt(st.nextToken()) - 1;
                int right = left + 1;
                int decibel = Integer.parseInt(st.nextToken());

                leftMoveAndStrengthen(arr, left, decibel);
                rightMoveAndStrengthen(arr, right, decibel);
            } else {
                sb.append(arr[Integer.parseInt(st.nextToken())-1])
                        .append("\n");
            }
        }

        System.out.println(sb);
    }

    static void leftMoveAndStrengthen(long[] arr, int left, long decibel) {
        for(int i = left; i >= 0; i--) {
            if(decibel <= 0) {
                return;
            }

            long temp = decibel - arr[i];

            if(temp >= 0) {
                arr[i] *= 2;
            } else {
                arr[i] += decibel;
            }

            decibel = temp;
        }
    }
    static void rightMoveAndStrengthen(long[] arr, int right, long decibel) {
        for(int i = right; i < arr.length; i++) {
            if(decibel <= 0) {
                return;
            }

            long temp = decibel - arr[i];

            if(temp >= 0) {
                arr[i] *= 2;
            } else {
                arr[i] += decibel;
            }

            decibel = temp;
        }
    }
}