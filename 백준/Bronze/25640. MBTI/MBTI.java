import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        int seq = Integer.parseInt(br.readLine());
        int result = 0;
        for(int i = 0; i < seq; i++) {
            if(br.readLine().equals(a)) {
                result++;
            }
        }
        
        System.out.println(result);
    }
}