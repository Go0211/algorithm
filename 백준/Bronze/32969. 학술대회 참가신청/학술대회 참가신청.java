import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        List<String> l1 = Arrays.asList("social", "history", "language", "literacy");
        List<String> l2 = Arrays.asList("bigdata", "public", "society");
        String str = br.readLine();
        boolean t = true;
        
        for(String s : l1) {
            if(str.contains(s)) {
                t = false;
                break;
            }
        }
        
        if(!t) {
            System.out.println("digital humanities");
        } else {
            System.out.println("public bigdata");
        }
    }
}