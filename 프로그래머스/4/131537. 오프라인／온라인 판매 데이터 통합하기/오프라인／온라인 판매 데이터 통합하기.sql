-- 코드를 입력하세요
SELECT 
    DATE_FORMAT(SALES_DATE, "%Y-%m-%d") SALES_DATE,
    PRODUCT_ID, 
    USER_ID,
    SALES_AMOUNT
FROM
    ONLINE_SALE
WHERE
    -- SALES_DATE >= '2022-03-01' AND SALES_DATE < '2022-04-01'
    MONTH(SALES_DATE) = 3
    
UNION ALL

SELECT 
    DATE_FORMAT(SALES_DATE, "%Y-%m-%d") SALES_DATE,
    PRODUCT_ID, 
    NULL AS USER_ID,
    SALES_AMOUNT
FROM 
    OFFLINE_SALE
WHERE 
    -- SALES_DATE >= '2022-03-01' AND SALES_DATE < '2022-04-01'
    MONTH(SALES_DATE) = 3
ORDER BY 
    SALES_DATE, PRODUCT_ID, USER_ID
;