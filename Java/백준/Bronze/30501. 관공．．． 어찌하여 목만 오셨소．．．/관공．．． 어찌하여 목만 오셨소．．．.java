import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int seq = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < seq; i++) {
            String s = br.readLine();
            
            if(s.contains("S")) {
                System.out.println(s);
                break;
            }
        }
    }
}