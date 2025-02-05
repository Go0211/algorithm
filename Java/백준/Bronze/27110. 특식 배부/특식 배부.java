import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        int max = Integer.parseInt(br.readLine());
        
        StringTokenizer st =
            new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        int result = (int)(Math.min(a, max) + Math.min(b, max) + Math.min(c, max));
        
        System.out.println(result);
    }
}