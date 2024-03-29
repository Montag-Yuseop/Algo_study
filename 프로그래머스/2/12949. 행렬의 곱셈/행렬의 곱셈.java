class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        /**
        
        1,4  3,3    15,15
        3,2  3,3 -> 15,15
        4,1         15,15
        
        [0][0] = arr1[0][0] * arr2[0][0] + arr1[0][1] * arr2[1][0]
        [0][1] = arr1[0][0] * arr2[0][1] + arr1[0][1] * arr2[1][1]
        [1][0] = arr1[1][0] * arr2[0][0] + arr1[1][1] * arr2[1][0]
        [1][1] = arr1[1][0] * arr2[0][1] + arr1[1][1] * arr2[1][1]
        [2][0] = arr1[2][0] * arr2[0][0] + arr1[2][1] * arr2[1][0]
        [2][1] = arr1[2][0] * arr2[0][1] + arr1[2][1] * arr2[1][1]
        */
        
        for(int i = 0; i < arr1.length; i++) {
            for(int j = 0; j < arr2[0].length; j++) {
                int temp = 0;
                for(int k = 0; k < arr2.length; k++) {
                    temp += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = temp;
            }
            
        }
        
        return answer;
    }
}