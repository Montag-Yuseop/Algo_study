-- 코드를 입력하세요
SELECT 
    a.CATEGORY,
    SUM(b.SALES) AS TOTAL_SALES
FROM BOOK AS a
JOIN BOOK_SALES AS b
ON a.BOOK_ID = b.BOOK_ID
WHERE
    YEAR(b.SALES_DATE) = '2022' AND
    MONTH(b.SALES_DATE) = '01'
GROUP BY
    a.CATEGORY
ORDER BY
    a.CATEGORY ASC
    ;