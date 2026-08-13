-- 코드를 입력하세요
with CTE as(
    select
        ugb.WRITER_ID,
        sum(ugb.PRICE) as TOTAL_SALES
    from USED_GOODS_BOARD ugb
    where ugb.STATUS = 'DONE'
    group by ugb.WRITER_ID
)
select
    ugu.USER_ID,
    ugu.NICKNAME,
    cte.TOTAL_SALES
from CTE cte
join USED_GOODS_USER ugu
on cte.WRITER_ID = ugu.USER_ID
where cte.TOTAL_SALES >= 700000
order by TOTAL_SALES;