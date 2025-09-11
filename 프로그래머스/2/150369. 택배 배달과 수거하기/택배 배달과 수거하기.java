import java.io.*;
import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        int dIdx = 0; 
        int pIdx = 0;
        
        for(int i = n - 1; i >= 0; i--) {
            if(deliveries[i] != 0) {
                dIdx = i;
                break;
            }
        }
        for(int i = n - 1; i >= 0; i--) {
            if(pickups[i] != 0) {
                pIdx = i;
                break;
            }
        }
        
        
        int nextDIdx = pIdx;
        int nextPIdx = dIdx;
        
        while(true) {
            if(dIdx == 0 && pIdx == 0 && deliveries[0] == 0 && pickups[0] == 0) {
                break;
            }
            
            int nowCap = cap;
            
            for(int i = dIdx; i >= 0; i--) {
                if(nowCap >= deliveries[i]) {
                    nowCap -= deliveries[i];
                    deliveries[i] = 0;
                    dIdx = i;
                    continue;
                }
                
                deliveries[i] -= nowCap;
                dIdx = i;
                break;
            }
            
            nowCap = cap;
            for(int i = pIdx; i >= 0; i--) {
                if(nowCap >= pickups[i]) {
                    nowCap -= pickups[i];
                    pickups[i] = 0;
                    pIdx = i;
                    continue;
                }
                
                pickups[i] -= nowCap;
                pIdx = i;
                break;
            }
            
            answer += (Math.max(nextDIdx, nextPIdx) + 1) * 2;
            
            // System.out.println(answer);
            
            nextDIdx = dIdx;
            nextPIdx = pIdx;
        }
        
        return answer;
    }
}