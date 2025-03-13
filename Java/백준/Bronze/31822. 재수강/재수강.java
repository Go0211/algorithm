import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().substring(0, 5);
        int seq = Integer.parseInt(br.readLine());
        int result = 0;
        
        for(int i = 0; i < seq; i++) {
            String input = br.readLine().substring(0, 5);
            
            result += str.equals(input) ? 1 : 0;
        }
        
        System.out.println(result);
    }
}
