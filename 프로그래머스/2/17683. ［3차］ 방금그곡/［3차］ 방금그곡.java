import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        PriorityQueue<String[]> pq = new PriorityQueue<>((o1, o2) -> Integer.parseInt(o2[1]) - 
                                                         Integer.parseInt(o1[1]));
        
        // 네오가 들은 음 m, 음악 정보 musicinfos
        String[][] infos = new String[musicinfos.length][4];
        
        // 들은 음악 대체
        m = change(m);
        
        // 음악 정보 대체
        for(int i = 0; i < musicinfos.length; i++) {
            String[] temp = musicinfos[i].split(",");
            temp[3] = change(temp[3]);
            
            for(int j = 0; j < 4; j++) {
                infos[i][j] = temp[j];
            }
            
            // 들은 시간만큼 들은 음악의 길이를 늘려줘야 한다
            int playTime = getTime(infos[i][1]) - getTime(infos[i][0]);
            int len = infos[i][3].length();
            
            String total = repeatMusic(playTime, infos[i][3]);
            
            if(total.contains(m)) {
                String[] info = {infos[i][2], String.valueOf(playTime)};
                pq.offer(info);
            }
            
        }
        
        if(!pq.isEmpty()) {
            return pq.poll()[0];
        }
        
        return answer;
    }
    
    // 음악 길이를 줄이거나 늘리는 메서드
    static String repeatMusic(int playTime, String s) {
        int len = s.length();
        
        // 음악 길이보다 재생시간이 짧으면 해당 길이 만큼 잘라서 반환
        if(playTime <= len) {
            return s.substring(0, playTime);
        }
        
        // 재생시간이 더 길면, 음악 길이를 늘려서 반환
        int val = playTime / len;
        int r = playTime % len;
        String temp = "";
        for(int i = 0; i < val; i++) {
            temp += s;
        }
        
        temp += s.substring(0, r);
        
        
        return temp;
    }
    
    // 재생 시간을 구하는 메서드
    static int getTime(String s) {
        int hour = Integer.parseInt(s.split(":")[0]) * 60;
        int minute = Integer.parseInt(s.split(":")[1]);
        
        return hour + minute;
    }
    
    
    // #이 들어간 음을 변환하는 메서드
    static String change(String s) {
        // C#, D#, F#, G#, A#을 다른 단어로 대체하자
        // H, I, J, K, L로 각각 대체
        
        String[] changeFrom = {"C#", "D#", "F#", "G#", "A#", "B#"};
        String[] changeTo = {"H", "I", "J", "K", "L", "N"};
        
        for(int i = 0; i < changeFrom.length; i++) {
            s = s.replaceAll(changeFrom[i], changeTo[i]);
        }
        
        return s;
    }
    
}