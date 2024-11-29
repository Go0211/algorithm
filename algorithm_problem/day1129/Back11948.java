package day1129;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Back11948 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a1 = Integer.parseInt(br.readLine());
        int a2 = Integer.parseInt(br.readLine());
        int a3 = Integer.parseInt(br.readLine());
        int a4 = Integer.parseInt(br.readLine());
        int b1 = Integer.parseInt(br.readLine());
        int b2 = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>(List.of(a1, a2, a3, a4));
        list.sort((x, y) -> y - x);

        System.out.println(list.get(0)+list.get(1)+list.get(2) + Math.max(b1, b2));
    }
}
