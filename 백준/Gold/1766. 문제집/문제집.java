import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
                new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] counts = new int[N];
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int before = Integer.parseInt(st.nextToken()) - 1;
            int after = Integer.parseInt(st.nextToken()) - 1;

            list.get(before).add(after);
            counts[after]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            if(counts[i] == 0) {
                pq.offer(i);
            }
        }

        while(!pq.isEmpty()) {
            int idx = pq.poll();

            sb.append(idx + 1).append(" ");

            for(int i : list.get(idx)) {
                counts[i]--;

                if(counts[i] == 0) {
                    pq.offer(i);
                }
            }
        }

        System.out.println(sb);
    }
}