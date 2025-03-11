import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        int time = Integer.parseInt(br.readLine());
        int count = Integer.parseInt(br.readLine());
        int total = 0;
        
        StringTokenizer st = 
            new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()) {
            total += Integer.parseInt(st.nextToken());
        }
        
        System.out.println(total >= time ? "Padaeng_i Happy" : "Padaeng_i Cry");
    }
}