import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        int seq = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int z = 0; z < seq; z++) {
            int num = Integer.parseInt(br.readLine());
            
            while(true) {
                if(num - 5 < 0) {
                    break;
                }
                sb.append("++++ ");
                num -= 5;
            }
            
            for(int i = 0; i < num; i++) {
                sb.append("|");
            }
            
            sb.append("\n");
        }
        
        System.out.println(sb);
    }
}