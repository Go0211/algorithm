import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("");
        ArrayDeque<String> queue = new ArrayDeque<>();
        boolean isLaser = false;
        int total = 0;
        
        // ( 면 queue에 push
        // ) 면 queue.peek값 check
        //     ( 면 queue의 size만큼 +
        //     ) 면 queue에서 pop & + 1
        // 
        for(String s : arr) {
            if(s.equals(")")) {
                queue.pop();
                if(!isLaser) {
                    total += queue.size();
                    isLaser = true;
                } else {
                    total++;
                }
                
                continue;
            } 
            
            queue.push("(");
            isLaser = false;
        }
        
        System.out.println(total);
    }
}