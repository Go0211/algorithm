import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> map = new HashMap<>();
        boolean[] isDecimal = new boolean[4_000_001];
        List<Integer> list = new ArrayList<>();
        for(int i = 2; i <= 4_000_000; i++) {
            if(isDecimal[i]) {
                continue;
            }

            list.add(i);
            map.put(i, 1);
            for(int j = i + i; j <= 4_000_000; j += i) {
                isDecimal[j] = true;
            }
        }

        for(int i = 0; i < list.size(); i++) {
            int total = list.get(i);

            for(int j = i + 1; j < list.size(); j++) {
                total += list.get(j);
                if(total > 4_000_000) {
                    break;
                }

                map.put(total, map.getOrDefault(total, 0) + 1);
            }
        }

        int N = Integer.parseInt(br.readLine());
        System.out.println(map.getOrDefault(N, 0));
    }
}