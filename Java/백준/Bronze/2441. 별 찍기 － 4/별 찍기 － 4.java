import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        int seq = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < seq; i++) {
            for(int j = 0; j < i; j++) {
                sb.append(" ");
            }
            for(int j = i; j < seq; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        
        System.out.println(sb);
    }
}