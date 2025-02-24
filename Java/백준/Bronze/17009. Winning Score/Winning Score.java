import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine()) * 3 +
            Integer.parseInt(br.readLine()) * 2 +
            Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine()) * 3 +
            Integer.parseInt(br.readLine()) * 2 +
            Integer.parseInt(br.readLine());
        
        if(a == b) {
            System.out.println("T");
        } else if(a > b) {
            System.out.println("A");
        } else {
            System.out.println("B");
        }
    }
}