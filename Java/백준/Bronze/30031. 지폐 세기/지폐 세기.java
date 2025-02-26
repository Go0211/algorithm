import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int seq = Integer.parseInt(br.readLine());
        int total = 0;
        
        for(int i = 0; i < seq; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            switch(a) {
                case 136 :
                    total += 1000;
                    break;
                case 142 :
                    total += 5000;
                    break;
                case 148 :
                    total += 10000;
                    break;
                case 154 :
                    total += 50000;
                    break;
            }
        } 
        
        System.out.println(total);
    }
}