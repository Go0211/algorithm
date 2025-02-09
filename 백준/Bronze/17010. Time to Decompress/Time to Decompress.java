import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        int seq = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < seq; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int freq = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            
            for(int j = 0; j < freq; j++) {
                sb.append(str);
            }
            sb.append("\n");
        }
        
        System.out.println(sb);
    }
}