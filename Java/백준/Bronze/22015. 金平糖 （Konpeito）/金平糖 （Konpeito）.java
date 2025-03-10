import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
            new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        int max = Math.max(a, Math.max(b, c));
        
        if(max == a) {
            System.out.println(a - b + a - c);
        } else if(max == b) {
            System.out.println(b - a + b - c);
        } else {
            System.out.println(c - b + c - a);
        }
    }
}