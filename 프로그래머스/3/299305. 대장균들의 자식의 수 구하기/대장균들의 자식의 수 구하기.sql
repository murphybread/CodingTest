-- 코드를 작성해주세요

SELECT
    ed.ID,
    COUNT(child.ID) as CHILD_COUNT
FROM
    ECOLI_DATA  ed
LEFT JOIN
    ECOLI_DATA child
    ON ed.ID = child.PARENT_ID
GROUP BY
    ed.ID
ORDER BY
    ed.ID