import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
            new StringTokenizer(br.readLine());
        
        int apple = Integer.parseInt(st.nextToken()) * 7;
        int peer = Integer.parseInt(st.nextToken()) * 13;
        
        if(apple == peer) {
            System.out.println("lika");
        } else if(apple > peer) {
            System.out.println("Axel");
        } else {
            System.out.println("Petra");
        }
    }
}