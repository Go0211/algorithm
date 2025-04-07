import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
            new StringTokenizer(br.readLine(), " ");
        int count = Integer.parseInt(st.nextToken());
        String str = st.nextToken();
        int score = 0;
        
        switch(str) {
            case "miss":
                break;
            case "bad":
                score = 200 * count;
                break;
            case "cool":
                score = 400 * count;
                break;
            case "great":
                score = 600 * count;
                break;
            case "perfect":
                score = 1000 * count;
                break;
        }
        
        System.out.println(score);
    }
}