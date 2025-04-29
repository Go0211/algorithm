import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int seq = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < seq; i++) {
            Set<String> sets = new HashSet<>();
            
            int freq = Integer.parseInt(br.readLine());
            
            for(int j = 0; j < freq; j++) {
                sets.add(br.readLine());
            }
            
            System.out.println(sets.size());
        }
    }
}