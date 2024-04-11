class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        // 아이디 길이는 3 ~ 15자
        // 알파벳 소문자, 숫자, -, _, . 만 사용 가능
        // .은 처음 X, 끝 X, 연속 X
        
        // 1단계 소문자로 치환
        answer = new_id.toLowerCase();
        
        // 2단계 제외 문자 삭제
        // []괄호 안 문자 확인, [^]는 제외
        // -,_,.,a~z,0~9 제외 나머지는 ""로 치환
        answer = answer.replaceAll("[^-_.a-z0-9]","");
        
        // 3단계 .이 두 번 이상 연속된 부분은 .으로 치환
        // \\. 이 +(2개 이상)인 경우 . 으로 치환
        answer = answer.replaceAll("\\.+", ".");
        
        // 4단계 .이 처음이나 끝이면 제거
        // ^[.] = .으로 시작, [.]$ = .으로 종료
        answer = answer.replaceAll("^[.]|[.]$", "");
        
        // 5단계 빈 문자열이면 a 넣기
        if(answer.equals("")) answer = "a";
        
        // 6단계 16자 이상이라면, 15개 제외 나머지 전부 제거
        if(answer.length() > 15) {
            answer = answer.substring(0, 15);
            // 여기서 잘랐는데 마지막이 .이면 안됨
            answer = answer.replaceAll("[.]$", "");
        }
        
        // 7단계 2자 이하라면, 마지막 문자를 길이가 3이 될 때까지 반복해서 끝에 붙임
        while(answer.length() < 3) {
            char c = answer.charAt(answer.length()-1);
            answer += c;
        }

        return answer;
    }
}