package problem.day1026;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//(A+B)×(A-B)

class Back32154 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());

        String[][] board = {{"11", "A B C D E F G H J L M"},
                {"9", "A C E F G H I L M"},
                {"9", "A C E F G H I L M"},
                {"9", "A B C E F G H L M"},
                {"8", "A C E F G H L M"},
                {"8", "A C E F G H L M"},
                {"8", "A C E F G H L M"},
                {"8", "A C E F G H L M"},
                {"8", "A C E F G H L M"},
                {"8", "A B C F G H L M"}};

        System.out.println(board[a - 1][0]);
        System.out.println(board[a - 1][1]);

//		if(a == 1) {
//			System.out.println(11);
//			System.out.println("A B C D E F G H J L M");
//		} else if(a == 2 && a == 3) {
//			System.out.println(9);
//			System.out.println("A C E F G H I L M");
//		} else if(a == 4){
//			System.out.println(9);
//			System.out.println("A B C E F G H L M");
//		} else if(a >= 5 && a <= 9){
//			System.out.println(8);
//			System.out.println("A C E F G H L M");
//		} else {
//			System.out.println(8);
//			System.out.println("A B C F G H L M");
//		}

    }
}

