import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        String title;
        int limit;
        
        Node(String title, int limit) {
            this.title = title;
            this.limit = limit;
        }
    }
    
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
            new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Node> list = new ArrayList<>();
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            list.add(new Node(st.nextToken(), Integer.parseInt(st.nextToken())));
        }
        
        for(int i = 0; i < M; i++) {
            sb.append(list.get(lower(list, Integer.parseInt(br.readLine()))).title)
                .append("\n");
        }
        
        System.out.println(sb);
    }
    
    static int lower(List<Node> list, int target) {
        int start = 0;
        int end = list.size();
        
        while(start < end) {
            int mid = start + ((end - start) >>> 1);
            
            if(list.get(mid).limit < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        
        return start;
    }
}