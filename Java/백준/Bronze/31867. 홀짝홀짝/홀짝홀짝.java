import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int a = 0;
        int b = 0;
        
        for(int i = 0; i < len; i++) {
            int num = str.charAt(i) - '0';
            
            if(num % 2 == 0) {
                a++;
            } else {
                b++;
            }
         }
        
        if(a == b) {
            System.out.println(-1);
        } else if(a > b) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }
    }
}