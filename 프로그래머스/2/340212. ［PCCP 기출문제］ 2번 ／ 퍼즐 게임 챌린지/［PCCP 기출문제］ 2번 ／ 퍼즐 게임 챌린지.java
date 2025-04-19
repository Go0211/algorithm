class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int level = 0;
        int maxLevel = 100_000;
        int minLevel = 1;
        
        next:
        while(minLevel <= maxLevel) {
            int size = diffs.length;
            long totalCount = 0;
            int prevCount = 0;
            level = (minLevel + maxLevel) / 2;
            
            for(int i = 0; i < size; i++) {
                int diff = diffs[i];
                int time = times[i];
                
                totalCount += time;
                
                if(diff > level) {
                    totalCount += (prevCount + time)  * (diff - level);
                }
                
                prevCount = time;
                
                if(limit < totalCount) {
                    minLevel = level + 1;
                    continue next;
                }
            }
            maxLevel = level - 1;
        }
        
        return minLevel;
    }
}