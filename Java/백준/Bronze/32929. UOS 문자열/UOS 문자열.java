import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        switch(num % 3) {
            case 0 :
                System.out.println("S");
                break;
            case 1 :
                System.out.println("U");
                break;
            case 2 :
                System.out.println("O");
                break;
        }
    }
}