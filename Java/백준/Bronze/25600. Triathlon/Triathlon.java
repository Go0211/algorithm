import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        int seq = Integer.parseInt(br.readLine());
        int result = 0;
        
        for(int i = 0; i < seq; i++) {       
            StringTokenizer st = 
                new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            
            int value = a * (d + g);
            if (a == (d + g)) {
                value *= 2;
            }
            
            result = Math.max(result, value);
        }
        
        System.out.println(result);
    }
}