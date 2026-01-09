import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        long A = Long.parseLong(br.readLine());
        long B = Long.parseLong(br.readLine());
        long C = Long.parseLong(br.readLine());
        
        int[] arr = new int[10];
        
        String str = String.valueOf(A * B * C);
        
        for(int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - '0';
            
            arr[num]++;
        }
        
        for(int i : arr) {
            System.out.println(i);
        }
    }
}