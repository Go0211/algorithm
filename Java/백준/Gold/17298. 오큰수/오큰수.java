import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int seq = Integer.parseInt(br.readLine());
        StringTokenizer st =
                new StringTokenizer(br.readLine());
        int[] arr = new int[seq];
        int[] results = new int[seq];
        Arrays.fill(results, -1);
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < seq; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < seq; i++) {
            stack.push(i - 1);

            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                results[stack.pop()] = arr[i];
            }
        }

        for (int i : results) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }
}