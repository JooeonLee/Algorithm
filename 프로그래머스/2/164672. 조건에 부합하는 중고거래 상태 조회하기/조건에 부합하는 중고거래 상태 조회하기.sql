-- 코드를 입력하세요
select
    ugb.BOARD_ID,
    ugb.WRITER_ID,
    ugb.TITLE,
    ugb.PRICE,
    case
        when ugb.STATUS='SALE' then '판매중'
        when ugb.STATUS='RESERVED' then '예약중'
        when ugb.STATUS='DONE' then '거래완료'
    end as `STATUS`
from USED_GOODS_BOARD ugb
where ugb.CREATED_DATE = '2022-10-05'
order by ugb.BOARD_ID desc;