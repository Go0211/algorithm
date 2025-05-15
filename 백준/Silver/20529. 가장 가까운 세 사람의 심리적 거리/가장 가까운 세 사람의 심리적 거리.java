import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int freq = Integer.parseInt(br.readLine());

    next:
    for(int z = 0; z < freq; z++) {
      int answer = Integer.MAX_VALUE;

      int seq = Integer.parseInt(br.readLine());
      StringTokenizer st =
          new StringTokenizer(br.readLine(), " ");
      Map<String, Integer> map = new HashMap<>();
      List<String> list = new ArrayList<>();

      // map + set 저장
      for(int i = 0; i < seq; i++) {
        String str = st.nextToken();
        if(map.containsKey(str)) {
          map.put(str, map.get(str) + 1);
        } else {
          map.put(str, 1);
        }
      }

      // 리스트 setting + key 3개 이상이면 0 insert
      for(String key : map.keySet()) {
        list.add(key);

        if(map.get(key) >= 3) {
          sb.append(0).append("\n");
          continue next;
        }
      }

      for(int i = 0; i < list.size(); i++) {
        for(int j = i; j < list.size(); j++) {
          for(int k = j; k < list.size(); k++) {
            if(i == j && j == k) {
              continue;
            }

            String aKey = list.get(i);
            String bKey = list.get(j);
            String cKey = list.get(k);

            if((aKey.equals(bKey) && map.get(aKey) == 2)
                || (bKey.equals(cKey) && map.get(bKey) == 2)
                || (aKey.equals(cKey) && map.get(aKey) == 2)
                || (!aKey.equals(bKey) && !aKey.equals(cKey) && !cKey.equals(bKey))) {
              answer =
                  Math.min(comp(aKey, bKey, cKey), answer);
            }
          }
        }
      }

      sb.append(answer).append("\n");
    }

    System.out.print(sb);
  }


  public static int comp(String aKey, String bKey, String cKey) {
    int returnValue = 0;

    for(int i = 0; i < 4; i++) {
      returnValue += aKey.charAt(i) != bKey.charAt(i) ? 1 : 0;
      returnValue += bKey.charAt(i) != cKey.charAt(i) ? 1 : 0;
      returnValue += cKey.charAt(i) != aKey.charAt(i) ? 1 : 0;
    }

    return returnValue;
  }
}