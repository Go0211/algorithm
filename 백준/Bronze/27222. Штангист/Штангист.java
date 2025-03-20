import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int total = 0;
        int[] arr = new int[a];
        StringTokenizer st =
            new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < a; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 0; i < a; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int aa = Integer.parseInt(st.nextToken());
            int bb = Integer.parseInt(st.nextToken());
            
            if(arr[i] == 1 && aa < bb) {
                total += bb - aa;
            }
        }
        
        System.out.println(total);
    }
}