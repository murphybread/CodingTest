-- 코드를 작성해주세요
# 아이템의 희귀도가 'RARE'인 아이템들
WITH RARES AS (
    SELECT
        ITEM_ID
    FROM
        ITEM_INFO 
    WHERE
        RARITY ='RARE'

), T AS (
    SELECT
        IT.ITEM_ID
    FROM
        ITEM_TREE IT
    JOIN RARES
        R ON R.ITEM_ID = IT.PARENT_ITEM_ID

)

SELECT 
    IT.ITEM_ID,
    IT.ITEM_NAME,
    IT.RARITY
FROM
    ITEM_INFO IT
JOIN T
    ON T.ITEM_ID = IT.ITEM_ID
ORDER BY
    IT.ITEM_ID DESC


    
    

# 다음 업그레이드 아이템의 아이템 ID(ITEM_ID), 아이템 명(ITEM_NAME), 아이템의 희귀도(RARITY)를 출력하는 SQL 문을 작성해 주세요. 이때 결과는 아이템 ID를 기준으로 내림차순 정렬주세요.