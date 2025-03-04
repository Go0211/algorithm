import java.util.*;
import java.io.*;

public class Main {
    // K, k(0), P, p(1), N, n(3), B, b(5), R, r(7), Q, q(9)
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        
        for(int i = 0; i < 8; i++) {
            String[] arr = br.readLine().split("");
            
            for(int j = 0; j < 8; j++) {
                switch(arr[j]) {
                    case "P": 
                        result++;
                        break;
                    case "p":
                        result--;
                        break;
                    case "N":
                        result += 3;
                        break;
                    case "n":
                        result -= 3;
                        break;
                    case "B":
                        result += 3;
                        break;
                    case "b":
                        result -= 3;
                        break;
                    case "R":
                        result += 5;
                        break;
                    case "r":
                        result -= 5;
                        break;
                    case "Q":
                        result += 9;
                        break;
                    case "q":
                        result -= 9;
                        break;
                }
            }
        }
        
        System.out.println(result);
    }
}