import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        String str1 = br.readLine();
        String str2 = br.readLine();
        int total = 0;
        
        for(int i = 0; i < len; i++) {
            if(str1.charAt(i) != str2.charAt(i)) {
                total++;
            }
        }
        
        System.out.println(total);
    }
}