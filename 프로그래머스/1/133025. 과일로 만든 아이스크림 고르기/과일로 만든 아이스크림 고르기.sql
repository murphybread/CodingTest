# SHIPMENT_ID, FLAVOR, TOTAL_ORDER 는 각각 아이스크림 공장에서 아이스크림 가게까지의 출하 번호, 아이스크림 맛, 상반기 아이스크림 총주문량을 나타냅니다. FIRST_HALF 테이블의 기본 키는 FLAVOR입니다.

# LAVOR, INGREDITENT_TYPE 은 각각 아이스크림 맛, 아이스크림의 성분 타입을 나타냅니다. INGREDIENT_TYPE에는 아이스크림의 주 성분이 설탕이면 sugar_based라고 입력되고, 아이스크림의 주 성분이 과일이면 fruit_based라고 입력됩니다. ICECREAM_INFO의 기본 키는 FLAVOR입니다.

# ICECREAM_INFO테이블의 FLAVOR는 FIRST_HALF 테이블의 FLAVOR의 외래 키입니다.

# 상반기 아이스크림 총주문량이 3,000보다 높으면서 아이스크림의 주 성분이 과일인 아이스크림의 맛을 총주문량이 큰 순서대로 조회하는 SQL 문을 작성해주세요.
-- 코드를 입력하세요
SELECT
    FH.FLAVOR
FROM
    FIRST_HALF FH
JOIN 
    ICECREAM_INFO II  ON II.FLAVOR = FH.FLAVOR
WHERE
    FH.TOTAL_ORDER > 3000
    AND II.INGREDIENT_TYPE = 'fruit_based'
GROUP BY
    FH.FLAVOR
ORDER BY
    FH.TOTAL_ORDER DESC
    
    