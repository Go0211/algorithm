import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int seq = Integer.parseInt(br.readLine());
        StringTokenizer st =
            new StringTokenizer(br.readLine(), " ");
        int result = (seq - 1) * 8;
        while(st.hasMoreTokens()) {
            result += Integer.parseInt(st.nextToken());
        }
        
        System.out.println((result / 24) + " " + (result % 24));
    }
}