# 2022년 10월에 작성된 게시글
# 게시글 제목, 게시글 ID, 댓글 ID, 댓글 작성자 ID, 댓글 내용, 댓글 작성일을 조회하는 SQL

# 결과는 댓글 작성일을 기준으로 오름차순 정렬해주시고, 댓글 작성일이 같다면 게시글 제목을 기준으로 오름차순 정렬
-- 코드를 입력하세요
SELECT
    UGB.TITLE,
    UGR.BOARD_ID,
    UGR.REPLY_ID,
    UGR.WRITER_ID,
    UGR.CONTENTS,
    DATE_FORMAT(UGR.CREATED_DATE, '%Y-%m-%d') CREATED_DATE
FROM
    USED_GOODS_BOARD UGB  
JOIN
    USED_GOODS_REPLY UGR ON UGB.BOARD_ID = UGR.BOARD_ID
WHERE
    MONTH(UGB.CREATED_DATE) = 10
ORDER BY
    UGR.CREATED_DATE,
    UGB.TITLE
    