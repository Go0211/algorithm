import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int seq = Integer.parseInt(br.readLine());
        long result = 0L;
        for(int i = 1; i <= seq; i++) {
            result += i * i * i;
        }
        
        System.out.println(result);
    }
}