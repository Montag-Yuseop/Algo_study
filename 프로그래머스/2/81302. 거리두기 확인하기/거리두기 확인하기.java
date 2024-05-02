import java.util.*;

class Solution {
    static class Node {
        int r, c;
        
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        int idx = 0;
        
        // place[i]번의 정보로 탐색
        for (String[] s : places) {
            // s의 배열을 잘라서 정보를 담은 방을 만들자
            char[][] nowRoom = new char[5][5]; // 5x5의 방
            ArrayList<Node> adj = new ArrayList<>(); // P 정보를 저장
            
            for(int r= 0; r < 5; r++) {
                for(int c = 0; c < 5; c++) {
                    nowRoom[r][c] = s[r].charAt(c);
                    if(nowRoom[r][c] == 'P') {
                        adj.add(new Node(r, c));
                    }
                }
            }
            
            // 사람이 1도 없으면 그냥 0 입력 후 넘어가기
            if(adj.size() == 0) {
                answer[idx++] = 1;
                continue;
            }
            
            // 사람이 있으면, adj의 처음부터 다음 사람과의 거리 체크하기
            // 맨해튼 거리가 3이상이면 true, 이하면 false
            // 맨해튼 거리가 true여도, 가운데 파티션으로 막혀있는지 체크해보기
            if(isFar(nowRoom, adj)) answer[idx++] = 1;
            else idx++;
        }
        
        
        return answer;
    }
    
    static boolean isFar(char[][] map, ArrayList<Node> adj) {
        // adj를 2번 돌자
        for(int i = 0; i < adj.size() - 1; i++) {
            Node now = adj.get(i);
            int nowR = now.r;
            int nowC = now.c;
            
            // 다음 Node와 비교하자
            for(int j = i + 1; j < adj.size(); j++) {
                Node next = adj.get(j);
                int nextR = next.r;
                int nextC = next.c;
                
                // 거리를 비교하는 로직(딱 붙은 경우 - 거리가 1인 경우는 그냥 불가능)
                int dis = Math.abs(nextR - nowR) + Math.abs(nextC - nowC);

                if(dis <= 1) return false;
                
                // 거리가 2일때 파티션이 있는지 판단하는 로직
                if(dis == 2) {
                    // 같은 열에 있을 때
                    if(nowR == nextR) {
                        if(map[nowR][Math.min(nowC, nextC) + 1] != 'X') return false;
                    } 
                    // 같은 행에 있을 때
                    else if(nowC == nextC) {
                        if(map[Math.min(nowR, nextR) + 1][nowC] != 'X') return false;
                    }
                    // 대각선 한칸에 있을 때
                    else {
                        // 0,0 - 1,1 그리고 0,2 - 1,1
                        // R은 nowR이 항상 위임
                        if(nowC > nextC) {
                            if(map[nowR][nowC-1] != 'X' || map[nextR][nextC+1] != 'X') return false;
                        } else {
                            if(map[nowR][nowC + 1] != 'X' || map[nextR][nextC-1] != 'X') return false;
                        }
                            
                    }
                }
            }
            
        }
        
        return true;
    }
}