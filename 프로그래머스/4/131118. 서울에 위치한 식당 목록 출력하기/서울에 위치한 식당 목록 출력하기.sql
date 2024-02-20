-- 코드를 입력하세요
-- 테이블 REST_INFO, REST_REVIEW
-- 서울에 위치한 식당들의 
-- REST_INFO = 식당 ID, 식당이름, 음식 종류, 즐겨찾기 수, 주소, 
-- REST_REVIEW = 식당 ID를 통한 리뷰 평균 점수 조회

SELECT
    a.REST_ID,
    a.REST_NAME,
    a.FOOD_TYPE,
    a.FAVORITES,
    a.ADDRESS,
    ROUND(AVG(b.REVIEW_SCORE), 2) SCORE
FROM REST_INFO AS a
JOIN REST_REVIEW AS b
ON a.REST_ID = b.REST_ID
GROUP BY b.REST_ID
HAVING a.ADDRESS like '서울%'
ORDER BY SCORE DESC,
    a.FAVORITES DESC;
