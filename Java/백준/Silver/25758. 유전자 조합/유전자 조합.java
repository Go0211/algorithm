import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        // 앞에 List, 뒤에 List
        List<List<Integer>> fl = new ArrayList<>();
        List<List<Integer>> el = new ArrayList<>();
        Set<Character> sets = new HashSet<>();

        for (int i = 0; i < 26; i++) {
            fl.add(new ArrayList<>());
            el.add(new ArrayList<>());
        }

        int seq = Integer.parseInt(br.readLine());
        StringTokenizer st =
                new StringTokenizer(br.readLine());
        for (int i = 0; i < seq; i++) {
            String str = st.nextToken();
            fl.get(str.charAt(0) - 'A').add(i);
            el.get(str.charAt(1) - 'A').add(i);
        }

        for (int z = 0; z < 26; z++) {
            List<Integer> cfl = fl.get(z);

            if (cfl.isEmpty()) {
                continue;
            }

            for (int zz = 0; zz < 26; zz++) {
                List<Integer> cel = el.get(zz);

                if (cel.isEmpty()) {
                    continue;
                }

                // 그럼 앞 list와 뒤 List가 같다면 continue;
                if (cfl.size() == 1 && cel.size() == 1
                        && cfl.containsAll(cel)) {
                    continue;
                }

                sets.add((char) (Math.max(z, zz) + 'A'));
            }
        }

        List<Character> list = new ArrayList<>(sets);
        list.sort((x, y) -> x.compareTo(y));
        System.out.println(sets.size());
        StringBuffer sb = new StringBuffer();
        for (char c : list) {
            sb.append(c).append(" ");
        }

        System.out.println(sb);
    }
}