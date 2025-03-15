import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int seq = Integer.parseInt(br.readLine());
        
        for(int z = 0; z < seq; z++) {
            StringTokenizer st =
                new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            for(int i = 1; i <= b; i++) {
                if(i % 4 == 0) {
                    a++;
                }
                if(i % 7 == 0) {
                    a--;
                }
            }
            
            System.out.println(a);
        }
    }
}