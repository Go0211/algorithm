import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int seq = Integer.parseInt(br.readLine());
        int total = 0;
        
        for(int i = 0; i < seq; i++) {
            if(Integer.parseInt(br.readLine().replace("D-", "")) <= 90) {
                total++;
            }
        }
        
        System.out.println(total);
    }
}