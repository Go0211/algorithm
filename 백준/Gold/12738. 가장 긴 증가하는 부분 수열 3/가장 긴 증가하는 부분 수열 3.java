import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] lis = new int[N];
        
        StringTokenizer st =
            new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int start = 0;
        int end = 1;
        lis[0] = arr[0];
        for(int i = 1; i < N; i++) {
            if(lis[end - 1] < arr[i]) {
                lis[end++] = arr[i];
                continue;
            }
            
            lis[lower(lis, start, end, arr[i])] = arr[i];
        }
        
        System.out.println(end);
    }
    
    static int lower(int[] lis, int start, int end, int target) {
        while(start < end) {
            int mid = start + ((end - start) >>> 1);
            
            if(target > lis[mid]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        
        return start;
    }
}