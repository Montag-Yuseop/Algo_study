class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int[][] temp = new int[sizes.length][2];
        int maxW = Integer.MIN_VALUE;
        int maxH = Integer.MIN_VALUE;
        
        for(int i = 0; i < sizes.length; i++) {
            temp[i][0] = Math.max(sizes[i][0], sizes[i][1]);
            temp[i][1] = Math.min(sizes[i][0], sizes[i][1]);
        }
        
        for(int i = 0; i < temp.length; i++) {
            maxW = Math.max(maxW, temp[i][0]);
            maxH = Math.max(maxH, temp[i][1]);
        }
        
        answer = maxW * maxH;
        
        
        return answer;
    }
}