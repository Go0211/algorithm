import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(--T >= 0) {
            StringTokenizer st =
                    new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            int[] dp = new int[N];
            int[] counts = new int[N];
            List<List<Integer>> list = new ArrayList<>();
            for(int i = 0; i < N; i++) {
                list.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                dp[i] = arr[i];
            }

            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int prev = Integer.parseInt(st.nextToken()) - 1;
                int next = Integer.parseInt(st.nextToken()) - 1;

                list.get(prev).add(next);
                counts[next]++;
            }

            int target = Integer.parseInt(br.readLine()) - 1;
            ArrayDeque<Integer> queue = new ArrayDeque<>();

            for(int i = 0; i < N; i++) {
                if(counts[i] == 0) {
                    queue.offer(i);
                }
            }

            while(!queue.isEmpty()) {
                int idx = queue.poll();

                for(int i : list.get(idx)) {
                    if(dp[i] < dp[idx] + arr[i]) {
                        dp[i] = dp[idx] + arr[i];
                    }

                    counts[i]--;
                    
                    if(i == target) {
                        continue;
                    }

                    if(counts[i] == 0) {
                        queue.offer(i);
                    }
                }
            }

            sb.append(dp[target]).append("\n");
        }

        System.out.println(sb);
    }
}