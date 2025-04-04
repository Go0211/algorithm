import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        int seq = Integer.parseInt(br.readLine());
        
        StringTokenizer st =
            new StringTokenizer(br.readLine(), " ");
        int total = seq;
        for(int i = 1; i <= seq; i++) {
            if(i == Integer.parseInt(st.nextToken())) {
                total--;
            }
        }
        
        System.out.println(total);
    }
}