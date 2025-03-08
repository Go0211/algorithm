import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        int seq = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < seq; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num % 2 == 0) {
                System.out.println(num +" is even");
            } else {
                System.out.println(num +" is odd");
            }
        }
    }
}