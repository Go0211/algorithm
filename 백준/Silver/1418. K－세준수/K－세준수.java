import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		int count = 0;
		int[] arr = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			arr[i] = 1;
		}
		
		for(int i = (K + 1); i <= N; i++) {
			boolean decimal = true;
			for(int j = 2; j < i; j++) {
				if(i % j == 0) {
					decimal = false;
					break;
				}
			}
			if(decimal == true) {
				int j = 1;
				while(true) {
					if((i * j) > N) break;
					arr[i * j] = 0;
					j++;
				}
			}
		}
        
		for(int i = 1; i <= N; i++) {
			if(arr[i] == 1) count++;
		}
		System.out.println(count);
	}

}