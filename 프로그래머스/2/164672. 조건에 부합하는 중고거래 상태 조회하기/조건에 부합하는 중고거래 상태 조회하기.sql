-- 코드를 입력하세요
SELECT B.BOARD_ID, B.WRITER_ID, B.TITLE, B.PRICE,
    CASE
        WHEN STATUS = 'SALE' THEN '판매중'
        WHEN STATUS = 'RESERVED' THEN '예약중'
        WHEN STATUS = 'DONE' THEN '거래완료'
    END STATUS
FROM USED_GOODS_BOARD B
WHERE CREATED_DATE = '2022-10-05'
ORDER BY BOARD_ID DESC