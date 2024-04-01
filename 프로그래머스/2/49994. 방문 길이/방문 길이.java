class Solution {
    public int solution(String dirs) {
        int answer = 0;
        
        // UDRL에 따라 변하는 x,y 좌표값을 저장하고
        // 이 값을 저장, 해당 값이 존재하는지 확인하고 없으면 +, 있으면 그대로
        
        // 2차원 방문 배열을 만들어서 0,0부터 10, 10까지 100개짜리 생성
        // boolean[11][11]
        
        boolean[][][] visited = new boolean[11][11][4];
        int nowR = 5;
        int nowC = 5;
        
        // -5씩 진행
        
        for(int i = 0; i < dirs.length(); i++) {
            char c = dirs.charAt(i);
            
            switch(c) {
                case 'U' : // 위로 한칸
                    if(bc(nowR-1, nowC)) {
                        nowR -= 1;
                        if(!visited[nowR][nowC][0]) {
                            visited[nowR+1][nowC][3] = true;
                            visited[nowR][nowC][0] = true;
                            answer++;
                        }
                    }
                    
                    break;
                case 'L' : // 좌로 한칸
                    if(bc(nowR, nowC-1)) {
                        nowC -= 1;
                        if(!visited[nowR][nowC][1]) {
                            visited[nowR][nowC+1][2] = true;
                            visited[nowR][nowC][1] = true;
                            answer++;
                        }
                    }
                    break;
                case 'R' : // 우로 한칸
                    if(bc(nowR, nowC+1)) {
                        nowC += 1;
                        if(!visited[nowR][nowC][2]) {
                            visited[nowR][nowC-1][1] = true;
                            visited[nowR][nowC][2] = true;
                            answer++;
                        }
                    }
                    break;
                    
                case 'D' : // 아래로 한칸
                    if(bc(nowR+1, nowC)) {
                        nowR += 1;
                        if(!visited[nowR][nowC][3]) {
                            visited[nowR-1][nowC][0] = true;
                            visited[nowR][nowC][3] = true;
                            answer++;
                        }
                    }
                    break;
                
            }
            
            
        }
        
        
        return answer;
    }
    
    static boolean bc(int r, int c) {
        return r >= 0 && c >= 0 && r <= 10 && c <= 10;
    }
}