import java.util.*;
import java.io.*;

public class Main {
    static int answer = -1;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = 
            new StringTokenizer(br.readLine());
        int seq = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());
        int[] arr = new int[seq];
        boolean[] preDP = new boolean[limit + 1];
        boolean[] nextDP = new boolean[limit + 1];
        preDP[start] = true;
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < seq; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int z = 0; z < seq; z++) {
            Arrays.fill(nextDP, false);
            
            for(int i = 0; i < limit + 1; i++) {
                if(preDP[i]) {
                    if(i + arr[z] <= limit) {
                        nextDP[i + arr[z]] = true;
                    }
                    if(i - arr[z] >= 0) {
                        nextDP[i - arr[z]] = true;
                    }
                }
            }
            
            boolean[] temp = nextDP;
            nextDP = preDP;
            preDP = temp;
        }
        
        int answer = -1;
        for(int j = limit; j >= 0; j--) {
            if(preDP[j]) {
                answer = j;
                break;
            }
        }
        
        System.out.println(answer);
    }
}