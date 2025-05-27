import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int seq = Integer.parseInt(br.readLine());
        
        int answer = 0;
        for(int z = 0; z < seq; z++) {
            String s = br.readLine();
            int len = s.length();
            
            next:
            for(int i = 0; i < len; i++) {
                if(s.charAt(i) == str.charAt(0)) {
                    for(int j = 1; j < str.length(); j++) {
                        int idx = (i + j) % len;  
                        
                        if(s.charAt(idx) != str.charAt(j)) {
                            continue next;
                        }
                    }
                    
                    answer ++;
                    break;
                }
            }
        }
        
        System.out.println(answer);
    }
}