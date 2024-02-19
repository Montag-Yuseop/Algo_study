-- 코드를 입력하세요
SELECT PT_NAME, PT_NO, GEND_CD, AGE, ifnull(tlno, 'NONE') TLNO
FROM patient
WHERE age <= 12 AND gend_cd like 'W'
ORDER BY age desc, pt_name asc
;