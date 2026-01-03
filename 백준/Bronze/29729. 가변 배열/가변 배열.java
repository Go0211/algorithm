import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
            new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
    	int cur = 0;
	    int add = Integer.parseInt(st.nextToken());
    	int delete = Integer.parseInt(st.nextToken());
	    for (int i = 0; i < add + delete; i++) {
    		if(Integer.parseInt(br.readLine()) == 1){
	    		cur++;
		    	if(size < cur){
    				size *=2;
	    		}
		    }
    		else{
	    		cur--;
		    }
    	}
	    System.out.println(size);
    }
}