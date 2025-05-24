import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st =
        new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    int userCount = Integer.parseInt(st.nextToken());
    int folderCount = Integer.parseInt(st.nextToken());
    Map<Character, String> accessMap = new HashMap<>();
    accessMap.put('7', "RWX");
    accessMap.put('6', "RW");
    accessMap.put('5', "RX");
    accessMap.put('4', "R");
    accessMap.put('3', "WX");
    accessMap.put('2', "W");
    accessMap.put('1', "X");
    accessMap.put('0', "");

    Map<String, List<String>> gm = new HashMap<>();
    Map<String, Map<String, String>> um = new HashMap<>();

    // 유저 + 그룹 map
    for(int i = 0; i < userCount; i++) {
      st = new StringTokenizer(br.readLine());
      String value = st.nextToken();
      if (!gm.containsKey(value)) {
        gm.put(value, new ArrayList<>());
        gm.get(value).add(value);
      }

      if(st.hasMoreTokens()) {
        StringTokenizer st2 =
            new StringTokenizer(st.nextToken(), ",");
        while(st2.hasMoreTokens()) {
          String key = st2.nextToken();
          if (!gm.containsKey(key)) {
            gm.put(key, new ArrayList<>());
          }
          gm.get(key).add(value);
        }
      }
    }

    // 폴더별 사용자 접근제어자 map
    for(int i = 0; i < folderCount; i++) {
      st = new StringTokenizer(br.readLine());

      String folder = st.nextToken();
      String access = st.nextToken();
      String owner = st.nextToken();
      String group = st.nextToken();

      um.put(folder, new HashMap<>());

      um.get(folder).put(owner, accessMap.get(access.charAt(0)));
      for (String g : gm.getOrDefault(group, Collections.emptyList())) {
//        if (!g.equals(owner)) {
//          um.get(folder).put(g, accessMap.get(access.charAt(1)));
//        }
        um.get(folder).putIfAbsent(g, accessMap.get(access.charAt(1)));
      }
      um.get(folder).put("other", accessMap.get(access.charAt(2)));
    }

    int activeCount = Integer.parseInt(br.readLine());

    for(int i = 0; i < activeCount; i++) {
      st = new StringTokenizer(br.readLine());
      String user = st.nextToken();
      String folder = st.nextToken();
      char access = st.nextToken().charAt(0);

      boolean isTrue = false;
      String targetAccess;
      if(!um.get(folder).containsKey(user)) {
        targetAccess = um.get(folder).get("other");
      } else {
        targetAccess = um.get(folder).get(user);
      }

      for(int j = 0; j < targetAccess.length(); j++) {
        if(access == targetAccess.charAt(j)) {
          isTrue = true;
          break;
        }
      }

      sb.append(isTrue ? 1 : 0)
          .append("\n");
    }

    System.out.println(sb);
  }
}