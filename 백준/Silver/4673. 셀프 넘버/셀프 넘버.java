public class Main {
  public static void main(String[] args) {
    boolean[] check = new boolean[10001];	// 1부터 10000이므로

    for (int i = 1; i < 10001; i++){
      int n = calculateMethod(i);

      if(n < 10001){	// 10000 이 넘는 수는 필요가 없음
        check[n] = true;
      }
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 1; i < 10001; i++) {
      if (!check[i]) {	// false 인 인덱스만 출력
        sb.append(i).append('\n');
      }
    }
    System.out.println(sb);
  }

  public static int calculateMethod(int number){
    int sum = number;

    while(number != 0){
      sum = sum + (number % 10);
      number = number/10;
    }

    return sum;
  }
}