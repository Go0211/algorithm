import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while(true) {
            int num = Integer.parseInt(br.readLine());
            
            if(num == 0) {
                break;
            }
            
            for(int i = 1; i <= num; i++) {
                for(int j = 0; j < i; j++) {
                    sb.append("*");
                }
                sb.append("\n");
            }
        }
        
        System.out.println(sb);
    }
}