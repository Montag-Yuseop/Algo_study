import java.util.*;

class Solution {
    
    static Map<String, Integer>[] map = new HashMap[21];
    static boolean[] visited;
    static int[] max = new int[21];
    
    public List<String> solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        for(int i = 0; i < 21; i++) {
            map[i] = new HashMap<>();
        }
        
        for(String s : orders) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            for(int i : course) {
                if(c.length < i) continue;
                visited = new boolean[s.length()];
                dfs(c, "", 0, i, 0); // 전체 주문, 현재 선택된 주문, 현재 depth, 전체 depth, 방문 배열
            }
        }
        
        for(int i : course) {
            if(max[i] < 2) continue;
            for(String s : map[i].keySet()) {
                if(map[i].get(s) == max[i]) {
                    answer.add(s);
                }
            }
        }
        
        Collections.sort(answer);
        
        // System.out.println(Arrays.toString(map));
        return answer;
    }
    
    static void dfs(char[] total, String select, int now, int depth, int idx) {
        if(now == depth) {
            if(select.equals("CB")) {
                System.out.println(now +" "+depth+" "+idx);
                System.out.println(Arrays.toString(visited));
            }   
            
            map[depth].put(select, map[depth].getOrDefault(select, 0) + 1);
            max[depth] = Math.max(max[depth], map[depth].getOrDefault(select, 0));
            return;
        }

        for(int i = idx; i < total.length; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            dfs(total, select + total[i], now + 1, depth, i);
            visited[i] = false;
        }
        
    }
}