# SKILL_CODE 2진수 변환 , 모든 스킬 추출
# 
-- 코드를 작성해주세요
WITH P_C_CODES AS (
    SELECT CODE
    FROM SKILLCODES 
    WHERE NAME = 'Python' OR NAME = 'C#'
)
SELECT
    ID,
    EMAIL,
    FIRST_NAME,
    LAST_NAME
FROM
    DEVELOPERS 
WHERE
    EXISTS(
        SELECT 1
        FROM P_C_CODES 
        WHERE (DEVELOPERS.SKILL_CODE & P_C_CODES.CODE) > 0
    )
    
ORDER BY
    ID