import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
            new StringTokenizer(br.readLine(), " ");
        int bread = Integer.parseInt(st.nextToken());
        int stack = Integer.parseInt(st.nextToken());
        int total = 0;
        
        while(bread >= 2 && stack >= 1) {
            bread-=2;
            stack--;
            total++;
        }
        
        System.out.println(total);
    }
}