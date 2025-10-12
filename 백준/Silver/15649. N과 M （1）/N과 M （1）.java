import java.io.*;
import java.util.*;

public class Main{
    static int N, R;
    static int[] a, b;
    static boolean[] v;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = 
            new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        a = new int[N];
        for(int i = 0; i < N; i++) {
            a[i] = i + 1;
        }
        b = new int[R];
        v = new boolean[N];
        
        perm(0);
        
        System.out.println(sb);
    }
    
    static void perm(int cnt) {
        if(cnt == R) {
            for(int ab : b) {
                sb.append(ab + " ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 0; i < N; i++) {
            if(v[i])
                continue;
            v[i] = true;
            b[cnt] = a[i];
            perm(cnt + 1);
            v[i] = false;
        }
    }
}