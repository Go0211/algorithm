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
                new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            int total = Integer.parseInt(st.nextToken());
            
            while(len <= total) {
                total -= len;
            }
            
            result += total;
        }
        
        System.out.println(result);
    }
}