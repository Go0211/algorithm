import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
            new StringTokenizer(br.readLine());
        int[] arr = new int[3];
        for(int i = 0; i < 3; i++) {
            arr[Integer.parseInt(st.nextToken())]++;
        }
        
        System.out.println(arr[1] > arr[2] ? "1" : "2");
    }
}