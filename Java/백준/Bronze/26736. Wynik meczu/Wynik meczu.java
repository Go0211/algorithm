import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int a = 0;
        int b = 0;
        
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == 'A') {
                a++;
            } else {
                b++;
            }
        }
        
        System.out.println(a + " : " + b);
    }
}