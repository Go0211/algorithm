import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        int seq = Integer.parseInt(br.readLine());
        int[] arr = new int[seq + 1];
        int result = 0;
        for(int i = 1; i <= seq; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        seq = Integer.parseInt(br.readLine());
        for(int i = 0; i < seq; i++) {
            result += arr[Integer.parseInt(br.readLine())];
        }
        
        System.out.println(result);
    }
}