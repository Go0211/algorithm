import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int seq = Integer.parseInt(br.readLine());
        StringTokenizer st =
            new StringTokenizer(br.readLine(), " ");
        String str = br.readLine();
        int count = 0;
        
        for(int i = 0; i < seq; i++) {
            if(str.equals(st.nextToken())) {
                count++;
            }
        }
        
        System.out.println(count);
    }
}