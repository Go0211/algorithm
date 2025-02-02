import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken()) / 2;
        int b = Integer.parseInt(st.nextToken()) / 2;
        
        System.out.println(Math.min(a, b));
    }
}