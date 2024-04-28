class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        
        // 공격동안 진행
        int nowTime = 1;
        for(int i = 0; i < attacks.length; i++) {
            int attackTime = attacks[i][0];
            int damage = attacks[i][1];
            
            // 우선 공격시간 전까지 힐 된거 반영
            int tempTime = attackTime - nowTime; // 공격 직전 시간까지
            
            // 초당 회복 + 연속 추가 회복 - 최댓값은 30까지만
            answer = Math.min(health, answer + tempTime * bandage[1] + (tempTime/bandage[0]) * bandage[2]);
            // System.out.println("힐량 = " + tempTime * bandage[1]);
            // System.out.println("연속 붕대 치료 = " + (tempTime/bandage[0]) * bandage[2]);
            
            
            // 몬스터의 공격만큼 데미지받기
            answer -= attacks[i][1];
            // System.out.println("answer = " + answer);
            if(answer <= 0) return -1;
            nowTime = attackTime + 1;
            
        }
        
        
        return answer;
    }
}