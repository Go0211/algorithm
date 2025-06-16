import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception{
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    while(true){
      String s = br.readLine();
      if(s.equals("end")) {
        break;
      }

      boolean aeiou = false;
      boolean isDouble = true;
      boolean jmFlag = true;
      int isAeiouCount = 0;
      int notAeiouCount = 0;

      for(int i = 0 ; i< s.length(); i++){
        char c = s.charAt(i);
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
          aeiou = true;
          isAeiouCount++;
          notAeiouCount = 0;
          if(isAeiouCount >= 3){
            jmFlag = false;
            break;
          }
        }else{
          notAeiouCount++;
          isAeiouCount = 0;
          if(notAeiouCount >= 3){
            jmFlag = false;
            break;
          }
        }

        if(i >= 1){
          if(c != 'e' && c != 'o'){
            if(c == s.charAt(i-1)) isDouble = false;
          }
        }
      }

      if(jmFlag && isDouble && aeiou){
        System.out.println("<" + s + "> is acceptable.");
      }else{
        System.out.println("<" + s + "> is not acceptable.");
      }
    }
  }

}