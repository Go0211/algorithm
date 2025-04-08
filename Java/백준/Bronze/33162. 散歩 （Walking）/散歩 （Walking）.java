import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int seq = Integer.parseInt(br.readLine());
        int total = 0;
        
        for(int i = 0; i < seq; i++) {
            total += i % 2 == 0 ? 3 : -2;
        }
        
        System.out.println(total);
    }
}