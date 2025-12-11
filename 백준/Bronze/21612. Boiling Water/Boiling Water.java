import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int N = 5 * Integer.parseInt(br.readLine()) - 400;
        System.out.println(N);
        System.out.println(N == 100 ? 0 : N > 100 ? -1 : 1);
    }
}