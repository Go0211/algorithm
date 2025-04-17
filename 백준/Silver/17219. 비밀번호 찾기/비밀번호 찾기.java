import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = 
            new StringTokenizer(br.readLine());
        int inputs = Integer.parseInt(st.nextToken());
        int outputs = Integer.parseInt(st.nextToken());
        Map<String, String> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < inputs; i++) {
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), st.nextToken());
        }
        
        for(int i = 0; i < outputs; i++) {
            sb.append(map.get(br.readLine())).append("\n");
        }
        
        System.out.println(sb);
    }
}