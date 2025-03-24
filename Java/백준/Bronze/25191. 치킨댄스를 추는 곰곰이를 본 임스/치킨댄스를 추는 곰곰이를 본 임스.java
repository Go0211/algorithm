import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        int chicken = Integer.parseInt(br.readLine());
        StringTokenizer st = 
            new StringTokenizer(br.readLine(), " ");
        int cock = Integer.parseInt(st.nextToken());
        int beer = Integer.parseInt(st.nextToken());
        int total = 0;
        
        while(chicken > 0) {
            chicken--;
            if(cock >= 2) {
                cock-=2;
                total++;
                continue;
            }
            
            if(beer >= 1) {
                total++;
                beer--;
                continue;
            }
        }
        
        System.out.println(total);
    }
}