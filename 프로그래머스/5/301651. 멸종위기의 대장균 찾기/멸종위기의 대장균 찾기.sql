-- 코드를 작성해주세요

# 각 세대별 자식이 없는 개체의 수(COUNT)와 세대(GENERATION)를 출력하는 SQL문을 작성해주세요. 이때 결과는 세대에 대해 오름차순 정렬해주세요. 단, 모든 세대에는 자식이 없는 개체가 적어도 1개체는 존재합니다.
WITH RECURSIVE ECOLI_GENERATION AS (
    SELECT
        ID,
        1 as GENERATION
    FROM
        ECOLI_DATA
    WHERE PARENT_ID is NULL
    
    UNION ALL
    
    SELECT
        E.ID,
        EG.GENERATION +1 
    FROM
        ECOLI_DATA E
    JOIN
        ECOLI_GENERATION EG ON E.PARENT_ID = EG.ID
    

)
SELECT
    COUNT(EG.ID) COUNT,
    EG.GENERATION
FROM
    ECOLI_GENERATION EG
LEFT JOIN
    ECOLI_DATA E ON EG.ID = E.PARENT_ID
WHERE
    E.PARENT_ID IS NULL
GROUP BY
    EG.GENERATION
ORDER BY
    EG.GENERATION;