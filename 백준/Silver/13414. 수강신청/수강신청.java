import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        String str;
        int idx;
        
        Node(String str, int idx) {
            this.str = str;
            this.idx = idx;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = 
            new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int limit = Integer.parseInt(st.nextToken());
        int seq = Integer.parseInt(st.nextToken());
        Set<String> sets = new HashSet<>();
        Map<String, Integer> maps = new HashMap<>();
        PriorityQueue<Node> pq = 
            new PriorityQueue<>((x, y) -> x.idx - y.idx);
        
        for(int i = 0; i < seq; i++) {
            String str = br.readLine();
            sets.add(str);
            maps.put(str, i);
        }
        
        for(String str : sets) {
            pq.offer(new Node(str, maps.get(str)));
        }
        
        while(!pq.isEmpty() && limit > 0) {
            limit--;
            sb.append(pq.poll().str).append("\n");
        }
        
        System.out.print(sb);
    }
}