import java.io.*;
import java.util.*;

public class Main {
    private static class Node{
        int start, end;
        Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int seq = Integer.parseInt(br.readLine());
        int answer = 0;
        PriorityQueue<Integer> pq = 
            new PriorityQueue<>((x, y) -> x - y);

        Node[] arr = new Node[seq];
        boolean[] v = new boolean[seq];
        for (int z = 0; z < seq; z++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[z] = new Node(start, end);
        }

        Arrays.sort(arr, (x, y) -> x.start - y.start == 0 ?
                x.end - y.end : x.start - y.start);

        pq.add(arr[0].end);
        
        next:
        for (int i = 1; i < seq; i++) {
            if(pq.peek() <= arr[i].start) {
                pq.poll();
            }
                
            pq.offer(arr[i].end);
        }

        System.out.println(pq.size());
    }
}
