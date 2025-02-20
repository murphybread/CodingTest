-- 코드를 입력하세요
WITH C AS (
        SELECT
        *
    FROM
        JULY J
    UNION ALL
    SELECT
        *
    FROM
        FIRST_HALF F
)
SELECT
    FLAVOR
FROM
    C
GROUP BY
    C.FLAVOR
ORDER BY
    SUM(TOTAL_ORDER) DESC
LIMIT 3