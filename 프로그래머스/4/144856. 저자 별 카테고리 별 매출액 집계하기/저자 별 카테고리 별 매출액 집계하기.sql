-- 2022년 1월 도서 판매 데이터 기준
-- 저자, 카테고리 별 매출액(TOTAL_SALES = 판매량 * 판매가)
-- 저자 ID, 저자명, 카테고리, 매출액 리스트 SQL 작성
-- 저자 ID 오름차순, 카테고리 내림차순

SELECT 
    b.AUTHOR_ID,
    b.AUTHOR_NAME,
    a.CATEGORY,
    SUM(a.PRICE * c.SALES)AS TOTAL_SALES
FROM BOOK AS a
JOIN AUTHOR AS b ON a.AUTHOR_ID = b.AUTHOR_ID
JOIN BOOK_SALES AS c ON a.BOOK_ID = c.BOOK_ID
WHERE
    YEAR(c.SALES_DATE) = '2022' AND
    MONTH(c.SALES_DATE) = '01'
GROUP BY 
    b.AUTHOR_ID,
    a.CATEGORY
ORDER BY
    a.AUTHOR_ID ASC,
    a.CATEGORY DESC
;