import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        int seq = Integer.parseInt(br.readLine());
        int result = 0;
        
        while(seq-- != 0) {
            result += Integer.parseInt(br.readLine());
        }
        
        System.out.println(result);
    }
} 