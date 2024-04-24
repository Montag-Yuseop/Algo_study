class Solution {
    
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        /**
        1, 2, 3이 연결되어있고, 4, 5가 연결되어있고, 6이 연결되어있으면
        이건 총 3개 네트워크잖아
        그러면 저 컴퓨터 정보를 활용해서 방문처리해줘. 그러면 연결된애들은 다음에 탐색안되도록
        연결 안된애들은 탐색해서 다시 방문처리 해주고
        깊이 우선 탐색으로 하나의 정점에서 연결된 애들을 다 처리해줄 예정
        
        깊이 우선 탐색에서 방문처리를 해주면 -> 저 visited 배열을 공용으로 쓰잖아
        0을 탐색해서 얘랑 연결된걸 찾았어, 그럼 걔도 true 처리 되면, 다음 탐색에서 조건에 걸려가지고 걔는 탐색을 안해
        !visited[i] 조건에 걸려서
        
        **/
        visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(n, i, computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    static public void dfs(int n, int now, int[][] computers) {
        visited[now] = true;
        
        for(int i = 0; i < computers[now].length; i++) {
            if(computers[now][i] == 1 && !visited[i]) {
                dfs(n, i, computers);
            }
        }
        
    }
    
}