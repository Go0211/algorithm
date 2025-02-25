import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int seq = Integer.parseInt(br.readLine());
        StringTokenizer st =
            new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < seq; i++) {
            int num = Integer.parseInt(st.nextToken());
            
            if(num >= 300) {
                sb.append(1).append(" ");
            } else if(num >= 275) {
                sb.append(2).append(" ");
            } else if(num >= 250) {
                sb.append(3).append(" ");
            } else {
                sb.append(4).append(" ");
            }
        }
        
        System.out.println(sb);
    }
}