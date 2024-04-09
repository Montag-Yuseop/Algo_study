class Solution {
    int[] answer;
    public int[] solution(int[][] arr) {
        answer = new int[2];
        int size = arr.length;
        dvide(0, 0, size, arr); // 시작 x, 시작 y, 길이, 배열
        
        return answer;
    }
    
    public void dvide(int startX, int startY, int size, int[][] arr) {
        // 종료 조건(배열 순회 결과 모든 수가 같을 때)
        if(check(startX, startY, size, arr)) {
            answer[arr[startX][startY]]++;
            return;
        }
        
        dvide(startX, startY, size / 2, arr); // 2사분면
        dvide(startX + size/2, startY, size / 2, arr); // 1사분면
        dvide(startX, startY + size/2, size / 2, arr); // 3사분면
        dvide(startX + size/2, startY+ size/2, size / 2, arr); // 4사분면
        
    }
    
    public boolean check(int x, int y, int size, int[][] arr) {
        for(int i = x; i < x + size; i++) {
            for(int j = y; j < y + size; j++) {
                if(arr[x][y] != arr[i][j]) return false;
            }
        }
        return true;
    }
}