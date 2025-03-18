import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        int seq = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        switch(seq) {
            case 1:
                sb.append(2024).append(" ").append(8);
                break;
            case 2:
                sb.append(2025).append(" ").append(3);
                break;
            case 3:
                sb.append(2025).append(" ").append(10);
                break;
            case 4:
                sb.append(2026).append(" ").append(5);
                break;
            case 5:
                sb.append(2026).append(" ").append(12);
                break;
        }
        
        System.out.println(sb);
    }
}