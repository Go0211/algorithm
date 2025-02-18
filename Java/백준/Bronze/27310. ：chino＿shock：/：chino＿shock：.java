import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int result = 0;
        
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == ':') {
                result++;
            } else if(c == '_') {
                result += 5;
            }
            result++;
        }
        
        System.out.println(result);
    }
}