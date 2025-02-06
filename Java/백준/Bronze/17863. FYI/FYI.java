import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        System.out.print(str.charAt(0) == '5' && str.charAt(1) == '5' && str.charAt(2) == '5' ? 
                         "YES" : "NO");
    }
}