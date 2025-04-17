class Solution {
    public String solution(
        String video_len, 
        String pos, 
        String op_start, 
        String op_end, 
        String[] commands
    ) {
        String answer = "";
        int fullSecond = 
            Integer.parseInt(video_len.split(":")[0]) * 60 + 
            Integer.parseInt(video_len.split(":")[1]);
        int nowSecond = 
            Integer.parseInt(pos.split(":")[0]) * 60 + 
            Integer.parseInt(pos.split(":")[1]);
        int opStartSecond = 
            Integer.parseInt(op_start.split(":")[0]) * 60 + 
            Integer.parseInt(op_start.split(":")[1]);
        int opEndSecond = 
            Integer.parseInt(op_end.split(":")[0]) * 60 + 
            Integer.parseInt(op_end.split(":")[1]);
        
        for(String str : commands) {
            if(opStartSecond <= nowSecond && nowSecond <= opEndSecond) {
                nowSecond = opEndSecond;
            }
            
            switch(str) {
                    case "next":
                        nowSecond += 10;
                        
                        if(fullSecond < nowSecond) {
                            nowSecond = fullSecond;
                        }
                    
                        break;
                    case "prev":
                        nowSecond -= 10;
                        
                        if(0 > nowSecond) {
                            nowSecond = 0;
                        }
                        break;
            }
        }
        
        if(opStartSecond <= nowSecond && nowSecond <= opEndSecond) {
            nowSecond = opEndSecond;
        }
        
        String hour = 
            (nowSecond / 60) > 9 ? 
            (nowSecond / 60) + "" : 
            "0" + (nowSecond / 60); 
        String minute = 
            (nowSecond % 60) > 9 ? 
            (nowSecond % 60) + "" : 
            "0" + (nowSecond % 60); 
        
        return hour + ":" + minute;
    }
}