import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        
        sb.append("h");
        
        for(int i = 0; i < (str.length() - 2) * 2; i++) {
            sb.append("e");
        }
        
        sb.append("y");
        
        System.out.println(sb);
    }
}