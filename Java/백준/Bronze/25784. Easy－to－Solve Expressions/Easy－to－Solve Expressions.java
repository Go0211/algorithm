import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
            new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        if((a+b) == c || (a+c) == b || (c+b) == a) {
            System.out.println(1);
        } else if((a*b) == c || (a*c) == b || (c*b) == a) {
            System.out.println(2);
        } else {
            System.out.println(3);
        }
    }
}