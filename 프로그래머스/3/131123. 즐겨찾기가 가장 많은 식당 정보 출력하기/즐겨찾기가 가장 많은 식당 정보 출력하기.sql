-- 코드를 입력하세요
WITH MAX_FAVORITES AS (
    SELECT
        FOOD_TYPE,
        MAX(FAVORITES) MF
    FROM
        REST_INFO
    GROUP BY
        FOOD_TYPE
    
)
SELECT
    R.FOOD_TYPE,
    R.REST_ID,
    R.REST_NAME,
    R.FAVORITES
FROM
    REST_INFO  R
JOIN
    MAX_FAVORITES on MAX_FAVORITES.MF = R.FAVORITES
    and MAX_FAVORITES.FOOD_TYPE = R.FOOD_TYPE
ORDER BY
    R.FOOD_TYPE DESC