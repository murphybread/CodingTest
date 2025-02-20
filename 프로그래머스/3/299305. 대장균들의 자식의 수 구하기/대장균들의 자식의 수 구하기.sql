# 대장균 개체의 ID(ID)와 자식의 수(CHILD_COUNT)를 출력하는 SQL 문을 작성해주세요. 자식이 없다면 자식의 수는 0으로 출력해주세요. 이때 결과는 개체의 ID 에 대해 오름차순 정렬해주세요.

-- 코드를 작성해주세요
WITH EC AS (
    SELECT
        PARENT_ID
    FROM
        ECOLI_DATA
    WHERE
        PARENT_ID is not null
)
SELECT
    
    ED.ID,
    CASE
        WHEN EC.PARENT_ID is null then 0
        ELSE
            COUNT(*)   
    END CHILD_COUNT
    
FROM
    ECOLI_DATA ED
LEFT JOIN EC
    ON ED.ID  = EC.PARENT_ID
GROUP BY
    ED.ID


