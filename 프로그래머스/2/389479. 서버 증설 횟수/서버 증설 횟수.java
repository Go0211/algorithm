import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = 
            new PriorityQueue<>((x, y) -> x - y);
        
        for(int i = 0; i < players.length; i++) {
            int peopleCount = players[i];
            
            // pq의 서버 만료시간 판단
            while(!pq.isEmpty() && pq.peek() < i) {
                pq.remove();
            }
            
            //추가인원을 감당할 수 있을 때까지, pq.add + answer 증가
            while(peopleCount > pq.size() * m + m - 1) {
                pq.add(i + k - 1);
                answer++;
            }
        }
        return answer;
    }
}