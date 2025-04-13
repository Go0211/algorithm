import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        List<String> l1 = Arrays.asList("social", "history", "language", "literacy");
        List<String> l2 = Arrays.asList("bigdata", "public", "society");
        
        if(l1.contains(br.readLine())) {
            System.out.println("digital humanities");
        } else {
            System.out.println("public bigdata");
        }
    }
}