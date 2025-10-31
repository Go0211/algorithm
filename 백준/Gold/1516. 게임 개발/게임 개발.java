import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N];
        int[] times = new int[N];
        List<List<Integer>> list = new ArrayList<>();
        int[] befores = new int[N];

        for(int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < N; i++) {
            StringTokenizer st =
                    new StringTokenizer(br.readLine(), " ");
            int time = Integer.parseInt(st.nextToken());
            times[i] = time;
            dp[i] = time;

            while(st.hasMoreTokens()) {
                int index = Integer.parseInt(st.nextToken());

                if(index == -1) {
                    break;
                }

                list.get(index - 1).add(i);
                befores[i]++;
            }
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < N; i++) {
            if(befores[i] == 0) {
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()) {
            int idx = queue.poll();

            for(int i : list.get(idx)) {
                if(dp[i] < dp[idx] + times[i]) {
                    dp[i] = dp[idx] + times[i];
                }

                befores[i]--;

                if(befores[i] == 0) {
                    queue.offer(i);
                }
            }
        }

        for(int value : dp) {
            sb.append(value).append("\n");
        }

        System.out.println(sb);
    }
}