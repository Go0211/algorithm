import java.io.*;
import java.util.*;
 
public class Main { 
    public static void main(String[] args) throws Exception {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
 
        for(int z = 0; z < N; z++) {
            int G = Integer.parseInt(br.readLine());
            int[] arr = new int[G];                 
            for(int i = 0; i < G; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            
            int m = 0;
            while(true) {
                m++;
                boolean isTrue = true;
                ArrayList<Integer> modList = new ArrayList<>();
                for(int i = 0; i < G; i++) {
                    if(modList.contains(arr[i] % m)) {
                        isTrue = false;
                        break;
                    }
                    modList.add(arr[i] % m);
                }
                if(isTrue == true) {
                    System.out.println(m);
                    break;
                }
            }
        }
    }
 
}