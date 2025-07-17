import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
            new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        int circleLen = N - V + 1;
        
        st = new StringTokenizer(br.readLine(), " ");
        int[] nonCircleArr = new int[N];
        int[] circleArr = new int[circleLen];
        
        for(int i = 0; i < N; i++) {
            nonCircleArr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < circleLen; i++) {
            circleArr[i] = nonCircleArr[i + V - 1];
        }
        
        for(int i = 0; i < M; i++) {
            int input = Integer.parseInt(br.readLine());
            
            if(input < N) {
                sb.append(nonCircleArr[input]).append("\n");
            } else {
                sb.append(circleArr[(input - N) % circleLen]).append("\n");
            }
        }
        
        System.out.println(sb);
    }
}