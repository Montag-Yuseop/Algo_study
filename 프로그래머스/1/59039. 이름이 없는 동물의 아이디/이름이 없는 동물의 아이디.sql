-- 이름이 없는 채로 들어온 동물 ID 조회 SQL
SELECT
    ANIMAL_ID
FROM
    ANIMAL_INS
WHERE
    NAME IS NULL
ORDER BY
    ANIMAL_ID
;