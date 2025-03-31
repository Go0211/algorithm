import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int seq = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < seq; i++) {
            StringTokenizer st =
                new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            
            int total = 0;
            for(int j = 0; j < N; j++) {
                total += A + D * (j);
            }
            sb.append(total).append("\n");
        }
        
        System.out.println(sb);
    }
}